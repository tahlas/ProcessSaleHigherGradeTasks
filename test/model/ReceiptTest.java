package model;

import integration.ItemDTO;
import integration.Printer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;

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

    //testing methods that print is not needed...(I did not know that when writing this...)
    @Disabled
    void testCreateReceiptString() {
        Sale sale = new Sale();
        ItemDTO item = new ItemDTO("A", "B", new Amount(10), 5, "C");
        sale.addItem(item);
        sale.payForSale(new CashPayment(new Amount(10)));
        Printer printer = new Printer();
        printer.printReceipt(sale.getReceipt());
        LocalDate saleDate = LocalDate.now();
        LocalTime saleTime = LocalTime.now();
        String expectedResult =
                "Time of Sale: " + saleDate + " " + saleTime.toString().substring(0, 8) + "\n\n" +
                "B 1 x 10.0\t10.0 SEK\n\n" +
                "Total: 10.0\n" +
                "VAT: 0.48\n" +
                "Cash: 10.0 SEK\n" +
                "Change: 0.0 SEK";
        String result = outContent.toString();
        assertTrue(result.contains(expectedResult), "Wrong printout.");
    }
}