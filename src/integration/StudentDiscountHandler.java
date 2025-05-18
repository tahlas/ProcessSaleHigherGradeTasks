package integration;

import model.Amount;

public class StudentDiscountHandler implements DiscountHandler{

    @Override
    public Amount applyDiscount(Amount totalCost, CustomerID customerID){
        Amount discountPercentage = new Amount(0.9);
        return totalCost.multiply(discountPercentage);
    }
}
