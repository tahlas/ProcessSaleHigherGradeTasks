package integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryHandlerTest {
    private InventoryHandler inventory;

    @BeforeEach
    void setUp() {
        inventory = InventoryHandler.getInventoryHandler();//inventory = new InventoryHandler();
    }

    @AfterEach
    void tearDown() {
        inventory = null;
    }

    @Test
    void testGetItemDTO() throws ItemNotFoundException, SQLException {
        String itemIDToFind = "abc123";
        ItemDTO itemToFind = inventory.getItemDTO(itemIDToFind);
        String expectedOutput = "BigWheel Oatmeal";
        String actualOutput = itemToFind.getName();
        assertEquals(expectedOutput, actualOutput, "The item name should be equal");
    }

    @Test
    void testGetItemDTOThrowsItemNotFoundException() throws SQLException{
        String itemIDToFind = "invalidID";
        try{
            ItemDTO itemToFind = inventory.getItemDTO(itemIDToFind);
            fail("Could find an item with an invalid ID");
        }catch(ItemNotFoundException e){
            assertTrue(e.getMessage().contains("not found"), "The exception message should contain the words 'not found'");
        }
    }

    @Test
    void testGetItemDTOThrowsSQLException() throws ItemNotFoundException {
        String itemIDToFind = InventoryHandler.DATABASE_FAILURE_ID;
        try{
            ItemDTO itemToFind = inventory.getItemDTO(itemIDToFind);
            fail("Could connect to an offline database.");
        }catch(SQLException e){
            assertNull(e.getMessage(), "The exception message should be null.");
        }
    }

    //Used when exception did not exist
    @Disabled
    void testGetItemDTONotFound() throws ItemNotFoundException, SQLException {
        String itemIDToFind = "???";
        ItemDTO itemToFind = inventory.getItemDTO(itemIDToFind);
        assertEquals("INVALID ITEM NAME", itemToFind.getName(), "The item name should be equal to INVALID ITEM NAME");
    }
}