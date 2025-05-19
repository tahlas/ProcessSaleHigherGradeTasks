package integration;

/**
 * This creates the other handlers in the application.
 */
public class HandlerCreator {
    private final InventoryHandler inventoryHandler;
    private static final HandlerCreator INSTANCE = new HandlerCreator();

    //singleton
    public static HandlerCreator getHandlerCreator(){
        return INSTANCE;
    }

    /**
     * Creates a new instance.
     */
    private HandlerCreator() {
        this.inventoryHandler = InventoryHandler.getInventoryHandler();
    }

    /**
     * Gets the inventory handler.
     * @return The inventory handler.
     */
    public InventoryHandler getInventoryHandler() {
        return inventoryHandler;
    }
}
