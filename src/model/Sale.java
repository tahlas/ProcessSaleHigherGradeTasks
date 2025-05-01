package model;

import integration.ItemDTO;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * One single sale made by one single customer and paid with one payment.
 */
public class Sale {
    private LocalTime saleTime;
    private final Receipt receipt;
    private final ArrayList<ItemDTO> soldItems;

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale(){
        setTimeOfSale();
        this.receipt = new Receipt(saleTime, this);
        this.soldItems = new ArrayList<>();
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
     * Checks if two item IDs are equal.
     * @param firstItemID The first item ID to check.
     * @param secondItemID The second item ID to check.
     * @return True if they are equal, false if they are not equal.
     */
    private boolean itemIDIsEqual(String firstItemID, String secondItemID){
        return firstItemID.equals(secondItemID);
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


}
