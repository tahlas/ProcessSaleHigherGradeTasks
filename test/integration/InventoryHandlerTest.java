package integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
    void testGetItemDTO() throws ItemNotFoundException {
        String itemIDToFind = "abc123";
        ItemDTO itemToFind = inventory.getItemDTO(itemIDToFind);
        String expectedOutput = "BigWheel Oatmeal";
        String actualOutput = itemToFind.getName();
        assertEquals(expectedOutput, actualOutput, "The item name should be equal");
    }

    //Used when exception did not exist
    @Disabled
    void testGetItemDTONotFound() throws ItemNotFoundException {
        String itemIDToFind = "???";
        ItemDTO itemToFind = inventory.getItemDTO(itemIDToFind);
        assertEquals("INVALID ITEM NAME", itemToFind.getName(), "The item name should be equal to INVALID ITEM NAME");
    }
}