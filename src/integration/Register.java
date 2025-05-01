package integration;

import model.Amount;
import model.CashPayment;
import model.Sale;

import java.util.ArrayList;

public class Register {

    /**
     * Shows information about the item that is scanned and the running total (including VAT).
     */
    public void presentCurrentSoldItem(Sale sale) {
        String printString = currentSoldItemString(sale);
        System.out.println(printString);
    }

    private String currentSoldItemString(Sale sale){
        StringBuilder builder = new StringBuilder();
        ItemDTO lastScannedItem = sale.getSoldItems().getLast();
        builder.append("Add 1 item with item id ");
        builder.append(lastScannedItem.getID());
        builder.append(":");
        endSection(builder);
        builder.append(lastScannedItem);

        endSection(builder);
        builder.append("Total cost (incl VAT): ");
        builder.append(sale.totalCost());
        appendCurrency(builder);
        builder.append("Total VAT: ");
        builder.append(sale.totalVAT());
        appendCurrency(builder);
        endSection(builder);
        return builder.toString();
    }

    private void endSection(StringBuilder builder){
        builder.append("\n");
    }

    private void appendCurrency(StringBuilder builder){
        builder.append(" SEK");
        endSection(builder);
    }

}
