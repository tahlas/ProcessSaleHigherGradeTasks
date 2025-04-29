package model;

import integration.ItemDTO;

import java.util.ArrayList;

/**
 *
 */
public class Item {
    private ArrayList<ItemDTO> items;

    /**
     * Pays for the bought items.
     * @param payment The payment the customer gives
     * @param boughtItems A list of the bought items.
     */
    public void payForItems(CashPayment payment, ArrayList<ItemDTO> boughtItems){
        payment.calculateTotalCost(boughtItems);
    }
}
