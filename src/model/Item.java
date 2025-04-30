package model;

import integration.ItemDTO;

import java.util.ArrayList;

/**
 *
 */
public class Item {
    private ArrayList<ItemDTO> soldItems;

    /**
     * Adds a scanned item to the list that holds the items being sold.
     * @param scannedItem The item to add to the list.
     */
    public void addScannedItemToList(ItemDTO scannedItem){
        soldItems.add(scannedItem);
    }

    /**
     * Pays for the bought items.
     * @param payment The payment the customer gives
     */
    public void payForItems(CashPayment payment){
        payment.calculateTotalCost(soldItems);//1.3.1
    }

    /**
     * Gets the list with the sold items.
     * @return ArrayList with sold items.
     */
    public ArrayList<ItemDTO> getSoldItems(){
        return soldItems;
    }

    /**
     * Prints the receipt.
     * @param receipt The receipt to print.
     */



}
