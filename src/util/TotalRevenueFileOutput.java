package util;

import model.Amount;
import model.Sale;
import model.TotalRevenueObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TotalRevenueFileOutput implements TotalRevenueObserver {
    //private ArrayList<Sale> sales = new ArrayList<>();
    //private ArrayList<Amount> revenues = new ArrayList<>();
    private Amount totalRevenue = new Amount(0);
    private PrintWriter logStream;

    /**
     * Prints the revenue of all sales so far to a file.
     *
     * @param revenue The revenue of the sale that recently added.
     */
    @Override
    public void newSale(Amount revenue) {
        totalRevenue = totalRevenue.add(revenue);
        printCurrentState();
    }

    private void printCurrentState(){
        if(logStream == null){
            try{
                logStream = new PrintWriter(new FileWriter("total_revenue.txt"), true);

            } catch (IOException e) {
                System.out.println("CANNOT PRINT TO FILE");
                e.printStackTrace();
            }
        }
        logStream.println("Current revenue: " + totalRevenue);
        logStream.println("=======================");
    }

//    private Amount totalRevenueSoFar(){
//        Amount sum = new Amount(0);
//        for(Sale sale : sales){
//            sum = sum.add(sale.getTotalCostAmount());
//        }
//        return sum;
//    }
}
