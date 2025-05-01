package model;

import integration.ItemDTO;

import java.util.ArrayList;

public class CashPayment {
    private Amount paidAmount;
    private Amount totalCost;

    public CashPayment(Amount paidAmount) {
        this.paidAmount = paidAmount;
    }


    public void calculateTotalCost(Sale sale) {
        totalCost = sale.totalCost_Amount();
    }

    public Amount getPaidAmount(){
        return this.paidAmount;
    }
    public Amount getTotalCost(){
        return this.totalCost;
    }

    public Amount getChange(){
        return totalCost.minus(paidAmount);
    }
}
