package model;

import integration.ItemDTO;
import integration.Printer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUpStreams() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void cleanUpStreams(){
        outContent = null;
        System.setOut(originalSysOut);
    }
    @Test
    void testCreateReceiptString() {
        Sale sale = new Sale();
        ItemDTO item = new ItemDTO(
                "abc123",
                "BigWheel Oatmeal",
                new Amount(29.9),
                6,
                "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free");
        sale.addItem(item);
        Amount paidAmount = new Amount(30);
        sale.payForSale(new CashPayment(paidAmount));
        LocalDate saleDate = LocalDate.now();
        Printer printer = new Printer();
        printer.printReceipt(sale.getReceipt());
        String result = outContent.toString();

        assertTrue(result.contains("Time of Sale: " + saleDate), "The time of sale should be present in the receipt.");
        assertTrue(result.contains(item.getName()), "The item name should be present in the receipt.");
        assertTrue(result.contains("1 x " + item.getPrice()), "The item quantity and price should be present in the receipt.");
        assertTrue(result.contains(item.getPrice() + " SEK"), "The total item price should be present in the receipt.");
        assertTrue(result.contains("Total: " + sale.getTotalCostAmount()), "The total price should be present in the receipt.");
        assertTrue(result.contains("Discounted total: " + sale.getAmountToPay()), "The discounted total should be present in the receipt.");
        assertTrue(result.contains("VAT: " + sale.getTotalVAT()), "The VAT should be present in the receipt.");
        assertTrue(result.contains("Cash: " + paidAmount), "The paid amount should be present in the receipt.");
        assertTrue(result.contains("Change: " + sale.getPayment().getChange()), "The change should be present in the receipt.");
    }
}