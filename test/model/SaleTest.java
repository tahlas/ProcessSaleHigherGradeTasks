package model;

import integration.ItemDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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

    @Disabled
    void testAddItem() {
        ItemDTO item = new ItemDTO("abc123", "BigWheel Oatmeal", new Amount(29.9), 6, "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free");
        sale.addItem(item);
        assertTrue(sale.getSoldItems().contains(item), "The item should be in the list of items sold");
    }

    @Disabled
    void testAddSameItemTwice(){
        ItemDTO item = new ItemDTO("A", "B", new Amount(10), 10, "C");
        sale.addItem(item);
        sale.addItem(item);
        int expectedQuantity = 2;
        int actualQuantity = item.getQuantity();
        assertEquals(expectedQuantity, actualQuantity, "The quantity should be the same");
    }

    @Test
    void testItemWithPriceZero(){
        ItemDTO item = new ItemDTO("A", "B", new Amount(0), 0, "C");
        sale.addItem(item);
        Amount expectedResult = new Amount(0);
        Amount result = sale.getTotalCostAmount();
        assertEquals(expectedResult, result, "The total cost should be equal to 0");
    }

    @Test
    void testCalculateTotalItemPrice() {
        ItemDTO item = new ItemDTO("abc123", "BigWheel Oatmeal", new Amount(10), 6, "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free");
        sale.addItem(item);
        Amount expectedResult = new Amount(10);
        Amount result = sale.calculateTotalItemPrice(item);
        assertEquals(expectedResult, result, "The total price of the item should be equal to 10");
    }

//    @Disabled
//    void testCalculateQuantity() {
//        ItemDTO item = new ItemDTO("abc123", "BigWheel Oatmeal", new Amount(29.9), 6, "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free");
//        sale.addItem(item);
//        assertEquals(1, sale.calculateQuantity(item), "The quantity of the item should be 1");
//    }

    @Test
    void testGetTotalVAT() {
        sale.addItem(new ItemDTO("A", "B", new Amount(125), 25, "C"));
        Amount expectedResult = new Amount(25);
        Amount result = sale.getTotalVAT();
        assertEquals(expectedResult, result, "The total VAT should be equal to 25");
    }

    @Test
    void testGetTotalCostAmount() {
        sale.addItem(new ItemDTO("A", "B", new Amount(125), 25, "C"));
        Amount expectedResult = new Amount(125);
        Amount result = sale.getTotalCostAmount();
        assertEquals(expectedResult, result, "The total cost should be equal to 125");
    }
}