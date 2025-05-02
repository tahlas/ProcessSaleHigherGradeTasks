package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmountTest {
    Amount amountWithThree;
    Amount amountWithFive;

    @BeforeEach
    void setUp() {
        amountWithThree = new Amount(3);
        amountWithFive = new Amount(5);
    }

    @AfterEach
    void tearDown() {
        amountWithThree = null;
        amountWithFive = null;
    }

    @Test
    void testAdd() {
        Amount result = amountWithThree.add(amountWithFive);
        assertEquals(String.valueOf(8.0), result.toString(), "The sum should be equal.");
    }

    @Test
    void testMultiply() {
        Amount result = amountWithThree.multiply(amountWithFive);
        assertEquals(String.valueOf(15.0), result.toString(), "The product should be equal.");
    }

    @Test
    void testMinus() {
        Amount result = amountWithFive.minus(amountWithThree);
        assertEquals(String.valueOf(2.0), result.toString(), "The difference should be equal.");
    }

    @Test
    void testToString() {
        Amount amountWithThreeDecimals = new Amount(3.141);
        assertEquals("3.14", amountWithThreeDecimals.toString(), "The amount should be equal.");
    }
}