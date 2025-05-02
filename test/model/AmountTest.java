package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmountTest {
    Amount firstAmount;
    Amount secondAmount;

    @BeforeEach
    void setUp() {
        firstAmount = new Amount(1);
        secondAmount = new Amount(2);
    }

    @AfterEach
    void tearDown() {
        firstAmount = null;
        secondAmount = null;
    }

    @Test
    void testAdd() {
        Amount result = firstAmount.add(secondAmount);
        Amount expected = new Amount(3);
        assertEquals(expected, result, "The amount should be the same");
    }

    @Test
    void testMultiply() {
        Amount result = firstAmount.multiply(secondAmount);
        Amount expected = new Amount(2);
        assertEquals(expected, result, "The amount should be the same");
    }

    @Test
    void minus() {
    }

    @Test
    void testToString() {
    }
}