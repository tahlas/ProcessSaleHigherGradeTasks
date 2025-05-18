package controller;

import integration.*;
import model.Amount;
import model.CashPayment;
import model.Sale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Sale sale;
    HandlerCreator handlerCreator;
    InventoryHandler inventory;
    @BeforeEach
    void setUp() {
        sale = new Sale();
        handlerCreator = new HandlerCreator();
        inventory = handlerCreator.getInventoryHandler();
    }

    @AfterEach
    void tearDown() {
        sale = null;
        handlerCreator = null;
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
    void testScanItemThrowsItemNotFoundException() throws SQLException {
        String itemIDToFind = "invalidID";
        try{
            ItemDTO itemToFind = inventory.getItemDTO(itemIDToFind);
            fail("Could find an item with an invalid ID");
        }catch(ItemNotFoundException e){
            assertTrue(e.getMessage().contains("not found"), "The exception message should contain the words 'not found'");
        }
    }

    @Test
    void testScanItemThrowsSQLException() throws ItemNotFoundException{
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


    @Test
    void testAddItem() throws ItemNotFoundException, SQLException {
        String itemIDToFind = "abc123";
        ItemDTO itemToFind = inventory.getItemDTO(itemIDToFind);
        sale.addItem(itemToFind);
        assertTrue(sale.getSoldItems().contains(itemToFind), "The item should be in the list of items sold");
    }

    @Test
    void testPayForSale() {
        Amount paidAmount = new Amount(100);
        CashPayment payment = new CashPayment(paidAmount);
        sale.payForSale(payment);
        assertEquals(paidAmount, sale.getPayment().getPaidAmount(), "The paid amount should be equal");
    }

    @Test
    void testAddPaymentToRegister(){
        Register register = new Register(new Amount(1000));
        Amount paidAmount = new Amount(100);
        sale.addItem(new ItemDTO("A", "B", new Amount(100), 25, "C"));
        CashPayment payment = new CashPayment(paidAmount);
        sale.payForSale(payment);
        register.addPaymentToRegister(sale.getTotalCostAmount());
        Amount expectedResult = new Amount(1100);
        assertEquals(expectedResult, register.getCashInRegister(), "The register should have the amount 1100");
    }
}