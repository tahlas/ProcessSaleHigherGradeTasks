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





}
