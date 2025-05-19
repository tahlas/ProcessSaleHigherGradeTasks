package integration;

import model.Amount;

/**
 * Strategy for discount calculation.
 */
public interface DiscountHandler {
    Amount applyDiscount(Amount totalCost);
}
