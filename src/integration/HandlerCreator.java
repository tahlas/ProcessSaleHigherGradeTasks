package integration;

/**
 * This creates the other handlers in the application.
 */
public class HandlerCreator {
    private final InventoryHandler inventoryHandler;

    /**
     * Creates a new instance.
     */
    public HandlerCreator() {
        this.inventoryHandler = new InventoryHandler();
    }

    /**
     * Gets the inventory handler.
     * @return The inventory handler.
     */
    public InventoryHandler getInventoryHandler() {
        return inventoryHandler;
    }
}
