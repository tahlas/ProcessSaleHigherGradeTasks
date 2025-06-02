package view;

import controller.Controller;
import integration.HandlerCreator;
import integration.Printer;
import integration.Register;
import model.Amount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This uses the test from lecture 10. It is currently a placeholder...
 */
class ViewTest {
    //private Printer printerToTest;
    //private Register registerToTest;
    //private Handler creatorToTest;
    private View instanceToTest;
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp(){
        Printer printer = new Printer();
        Register register = new Register(new Amount(1000));
        HandlerCreator creator = new HandlerCreator();
        Controller contr = new Controller(printer, register, creator);
        instanceToTest = new View(contr);

        outContent = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(outContent);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);

    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
        outContent = null;
        System.setOut(originalSysOut);
    }

    @Test
    void testReceiptString(){
        instanceToTest.runFakeExecution();
        String result = outContent.toString();

        assertTrue(result.contains("Time of Sale: " + LocalDate.now()), "The time of sale should be present in the receipt.");
        assertTrue(result.contains("BigWheel"), "The item name should be present in the receipt.");
        assertTrue(result.contains("2 x 29.9"), "The item quantity and price should be present in the receipt.");
        assertTrue(result.contains("Total: 74.7"), "The total price should be present in the receipt.");
        assertTrue(result.contains("Discounted total: 59.76"), "The discounted total should be present in the receipt.");
        assertTrue(result.contains("VAT: 4.23"), "The VAT should be present in the receipt.");
        assertTrue(result.contains("Cash: 100.0 SEK"), "The paid amount should be present in the receipt.");
        assertTrue(result.contains("Change: 40.24 SEK"), "The change should be present in the receipt.");
    }

    @Test
    void testPresentChangeToGiveToCustomer(){
        instanceToTest.runFakeExecution();
        String result = outContent.toString();
        assertTrue(result.contains("Change to give the customer: 40."),"The change should be printed.");
    }

    @Test
    void testPresentCurrentScannedItem(){
        instanceToTest.runFakeExecution();
        String result = outContent.toString();
        assertTrue(result.contains("Add 1 item with item id abc123:"), "The recently scanned item should be printed.");
    }

//    @Disabled
//    void testReceiptStringOld() {
//        Sale sale = new Sale();
//        ItemDTO item = new ItemDTO(
//                "abc123",
//                "BigWheel Oatmeal",
//                new Amount(29.9),
//                6,
//                "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free");
//        sale.addItem(item);
//        Amount paidAmount = new Amount(30);
//        sale.payForSale(new CashPayment(paidAmount));
//        Printer printer = new Printer();
//        System.out.println(printer.printReceipt(sale.getReceipt()) );
//
//        String result = outContent.toString();
//
//        assertTrue(result.contains("Time of Sale: " + sale.getDateOfSale()), "The time of sale should be present in the receipt.");
//        assertTrue(result.contains(item.getName()), "The item name should be present in the receipt.");
//        assertTrue(result.contains("1 x " + item.getPrice()), "The item quantity and price should be present in the receipt.");
//        assertTrue(result.contains(item.getPrice() + " SEK"), "The total item price should be present in the receipt.");
//        assertTrue(result.contains("Total: " + sale.getTotalCostAmount()), "The total price should be present in the receipt.");
//        assertTrue(result.contains("Discounted total: " + sale.getAmountToPay()), "The discounted total should be present in the receipt.");
//        assertTrue(result.contains("VAT: " + sale.getTotalVAT()), "The VAT should be present in the receipt.");
//        assertTrue(result.contains("Cash: " + paidAmount), "The paid amount should be present in the receipt.");
//        assertTrue(result.contains("Change: " + sale.getPayment().getChange()), "The change should be present in the receipt.");
//    }

//    private Printer printerToTest;
//    private Register registerToTest;
//    private Handler creatorToTest;
//    private View instanceToTest;
//    private ByteArrayOutputStream printoutBuffer;
//    private PrintStream originalSysOut;
//
//    @BeforeEach
//    void setUp() {
//        Printer printer = new Printer();
//        Register register = new Register();
//        HandlerCreator creator = new HandlerCreator();
//        Controller contr = new Controller(printer, register, creator);
//        instanceToTest = new View(contr);
//
//        printoutBuffer = new ByteArrayOutputStream();
//        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
//        originalSysOut = System.out;
//        System.setOut(inMemSysOut);
//    }
//
//    @AfterEach
//    void tearDown() {
//
//        instanceToTest = null;
//        printoutBuffer = null;
//        System.setOut(originalSysOut);
//    }
//
//    @Test
//    public void testRunFakeExecution(){
//        instanceToTest.runFakeExecution();
//        String printout = printoutBuffer.toString();
//        String expectedOutput = "started";
//        assertTrue(printout.contains(expectedOutput), "UI did not start correctly");
//    }
}