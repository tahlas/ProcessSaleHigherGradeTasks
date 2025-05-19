package integration;

import model.Amount;

/**
 * Strategy for senior discount.
 */
public class SeniorDiscountHandler implements DiscountHandler{
    /**
     * Applies the discount strategy for a senior disocunt.
     *
     * @param totalCost The total cost of the sale before the disocunt.
     * @return The cost of the sale after the discount is applied.
     */
    @Override
    public Amount applyDiscount(Amount totalCost){
        Amount discountPercentage = new model.Amount(0.8);
        return totalCost.multiply(discountPercentage);
    }
}
