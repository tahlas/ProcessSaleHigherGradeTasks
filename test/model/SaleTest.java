package model;

import integration.InventoryHandler;
import integration.ItemDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    Sale sale;

    @BeforeEach
    void setUp() {
        sale = new Sale();
    }

    @AfterEach
    void tearDown() {
        sale = null;
    }

    @Test
    void testSaleInitialize(){
        assertTrue(sale.getSoldItems().isEmpty(), "The list of items sold should be empty.");
        assertNull(sale.getPayment(), "The payment should be null");
    }

    @Test
    void testPayForSale() {
        ItemDTO item = new ItemDTO("abc123", "BigWheel Oatmeal", new Amount(29.9), 6, "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free");
        sale.addItem(item);
        CashPayment payment = new CashPayment(new Amount(50));
        sale.payForSale(payment);
        fail("This is not done");
    }

    @Test
    void testGetPayment() {
        sale.payForSale( new CashPayment(new Amount(50)));
        assertNotNull(sale.getPayment(), "The payment should not be null");
    }

    @Test
    void testAddItem() {
        ItemDTO item = new ItemDTO("abc123", "BigWheel Oatmeal", new Amount(29.9), 6, "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free");
        sale.addItem(item);
        assertTrue(sale.getSoldItems().contains(item), "The item should be in the list of items sold");
    }

    @Test
    void testGetReceipt() {
        Receipt receipt = sale.getReceipt();
        assertNotNull(receipt, "The receipt should not be null.");
    }

    @Test
    void testGetSoldItems() {
        assertNotNull(sale.getSoldItems(), "The list of items sold should not be null");
    }

    @Test
    void testGetTotalItemPrice() {
        ItemDTO item = new ItemDTO("abc123", "BigWheel Oatmeal", new Amount(10), 6, "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free");
        sale.addItem(item);
        assertEquals((new Amount(10)).toString(), sale.getTotalItemPrice(item).toString(), "The total price of the item should be equal to 10");
    }

    @Test
    void testGetQuantity() {
        ItemDTO item = new ItemDTO("abc123", "BigWheel Oatmeal", new Amount(29.9), 6, "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free");
        sale.addItem(item);
        assertEquals(1, sale.getQuantity(item), "The quantity of the item should be 1");
    }

    @Test
    void testTotalVAT() {
        sale.addItem(new ItemDTO("A", "B", new Amount(125), 25, "C"));
        assertEquals(String.valueOf(25.0), sale.totalVAT().toString(), "The total VAT should be equal to 25");
    }

    @Test
    void testTotalCostAmount() {
        sale.addItem(new ItemDTO("A", "B", new Amount(125), 25, "C"));
        assertEquals(String.valueOf(125.0), sale.totalCostAmount().toString(), "The total cost should be equal to 150");
    }

    @Test
    void testGetTimeOfSale() {
        assertNotNull(sale.getTimeOfSale(), "The time of sale should not be null");
    }

    @Test
    void testGetDateOfSale() {
        assertEquals(LocalDate.now(), sale.getDateOfSale(), "The date of sale should be equal to the current time");
    }
}