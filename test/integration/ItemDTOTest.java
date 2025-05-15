package integration;

import model.Amount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDTOTest {
    ItemDTO itemDTO;


    @BeforeEach
    void setUp() {
        String ID = "abc123";
        String name = "BigWheel Oatmeal";
        double VAT = 6;
        String description = "BigWheel Oatmeal 500 g, whole grain oats, high fiber, gluten free";
        Amount price = new Amount(29.9);
        itemDTO = new ItemDTO(ID, name, price, VAT, description);
    }

    @AfterEach
    void tearDown() {
        itemDTO = null;
    }

    @Test
    void testToString() {
        String expectedOutput = "BigWheel Oatmeal";
        String actualOutput = itemDTO.toString();
        assertTrue(actualOutput.contains(expectedOutput), "The item did not print correctly");
    }

    @Test
    void testGetID() {
        String expectedOutput = "abc123";
        String actualOutput = itemDTO.getID();
        assertEquals(expectedOutput, actualOutput, "The item ID should be equal");
    }

    @Test
    void testGetPrice() {
        Amount expectedOutput = new Amount(29.9);
        Amount actualOutput = itemDTO.getPrice();
        assertEquals(String.valueOf(expectedOutput), String.valueOf(actualOutput), "The item price should be equal");
    }

    @Test
    void testGetName() {
        String expectedOutput = "BigWheel Oatmeal";
        String actualOutput = itemDTO.getName();
        assertEquals(expectedOutput, actualOutput, "The item name should be equal");
    }

    @Test
    void testGetVATRatePercentage () {
        double expectedOutput = 6;
        double actualOutput = itemDTO.getVATRatePercentage();
        assertEquals(expectedOutput, actualOutput, "The VAT should be equal");
    }

    @Test
    void testIncreaseQuantity() {
        itemDTO.increaseQuantity();
        int expectedResult = 2;
        int actualResult = itemDTO.getQuantity();
        assertEquals(expectedResult, actualResult, "The quantity should be equal");
    }
}