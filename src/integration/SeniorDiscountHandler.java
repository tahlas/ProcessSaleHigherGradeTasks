package integration;

import model.Amount;

public class SeniorDiscountHandler implements DiscountHandler{
    @Override
    public Amount applyDiscount(Amount totalCost, CustomerID customerID){
        Amount discountFactor = new model.Amount(0.8);
        return totalCost.multiply(discountFactor);
    }
}
