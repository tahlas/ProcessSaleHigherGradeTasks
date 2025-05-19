package integration;

import model.Amount;

/**
 * Strategy for when there is no discount.
 */
public class NoDiscountHandler implements DiscountHandler{
    /**
     * Applies the strategy for when there is no discount.
     * @param totalCost The total cost of the sale before discounts are applied.
     * @return The price when no discount is applied (the original price).
     */
    @Override
    public Amount applyDiscount(Amount totalCost){
        return totalCost;
    }
}
