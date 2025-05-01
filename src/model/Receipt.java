package model;

import integration.ItemDTO;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Represents one receipt, which proves the payment of one sale.
 */
public class Receipt {
    private ArrayList <ItemDTO> itemsOnReceipt;
    private LocalTime saleTime;
    private final Sale sale;

    public Receipt(LocalTime saleTime, Sale sale){
        this.saleTime = saleTime;
        this.itemsOnReceipt = sale.getSoldItems();
        this.sale = sale;
    }

    /**
     * Creates a string representing a receipt.
     * @return The string that represents the receipt.
     */
    public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Time of Sale: ");
        appendLine(builder, String.valueOf(saleTime));
        endSection(builder);
        appendItemsOnReceipt(builder);

        builder.append("Total: ");
        builder.append(sale.totalItemCost());
        endSection(builder);

        builder.append("VAT: ");
        builder.append(sale.totalVat());

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

            builder.append(sale.getQuantity(item));
            builder.append(" x ");
            builder.append(item.getPrice());

            builder.append(sale.getTotalItemPrice(item));
            appendLine(builder,"SEK");
        }
    }

    /**
     * Appends a String and a new line at the end.
     * @param builder The StringBuilder to append the line to.
     * @param line The String to append.
     */
    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        endSection(builder);
    }

    /**
     * Appends a new line to the StringBuilder.
     * @param builder The StringBuilder to append the new line to.
     */
    private void endSection(StringBuilder builder){
        builder.append("\n");
    }


}
