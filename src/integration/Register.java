package integration;

import model.Amount;
import model.CashPayment;
import model.Sale;

/**
 * This represents the register.
 */
public class Register {
    private Amount cashInRegister;

    /**
     * Creates a new instance and sets the amount of cash in the register.
     */
    public Register(Amount cashInRegister){
        this.cashInRegister = cashInRegister;
    }

    /**
     * Shows information about the item that is scanned and the running total (including VAT).
     */
    public void presentCurrentScannedItem(Sale sale, ItemDTO scannedItem) {
        String printString = currentScannedItemString(sale, scannedItem);
        System.out.println(printString);
    }

    /**
     * Shows the change that the cashier must give to the customer.
     * @param sale The sale where the change exists in.
     */
    public void presentChangeToGiveToCustomer(Sale sale){
        CashPayment payment = sale.getPayment();
        System.out.println("Change to give the customer: " + payment.getChange());
    }

    /**
     * Calculates the cash in the register after the change has been given to the customer.
     * @param amountToIncreaseWith The amount to add to the register.
     */
    public void addPaymentToRegister(Amount amountToIncreaseWith){
        this.cashInRegister = cashInRegister.add(amountToIncreaseWith);
        //System.out.println("Cash in register: " + cashInRegister);
    }

    /**
     * Creates a string with information about the scanned item and running totals for the sale.
     * @param sale The sale where the scanned item exists in.
     * @return The string with information about the scanned item and running totals for the sale.
     */
    private String currentScannedItemString(Sale sale, ItemDTO lastScannedItem){
        StringBuilder builder = new StringBuilder();

        builder.append("Add 1 item with item id ");
        builder.append(lastScannedItem.getID());
        builder.append(":");
        endSection(builder);

        builder.append(lastScannedItem);

        endSection(builder);
        builder.append("Total cost (incl VAT): ");
        builder.append(sale.getTotalCostAmount());
        appendCurrency(builder);
        endSection(builder);

        builder.append("Total VAT: ");
        builder.append(sale.getTotalVAT());
        appendCurrency(builder);
        endSection(builder);

        return builder.toString();
    }

    /**
     * Appends a new line to the StringBuilder.
     * @param builder The StringBuilder to append the new line to.
     */
    private void endSection(StringBuilder builder){
        builder.append("\n");
    }

    /**
     * Appends the currency to the StringBuilder.
     * @param builder The StringBuilder to append the currency to.
     */
    private void appendCurrency(StringBuilder builder){
        builder.append(" SEK");
    }

    /**
     * Gets the amount of cash in the register.
     * @return The amount of cash in the register.
     */
    public Amount getCashInRegister() {
        return cashInRegister;
    }
}
