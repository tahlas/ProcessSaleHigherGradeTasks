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
    void testGetItemDTO() {
        String itemIDToFind = "abc123";
        ItemDTO itemToFind = inventory.getItemDTO(itemIDToFind);
        String expectedOutput = "BigWheel Oatmeal";
        String actualOutput = itemToFind.getName();
        assertEquals(expectedOutput, actualOutput, "The item name should be equal");
    }

    @Test
    void testGetItemDTONotFound(){
        String itemIDToFind = "???";
        ItemDTO itemToFind = inventory.getItemDTO(itemIDToFind);
        assertEquals("INVALID ITEM NAME", itemToFind.getName(), "The item name should be equal to INVALID ITEM NAME");
    }
}