package model;

import integration.ItemDTO;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Represents one receipt, which proves the payment of one sale.
 */

//konstruktor utan parameter
public class Receipt {
    private ArrayList <ItemDTO> itemsOnReceipt;
    private LocalTime saleTime;

    public Receipt(LocalTime saleTime){
        this.saleTime = saleTime;
        this.itemsOnReceipt = new ArrayList<ItemDTO>();
    }

    public void addItemToReceipt(ItemDTO item) {
        itemsOnReceipt.add(item);
    }

    /**
     * Adds multiple of the same item to the receipt.
     * @param itemDTO The item to add to the receipt.
     * @param quantity The quantity of the item to add.
     */
    public void addItemToReceipt(ItemDTO itemDTO, int quantity) {
        for(int i = 0; i < quantity; i++) {
            itemsOnReceipt.add(itemDTO);
        }
    }

    /**
     * Creates a string representing a receipt.
     * @return The string that represents the receipt.
     */
    public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Time of Sale: ");
        appendLine(saleTime.);

    }

    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder){
        builder.append("\n");
    }
}
