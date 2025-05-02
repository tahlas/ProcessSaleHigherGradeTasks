package integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlerCreatorTest {

    private HandlerCreator handlerCreator;

    @BeforeEach
    void setUp() {
        handlerCreator = new HandlerCreator();
    }

    @AfterEach
    void tearDown() {
        handlerCreator = null;
    }

    @Test
    void testGetInventoryHandlerNotNull() {
        assertNotNull(handlerCreator.getInventoryHandler(), "The inventory handler should not be null");
    }

    @Test
    void getInventoryHandlerSameInstance() {
        InventoryHandler inventoryHandler1 = handlerCreator.getInventoryHandler();
        InventoryHandler inventoryHandler2 = handlerCreator.getInventoryHandler();
        assertSame(inventoryHandler1, inventoryHandler2, "The inventory handler should be the same instance");
    }
}