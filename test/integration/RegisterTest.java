package integration;

import model.Amount;
import model.Sale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;
    Sale sale;
    Register register;

    @BeforeEach
    void setUp() {
        sale = new Sale();
        register = new Register();
    }

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

    //Testing methods that only produce output is not needed...
    @Test
    void testPresentCurrentScannedItem() {
        ItemDTO item = new ItemDTO("A", "B", new Amount(125), 25, "C" );
        sale.addItem(item);
        register.presentCurrentScannedItem(sale);
        String expectedResult =
                "Add 1 item with item id " + item.getID() + ":\n" +
                "Item ID: " + item.getID() + "\n" +
                "Item name: " + item.getName() + "\n" +
                "Item cost: " + item.getPrice() + "\n" +
                "VAT: " + item.getVATRatePercentage() + "%\n" +
                "Item description: " + item.getDescription() + "\n\n" +
                "Total cost (incl VAT): " + sale.totalCostAmount() + " SEK\n" +
                "Total VAT: " + sale.totalVAT();
        String result = outContent.toString();
        assertTrue(result.contains(expectedResult), "Wrong register printout.");
    }

    @Test
    void presentChangeToGiveToCustomer() {

    }

    @Test
    void addPaymentToRegister() {

    }
}