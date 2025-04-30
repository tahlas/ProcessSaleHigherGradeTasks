package model;

import integration.ItemDTO;

import java.util.ArrayList;

public class CashPayment {
    private Amount paidAmt;
    private Amount totalCost;

    public CashPayment(Amount paidAmt) {
        this.paidAmt = paidAmt;
    }

    /**
     * Calculates the total cost of the items.
     *
     * @param boughtItems A list of items to buy.
     */
    void calculateTotalCost(ArrayList<ItemDTO> boughtItems) {
        int sumOfTotalCost = 0;
        for(ItemDTO item : boughtItems) {
            sumOfTotalCost += item.getPrice();
        }


//        totalCost = new Amount(0);
//        ItemDTO itemDTOAtIndexI;
//        for(int i = 0; i<boughtItems.size(); i++) {
//            itemDTOAtIndexI = boughtItems.get(i);
//            totalCost = totalCost.add(itemDTOAtIndexI.getPrice());
//        }
    }
}
