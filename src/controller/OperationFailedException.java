package controller;

public class OperationFailedException extends RuntimeException {
    public OperationFailedException(String message, Exception cause) {
        super(message, cause);
    }
}
