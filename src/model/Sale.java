package model;

import integration.ItemDTO;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * One single sale made by one single customer and paid with one payment.
 */
public class Sale {
    private LocalTime saleTime;
    private Receipt receipt;
    private final ArrayList<ItemDTO> soldItems;
    private CashPayment payment;

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale(){
        setTimeOfSale();
        this.soldItems = new ArrayList<>();
    }

    /**
     * This pays for the sale.
     * @param payment The payment for the sale.
     */
    public void payForSale(CashPayment payment){
        payment.calculateTotalCost(this);
        this.payment = payment;
    }

    /**
     * Gets the payment for the sale.
     * @return The payment for the sale.
     */
    public CashPayment getPayment() {
        return payment;
    }

    /**
     * Gets the amount paid.
     * @return The amount paid.
     */
    public Amount getPaidAmount(){
        return payment.getPaidAmount();
    }

    /**
     * Adds a scanned item to the list of sold items.
     * @param itemDTO The item to add to the sale.
     */
    public void addItem(ItemDTO itemDTO){
        soldItems.add(itemDTO);
    }

    /**
     * Gets the receipt for the sale.
     * @return The receipt for the sale.
     */
    public Receipt getReceipt(){
        if(receiptDoesNotExist()){
            receipt = new Receipt(saleTime, this);
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
    public double getTotalItemPrice(ItemDTO specificItem){
        return getQuantity(specificItem) * specificItem.getPrice();
    }

    /**
     * Calculates the quantity for a specific item.
     * @param specificItem The specific item to calculate the quantity for.
     * @return The number of times a specific item has appeared in the sale.
     */
    public int getQuantity(ItemDTO specificItem){
        int numberOfSpecificItemID = 0;
        String specificItemID = specificItem.getID();
        String itemInListID;
        for(ItemDTO item : soldItems){
            itemInListID = item.getID();
            if(itemIDIsEqual(specificItemID, itemInListID))
                numberOfSpecificItemID++;
        }
        return numberOfSpecificItemID;
    }

    /**
     * Calculates the total VAT for the sale.
     * @return The total VAT.
     */
    public double totalVAT(){
        double sumOfTotalVAT = 0;
        for(ItemDTO item : soldItems){
            sumOfTotalVAT += item.getPrice() * item.getVATInDecimal();
        }
        return roundToTwoDecimals(sumOfTotalVAT);
    }

    /**
     * Calculates the total cost of the sale.
     * @return The total cost of the sale (so far).
     */
    public double totalCost(){
        double sumOfTotalCost = 0;
        for(ItemDTO item : soldItems){
            sumOfTotalCost += item.getPrice();
        }
        return roundToTwoDecimals(sumOfTotalCost);
    }

    /**
     * Calculates the total cost of the sale.
     * @return The total cost of the sale (so far).
     */
    public Amount totalCost_Amount(){
        Amount sumOfTotalCost = new Amount(0);
        for(ItemDTO item : soldItems){
            sumOfTotalCost = sumOfTotalCost.add(item.getAmount());
        }
        return sumOfTotalCost;
    }

    /**
     * Rounds a double to two decimals.
     * @param value The double to round.
     * @return The rounded double.
     */
    private double roundToTwoDecimals(double value){
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }

    /**
     * Sets the time of the sale.
     */
    private void setTimeOfSale(){
        saleTime = LocalTime.now();
    }

    /**
     * Checks if two item IDs are equal.
     * @param firstItemID The first item ID to check.
     * @param secondItemID The second item ID to check.
     * @return True if they are equal, false if they are not equal.
     */
    private boolean itemIDIsEqual(String firstItemID, String secondItemID){
        return firstItemID.equals(secondItemID);
    }

    /**
     * Checks if the receipt exists.
     * @return True if the receipt does not exist, false if it does exist.
     */
    private boolean receiptDoesNotExist(){
        return receipt == null;
    }
}
