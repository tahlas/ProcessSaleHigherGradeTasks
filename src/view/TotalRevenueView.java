package view;

import model.Amount;
import model.Sale;
import model.TotalRevenueObserver;

import java.util.ArrayList;

//any class that implements observer
public class TotalRevenueView implements TotalRevenueObserver {
    //private ArrayList<Sale> sales = new ArrayList<>();
    Amount totalRevenue = new Amount(0);

    /**
     * Shows the revenue of all sales so far to the view.
     *
     * @param revenue The revenue of the recently ended sale.
     */
    @Override
    public void newSale(Amount revenue){
        totalRevenue = totalRevenue.add(revenue);
        printCurrentState();
    }

    private void printCurrentState(){
        System.out.println("Current revenue: " + totalRevenue);
        System.out.println("==================");
    }

//    private Amount totalRevenueSoFar(){
//        Amount sum = new Amount(0);
//        for(Sale sale : sales){
//            sum = sum.add(sale.getTotalCostAmount());
//        }
//        return sum;
//    }
}
