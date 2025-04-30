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
        appendLine(builder, String.valueOf(saleTime));
        appendNewLine(builder);
        appendItemsOnReceipt(builder);

        builder.append("Total: ");
        appendTotalCost(builder);
        appendNewLine(builder);

        builder.append("VAT: ");
        appendTotalVAT(builder);

        builder.append("Cash: ");


        return builder.toString();
    }

    /**
     * Appends relevant information about each item on the receipt.
     * @param builder The builder to append the information to.
     */
    private void appendItemsOnReceipt(StringBuilder builder) {
        for(ItemDTO item : itemsOnReceipt) {
            builder.append(item.getName());
            builder.append(" ");

            builder.append(item.getQuantity());
            builder.append(" x ");
            builder.append(item.getPrice());

            builder.append(item.getTotalItemPrice());
            appendLine(builder,"SEK");
        }
    }

    /**
     * Appends the total cost.
     * @param builder The StringBuilder to append the total cost to.
     */
    private void appendTotalCost(StringBuilder builder) {
        int sumOfCost = 0;
        for(ItemDTO item : itemsOnReceipt) {
            sumOfCost += item.getTotalItemPrice();
        }
        builder.append(sumOfCost);
    }

    /**
     * Appends the total VAT.
     * @param builder The StringBuilder to append the total VAT to.
     */
    private void appendTotalVAT(StringBuilder builder) {
        double sumOfVAT = 0;
        for(ItemDTO item : itemsOnReceipt) {
            sumOfVAT += item.getTotalItemPrice();
        }
        builder.append(sumOfVAT);
    }

    /**
     * Appends a String and a new line at the end.
     * @param builder The StringBuilder to append the line to.
     * @param line The String to append.
     */
    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        appendNewLine(builder);
    }

    /**
     * Appends a tab to a StringBuilder.
     * @param builder The StringBuilder to append the tab to.
     */
    private void appendTab(StringBuilder builder){
        builder.append("\t");
    }

    /**
     * Appends a new line to the StringBuilder.
     * @param builder The StringBuilder to append the new line to.
     */
    private void appendNewLine(StringBuilder builder){
        builder.append("\n");
    }

    private void endSection(StringBuilder builder){
        builder.append("\n");
    }
}
