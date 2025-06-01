package integration;

import model.Receipt;

/**
 * This the printer that prints the receipt.
 */
public class Printer {
    /**
     * Prints the specified receipt.
     * @param receipt The receipt to print
     */
    public String printReceipt(Receipt receipt){
        return receipt.createReceiptString();
        //System.out.println(receipt.createReceiptString());
    }
}
