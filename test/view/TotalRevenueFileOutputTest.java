package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
class TotalRevenueFileOutputTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;
    private TotalRevenueFileOutput fileOutput;

    @BeforeEach
    void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        fileOutput = new TotalRevenueFileOutput();
    }

    @AfterEach
    void tearDown(){
        outContent = null;
        System.setOut(originalSysOut);
    }


    @Test
    void testHandleErrorsPrintToSystemOut(){
        Exception testException = new Exception("Test error");
        fileOutput.handleErrors(testException);
        String result = outContent.toString();
        assertTrue(result.contains("CANNOT PRINT TO FILE: Test error"), "The error message should be printed to the console.");
    }
}