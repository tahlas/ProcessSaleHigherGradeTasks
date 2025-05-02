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
        assertEquals(String.valueOf(totalCost), String.valueOf(cashPayment.getTotalCostForSale()), "The total cost should be equal");
    }

    @Test
    void testGetPaidAmount() {
        assertEquals(String.valueOf(paidAmount), String.valueOf(cashPayment.getPaidAmount()), "The paid amount should be equal");
    }

    @Test
    void testGetTotalCostForSale() {
        cashPayment.setTotalCostForSale(totalCost);
        assertEquals(String.valueOf(totalCost), String.valueOf(cashPayment.getTotalCostForSale()), "The total cost should be equal");
    }

    @Test
    void testGetChange() {
        Amount change = new Amount(50);
        cashPayment.setTotalCostForSale(totalCost);
        assertEquals(String.valueOf(change), String.valueOf(cashPayment.getChange()), "The change should be equal");
    }
}