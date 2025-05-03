package controller;

import integration.HandlerCreator;
import integration.InventoryHandler;
import integration.ItemDTO;
import integration.Register;
import model.Amount;
import model.CashPayment;
import model.Sale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void testGetItemDTO(){
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


    @Test
    void testAddItem(){
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
        register.addPaymentToRegister(sale.totalCostAmount());
        Amount expectedResult = new Amount(1100);
        assertEquals(expectedResult, register.getCashInRegister(), "The register should have the amount 1100");
    }
}