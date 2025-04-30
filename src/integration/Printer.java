package integration;

import model.Receipt;


public class Printer {
    /**
     * Prints the specified receipt.
     * @param receipt The receipt to print
     */
    public void printReceipt(Receipt receipt){
        System.out.println(receipt.createReceiptString());
    }
}
