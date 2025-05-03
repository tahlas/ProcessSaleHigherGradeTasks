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
        Amount expectedResult = new Amount(8);
        assertEquals(expectedResult, result, "The sum should be equal.");
    }

    @Test
    void testMultiply() {
        Amount result = amountWithThree.multiply(amountWithFive);
        Amount expectedResult = new Amount(15);
        assertEquals(expectedResult, result, "The product should be equal.");
    }

    @Test
    void testMinus() {
        Amount result = amountWithFive.minus(amountWithThree);
        Amount expectedResult = new Amount(2.0);
        assertEquals(expectedResult, result, "The difference should be equal.");
    }

    @Test
    void testToString() {
        Amount amountWithThreeDecimals = new Amount(3.141);
        String expectedResult = "3.14";
        assertEquals(expectedResult, amountWithThreeDecimals.toString(), "The amount should be equal.");
    }
}