package integration;

/**
 * This creates the other handlers in the application.
 */
public class HandlerCreator {
    private final InventoryHandler inventoryHandler;

    public HandlerCreator() {
        this.inventoryHandler = new InventoryHandler();
    }
    public InventoryHandler getInventoryHandler() {
        return inventoryHandler;
    }
}
