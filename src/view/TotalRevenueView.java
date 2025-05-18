package view;

import model.Amount;
import model.Sale;
import model.TotalRevenueObserver;

import java.util.ArrayList;

//any class that implements observer
public class TotalRevenueView implements TotalRevenueObserver {
    private ArrayList<Sale> sales = new ArrayList<>();

    @Override
    public void newSale(Sale sale){
        sales.add(sale);
        printCurrentState();
    }

    private void printCurrentState(){
        System.out.println("==================");
        System.out.println("Current revenue: " + totalRevenueSoFar());
        System.out.println("==================");
    }

    private Amount totalRevenueSoFar(){
        Amount sum = new Amount(0);
        for(Sale sale : sales){
            sum = sum.add(sale.getTotalCostAmount());
        }
        return sum;
    }
}
