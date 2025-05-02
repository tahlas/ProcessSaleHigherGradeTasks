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
    public Register(){
        this.cashInRegister = new Amount(1000);
    }

    /**
     * Shows information about the item that is scanned and the running total (including VAT).
     */
    public void presentCurrentScannedItem(Sale sale) {
        String printString = currentScannedItemString(sale);
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
        System.out.println("Cash in register: " + cashInRegister);
    }

    private String currentScannedItemString(Sale sale){
        StringBuilder builder = new StringBuilder();
        ItemDTO lastScannedItem = sale.getSoldItems().getLast();

        builder.append("Add 1 item with item id ");
        builder.append(lastScannedItem.getID());
        builder.append(":");
        endSection(builder);

        builder.append(lastScannedItem);

        endSection(builder);
        builder.append("Total cost (incl VAT): ");
        builder.append(sale.totalCostAmount()); //något fel är här
        appendCurrency(builder);
        endSection(builder);

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
    }

}
