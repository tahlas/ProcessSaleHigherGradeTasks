package integration;

import model.Amount;

public class SeniorDiscountHandler implements DiscountHandler{
    @Override
    public Amount applyDiscount(Amount totalCost, CustomerID customerID){
        Amount discountPercentage = new model.Amount(0.2);
        return totalCost.multiply(discountPercentage);
    }
}
