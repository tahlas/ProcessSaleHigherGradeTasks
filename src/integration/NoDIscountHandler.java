package integration;

import model.Amount;

public class NoDIscountHandler implements DiscountHandler{
    public Amount applyDiscount(Amount totalCost, CustomerID customerID){
        return totalCost;
    }
}
