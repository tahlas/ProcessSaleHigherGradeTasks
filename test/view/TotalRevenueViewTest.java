package view;

import model.Amount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TotalRevenueViewTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;
    private TotalRevenueView totalRevenueView;

    @BeforeEach
    void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        totalRevenueView = new TotalRevenueView();
    }

    @AfterEach
    void tearDown(){
        outContent = null;
        System.setOut(originalSysOut);
        totalRevenueView = null;
    }

    @Test
    void testNewSalePrintsTotalRevenue(){
        Amount revenue = new Amount(100);
        totalRevenueView.newSale(revenue);
        String result = outContent.toString();
        String expectedOutput = "Current revenue: 100.0";
        assertTrue(result.contains(expectedOutput), "The total revenue should be printed to the console.");
    }

    @Test
    void testHandleErrorPrintToSystemOut(){
        Exception testException = new Exception("Test error");
        totalRevenueView.handleErrors(testException);
        String result = outContent.toString();
        assertTrue(result.contains("CANNOT PRINT TO CONSOLE: Test error"), "The error message should be printed to the console.");
    }
}