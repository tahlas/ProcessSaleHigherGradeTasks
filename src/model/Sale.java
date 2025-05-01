package model;

import integration.ItemDTO;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
    private LocalTime saleTime;
    private Receipt receipt;
    private ArrayList<ItemDTO> soldItems;//osäker om den behövs

    /**
     * Creates a new instance and saves the time of the sale.
     */
    public Sale(){
        setTimeOfSale();
        this.receipt = new Receipt(saleTime, this);
        this.soldItems = new ArrayList<>();
    }

    /**
     * Sets the time of the sale.
     */
    private void setTimeOfSale(){
        saleTime = LocalTime.now();
    }

    /**
     * Adds a scanned item to the list of sold items.
     * @param itemDTO The item to add to the sale.
     */
    public void addItem(ItemDTO itemDTO){
        soldItems.add(itemDTO);
        //receipt.addItemToReceipt(itemDTO);
    }

    public Receipt getReceipt(){
        return receipt;
    }

    public ArrayList<ItemDTO> getSoldItems() {
        return soldItems;
    }

    public int getTotalItemPrice(ItemDTO specificItem){
        return getQuantity(specificItem) * specificItem.getPrice();
    }

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

    private boolean itemIDIsEqual(String firstItemID, String secondItemID){
        return firstItemID.equals(secondItemID);
    }

    /**
     * Calculates the total VAT for the sale.
     * @return The total VAT.
     */
    public double totalVat(){
        double sumOfTotalVAT = 0;
        for(ItemDTO item : soldItems){
            sumOfTotalVAT += item.getPrice() * item.getVATInDecimal();
        }
        return sumOfTotalVAT;
    }

    public double totalItemCost(){
        double sumOfTotalCost = 0;
        for(ItemDTO item : soldItems){
            sumOfTotalCost += item.getPrice();
        }
        return sumOfTotalCost;
    }
}
