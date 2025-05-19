package integration;

import model.Amount;

public class NoDiscountHandler implements DiscountHandler{
    public Amount applyDiscount(Amount totalCost, CustomerID customerID){
        return new Amount(0);
    }
}
