package model;

import integration.ItemDTO;

import java.util.ArrayList;

/**
 *
 */
public class Item {
    private ArrayList<ItemDTO> soldItems;


    /**
     * Pays for the bought items.
     * @param payment The payment the customer gives
     */
    public void payForItems(CashPayment payment){
        payment.calculateTotalCost(soldItems);//1.3.1
    }

    /**
     * Adds a scanned item to the list that holds the items being sold.
     * @param scannedItem The item to add to the list.
     */
    public void addScannedItemToList(ItemDTO scannedItem){
        soldItems.add(scannedItem);
    }

    /**
     * Gets the list with the sold items.
     * @return ArrayList with sold items.
     */
    public ArrayList<ItemDTO> getSoldItems(){
        return soldItems;
    }

    public int getQuantity(String specificItemID){
        int numberOfSpecificItem = 0;
        String currentItemInListID;
        for(ItemDTO item : soldItems){
            currentItemInListID = item.getID();
            if(itemIDIsEqual(currentItemInListID, specificItemID)){
                numberOfSpecificItem++;
            }
        }
        return numberOfSpecificItem;
    }

    /**
     * Checks if two item IDs are equal.
     * @param firstItemID The first item ID to compare
     * @param secondItemID THe second item ID to compare
     * @return True if they are equal, false if they are not.
     */
    private boolean itemIDIsEqual(String firstItemID, String secondItemID){
        return firstItemID.equals(secondItemID);
    }



    /**
     * Prints the receipt.
     * @param receipt The receipt to print.
     */



}
