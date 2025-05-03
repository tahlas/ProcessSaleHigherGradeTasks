package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashPaymentTest {
    private Amount paidAmount;
    private Amount totalCost;
    private CashPayment cashPayment;

    @BeforeEach
    void setUp() {
        paidAmount = new Amount(100);
        totalCost = new Amount(50);
        cashPayment = new CashPayment(paidAmount);
    }

    @AfterEach
    void tearDown() {
        paidAmount = null;
        totalCost = null;
        cashPayment = null;
    }

    @Test
    void testSetTotalCostForSale() {
        cashPayment.setTotalCostForSale(totalCost);
        Amount expectedResult = totalCost;
        Amount result = cashPayment.getTotalCostForSale();
        assertEquals(expectedResult, result, "The total cost should be equal");
    }

    @Test
    void testGetChange() {
        cashPayment.setTotalCostForSale(totalCost);
        Amount expectedResult = new Amount(50);
        Amount result = cashPayment.getChange();
        assertEquals(expectedResult, result, "The change should be equal");
    }
}