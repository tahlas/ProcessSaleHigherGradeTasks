package integration;

import model.Amount;

public interface DiscountHandler {
    Amount applyDiscount(Amount totalCost, CustomerID customerID);
}
