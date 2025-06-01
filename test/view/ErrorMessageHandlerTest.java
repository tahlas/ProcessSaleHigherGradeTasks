package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ErrorMessageHandlerTest {
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
    void testShowErrorMessage(){
        ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
        String message = "Test message";
        errorMessageHandler.showErrorMessage(message);
        String result = outContent.toString();
        String expectedOutput = "ERROR: Test message";
        assertTrue(result.contains(expectedOutput), "The error message should be printed to the console");
    }
}