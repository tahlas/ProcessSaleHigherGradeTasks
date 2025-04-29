package integration;

/**
 * This creates the other handlers in the application.
 */
public class HandlerCreator {
    private InventoryHandler inventoryHandler;
    //discount ska inte vara med
    public HandlerCreator() {
        InventoryHandler inventoryHandler = new InventoryHandler();
    }
    public InventoryHandler getInventoryHandler() {
        return inventoryHandler;
    }
}
