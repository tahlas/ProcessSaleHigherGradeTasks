package integration;

import model.Amount;
import model.CashPayment;

import java.util.ArrayList;

public class Register {
    /**
     * Shows information about the item that is scanned and the running total (including VAT).
     */
    public void presentCurrentSoldItem(ArrayList<ItemDTO> soldItems) {
        ItemDTO recentlyScannedItem = soldItems.getLast();
        System.out.println("Add 1 item with item id " + recentlyScannedItem.getID() + ":\n");
        System.out.println(recentlyScannedItem);
        System.out.println("Total cost (incl VAT): " + runningTotal(soldItems));
    }

    /**
     * Calculates the total cost of the items that have been sold so far.
     * @param soldItems Items that have been sold.
     * @return The total cost so far.
     */
    private int runningTotal(ArrayList<ItemDTO> soldItems){
        int totalCost = 0;
        for(ItemDTO item : soldItems){
            totalCost+=item.getPrice();
        }
        return totalCost;
    }
}
