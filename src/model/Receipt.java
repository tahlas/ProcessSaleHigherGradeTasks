package model;

import integration.ItemDTO;

import java.util.ArrayList;

/**
 * Represents one receipt, which proves the payment of one sale.
 */

//konstruktor utan parameter
public class Receipt {
    private ArrayList <ItemDTO> itemsOnReceipt;

    /**
     * Adds item(s) to the receipt.
     * @param itemDTO The item to add to the receipt.
     * @param quantity The quantity of the item to add.
     */
    public void addItemToReceipt(ItemDTO itemDTO, int quantity) {
        for(int i = 0; i < itemsOnReceipt.size(); i++) {
            itemsOnReceipt.add(itemDTO);
        }
    }

}
