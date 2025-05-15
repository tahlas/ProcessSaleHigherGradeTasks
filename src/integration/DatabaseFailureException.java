package integration;
//============================================REPLACED WITH SQL EXCEPTION====================================
/**
 * Thrown when a connection to the database cannot be established (not business logic).
 */
public class DatabaseFailureException extends Exception {
    private final String itemIDThatCannotBeChecked;

    /**
     * Creates a new instance with a message specifying the item ID that cannot be checked.
     * @param itemID That cannot be checked.
     */
    public DatabaseFailureException(String itemID) {
        super("The database server is not running! Item with the ID: " + itemID + " could not be added to the sale!");
        this.itemIDThatCannotBeChecked = itemID;
    }

    public String getItemIDThatCannotBeChecked() {
        return itemIDThatCannotBeChecked;
    }


}
