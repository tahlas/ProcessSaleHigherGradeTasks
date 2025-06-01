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
    private TotalRevenueView view;

    @BeforeEach
    void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        view = new TotalRevenueView();
    }

    @AfterEach
    void tearDown(){
        outContent = null;
        System.setOut(originalSysOut);
        view = null;
    }

    @Test
    void testNewSalePrintsTotalRevenue(){
        Amount revenue = new Amount(100);
        view.newSale(revenue);
        String result = outContent.toString();
        String expectedOutput = "Current revenue: 100.0";
        assertTrue(result.contains(expectedOutput), "The total revenue should be printed to the console.");
    }

    @Test
    void testHandleErrorsPrintsToSystemOut(){
        Exception testException = new Exception("Test error");
        view.handleErrors(testException);
        String result = outContent.toString();
        assertTrue(result.contains("CANNOT PRINT TO CONSOLE: Test error"), "The error message should be printed to the console.");
    }
}