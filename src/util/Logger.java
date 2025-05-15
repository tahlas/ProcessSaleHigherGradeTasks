package util;

/**
 * Specifies a message that will be logged. The implementing class decides where the log is.
 */
public interface Logger {
    /**
     *The specified message is printed to the log.
     *
     * @param message The message that will be logged.
     */
    void log(String message);
}
