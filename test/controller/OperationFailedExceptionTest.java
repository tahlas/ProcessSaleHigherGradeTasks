package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationFailedExceptionTest {
    @Test
    void testOperationFailedException() {
        String message = "Test message";
        Exception cause = new Exception("Test cause");
        OperationFailedException exception = new OperationFailedException(message, cause);
        assertEquals(message, exception.getMessage(), "The exception message should be equal");
        assertEquals(cause, exception.getCause(), "The exception cause should be equal");
    }

}