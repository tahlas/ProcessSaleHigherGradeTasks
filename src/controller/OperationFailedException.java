package controller;

/**
 * Thrown when an operation fails.
 */
public class OperationFailedException extends RuntimeException {
    /**
     * Constructs a new OperationFailedException with a specified message and cause.
     * @param message The message explaining the reason for the failure.
     * @param cause The cause of the failure.
     */
    public OperationFailedException(String message, Exception cause) {
        super(message, cause);
    }
}
