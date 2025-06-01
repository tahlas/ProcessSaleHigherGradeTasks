package model;

import integration.ItemDTO;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Represents one receipt, which proves the payment of one sale...
 */
public class Receipt {
    private final ArrayList <ItemDTO> itemsOnReceipt;
    private final Sale sale;

    /**
     * Creates a new instance.
     * @param sale The actual sale.
     */
    Receipt(Sale sale){
        this.itemsOnReceipt = sale.getSoldItems();
        this.sale = sale;
    }

    /**
     * Creates a string representing a receipt.
     * @return The string that represents the receipt.
     */
    public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        CashPayment payment = sale.getPayment();

        builder.append("Time of Sale: ");
        builder.append(sale.getDateOfSale());
        builder.append(" ");
        appendLine(builder, getTimeOfSale());
        endSection(builder);
        appendItemsOnReceipt(builder);
        endSection(builder);

        builder.append("Total: ");
        builder.append(sale.getTotalCostAmount());
        endSection(builder);

        builder.append("Discounted total: ");
        builder.append(sale.getAmountToPay());
        endSection(builder);

        builder.append("VAT: ");
        appendLine(builder, String.valueOf(sale.getTotalVAT()));

        builder.append("Cash: ");
        builder.append(payment.getPaidAmount());
        appendCurrencyLine(builder);

        builder.append("Change: ");
        builder.append(payment.getChange());
        appendCurrencyLine(builder);

        return builder.toString();
    }

    private void appendCurrencyLine(StringBuilder builder){
        appendLine(builder, " SEK");
    }

    private String getTimeOfSale(){
        LocalTime timeOfSale = sale.getTimeOfSale();
        return timeOfSale.toString().substring(0, 8);
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
                builder.append("\t");
                builder.append(sale.calculateTotalItemPrice(item));
                appendCurrencyLine(builder);
        }
    }

    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        endSection(builder);
    }

    private void endSection(StringBuilder builder){
        builder.append("\n");
    }
}
