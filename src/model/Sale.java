package model;

import integration.DiscountHandler;
import integration.ItemDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * One single sale made by one single customer and paid with one payment.
 */
public class Sale {
    private LocalDate saleDate;
    private LocalTime saleTime;
    private Receipt receipt;
    private final ArrayList<ItemDTO> soldItems;
    private CashPayment payment;
    private List<TotalRevenueObserver> totalRevenueObservers = new ArrayList<>();
    private Amount discountedTotal;
    private DiscountHandler discountHandler;
    private Amount totalCost;

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale(){
        setDateOfSale();
        setTimeOfSale();
        this.soldItems = new ArrayList<>();
    }

    public void applyDiscount(DiscountHandler discountHandler){
        this.discountHandler = discountHandler;
        this.totalCost = getTotalCostAmount();
        this.discountedTotal = discountHandler.applyDiscount(totalCost);
    }

    /**
     * Gets the total cost.
     *
     * @return The total cost.
     */
    public Amount getTotalCostAmount(){
        return totalCost != null ? totalCost : calculateTotalCost();
    }

    private Amount calculateTotalCost(){
        Amount sumOfTotalCost = new Amount(0);
        for(ItemDTO item : soldItems){
            Amount totalItemPrice = calculateTotalItemPrice(item);
            sumOfTotalCost = sumOfTotalCost.add(totalItemPrice);
        }
        return sumOfTotalCost;
    }

    public Amount getAmountToPay(){
        return isDiscountApplied() ? discountedTotal : getTotalCostAmount();
    }

    private boolean isDiscountApplied(){
        return discountedTotal != null;
    }

    /**
     * This pays for the sale.
     * @param payment The payment for the sale.
     */
    public void payForSale(CashPayment payment){
        Amount total = getAmountToPay();
        payment.setTotalCostForSale(total);
        this.payment = payment;
    }

    public void endSale(){
        Amount revenueToNotify = isDiscountApplied() ? discountedTotal : getTotalCostAmount();
        for(TotalRevenueObserver observer : totalRevenueObservers){
            observer.newSale(revenueToNotify);
        }
    }

    public void addTotalRevenueObservers(List<TotalRevenueObserver> observers){
        totalRevenueObservers.addAll(observers);
    }

    /**
     * Gets the payment for the sale.
     * @return The payment for the sale.
     */
    public CashPayment getPayment() {
        return payment;
    }

    /**
     * Adds a scanned item to the list of sold items.
     * @param itemDTO The item to add to the sale.
     */
    public void addItem(ItemDTO itemDTO){
        String itemID = itemDTO.getID();
        if(!itemAlreadyInSale(itemID)){
            ItemDTO newItem = new ItemDTO(itemDTO);
            soldItems.add(newItem);
        }
    }

    private boolean itemAlreadyInSale(String itemIDToCheck){
        for(ItemDTO item : soldItems){
            if(item.getID().equals(itemIDToCheck)){
                item.increaseQuantity();
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the receipt for the sale.
     * @return The receipt for the sale.
     */
    public Receipt getReceipt(){
        if(receiptDoesNotExist()){
            receipt = new Receipt(this);
        }
        return receipt;
    }

    /**
     * Gets the list with sold items for this sale.
     * @return The list with the sold items for this sale.
     */
    public ArrayList<ItemDTO> getSoldItems() {
        return soldItems;
    }

    /**
     * Calculates the total price for a specific item.
     * @param specificItem The specific item to calculate the total price for.
     * @return The total price for a specific item.
     */
    public Amount calculateTotalItemPrice(ItemDTO specificItem){
        Amount quantity = new Amount(specificItem.getQuantity());
        Amount specificItemPrice = specificItem.getPrice();
        return specificItemPrice.multiply(quantity);

    }

    /**
     * Calculates the total VAT for the sale.
     * @return The total VAT.
     */
    public Amount getTotalVAT(){
        Amount sumOfTotalVat = new Amount(0);
        for(ItemDTO item : soldItems){
            Amount itemVATRate = new Amount(item.getVATRatePercentage());
            Amount itemVATAmount = calculateVATAmount(item.getPrice(), itemVATRate);
            Amount itemQuantity = new Amount(item.getQuantity());
            Amount totalItemVATAmount = itemVATAmount.multiply(itemQuantity);
            sumOfTotalVat = sumOfTotalVat.add(totalItemVATAmount);
        }
        return sumOfTotalVat;
    }

    /**
     * Calculates the VAT amount for a specific item.
     * @param itemPriceIncludingVAT The price of the item including VAT.
     * @param VATRate The VAT rate of the item.
     * @return The VAT amount for a specific item.
     */
    private Amount calculateVATAmount(Amount itemPriceIncludingVAT, Amount VATRate){
        Amount oneHundred = new Amount(100);
        Amount numerator = itemPriceIncludingVAT.multiply(VATRate);
        Amount denominator = oneHundred.add(VATRate);
        return numerator.divide(denominator);
    }

    private void setTimeOfSale(){
        saleTime = LocalTime.now();
    }

    /**
     * Gets the time of the sale.
     * @return The time of the sale.
     */
    public LocalTime getTimeOfSale(){
        return saleTime;
    }

    /**
     * Gets the date of the sale.
     * @return The date of the sale.
     */
    public LocalDate getDateOfSale(){
        return saleDate;
    }

    private boolean receiptDoesNotExist(){
        return receipt == null;
    }

    private void setDateOfSale(){
        saleDate = LocalDate.now();
    }
}
