package integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryHandlerTest {
    private InventoryHandler inventory;

    @BeforeEach
    void setUp() {
        inventory = new InventoryHandler();
    }

    @AfterEach
    void tearDown() {
        inventory = null;
    }

    @Test
    void getItemDTO() {
        String itemIDToFind = "abc123";
        ItemDTO itemToFind = inventory.getItemDTO(itemIDToFind);
        String expectedOutput = "BigWheel Oatmeal";
        String actualOutput = itemToFind.getName();
        assertEquals(expectedOutput, actualOutput, "The item name should be equal");
    }
}