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

    /**
     * Creates a new instance.
     * @param saleTime The time the sale started.
     * @param sale The actual sale.
     */
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
        appendLine(builder, "------------------ Begin Receipt -------------------");
        builder.append("Time of Sale: ");
        appendLine(builder, String.valueOf(saleTime));
        endSection(builder);
        appendItemsOnReceipt(builder);
        endSection(builder);

        builder.append("Total: ");
        builder.append(sale.totalCost());
        endSection(builder);

        builder.append("VAT: ");
        appendLine(builder, String.valueOf(sale.totalVAT()));

        builder.append("Cash: ");
        builder.append("PLACEHOLDER CASH");
        appendLine(builder, " SEK");
        builder.append("Change: ");
        builder.append("PLACEHOLDER CHANGE");
        appendLine(builder, " SEK");
        appendLine(builder, "------------------ End receipt ---------------------");

        return builder.toString();
    }

    /**
     * Appends relevant information about each item on the receipt.
     * @param builder The builder to append the information to.
     */
    private void appendItemsOnReceipt(StringBuilder builder) {
        ArrayList<ItemDTO> alreadyProcessedItem = new ArrayList<>();
        for(ItemDTO item : itemsOnReceipt) {
            if(!alreadyProcessedItem.contains(item)){
                builder.append(item.getName());
                builder.append(" ");

                builder.append(sale.getQuantity(item));
                builder.append(" x ");
                builder.append(item.getPrice());
                builder.append("\t");
                builder.append(sale.getTotalItemPrice(item));
                appendLine(builder," SEK");

                alreadyProcessedItem.add(item);
            }
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
