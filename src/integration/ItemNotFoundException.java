package integration;

/**
 * Thrown when an item cannot be found in the inventory (business logic).
 */
public class ItemNotFoundException  extends Exception{
    //private final String itemIDThatCannotBeFound;

    /**
     * Creates a new instance with a message specifying the item ID that cannot be found.
     * @param itemID The item ID that cannot be found.
     */
    public ItemNotFoundException(String itemID) {
        super("Item with ID " + itemID + " is not found in the inventory.");
        //this.itemIDThatCannotBeFound = itemID;
    }

//    /**
//     * @return The item ID that cannot be added to the sale.
//     */
//    public String getItemIDThatCanNotBeFound() {
//        return itemIDThatCannotBeFound;
//    }
}
