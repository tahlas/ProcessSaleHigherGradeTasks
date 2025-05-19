package integration;

import model.Amount;

/**
 * Strategy for a student discount.
 */
public class StudentDiscountHandler implements DiscountHandler{
    /**
     * Applies the student discount.
     *
     * @param totalCost The total cost of the sale before a disocunt is applied.
     * @return The cost after the discount is applied.
     */
    @Override
    public Amount applyDiscount(Amount totalCost){
        Amount discountPercentage = new Amount(0.9);
        return totalCost.multiply(discountPercentage);
    }
}
