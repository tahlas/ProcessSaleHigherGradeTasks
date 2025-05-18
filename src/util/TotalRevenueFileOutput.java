package util;

import model.Amount;
import model.Sale;
import model.TotalRevenueObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TotalRevenueFileOutput implements TotalRevenueObserver {
    private ArrayList<Sale> sales = new ArrayList<>();
    //private PrintWriter logStream;

    @Override
    public void newSale(Sale sale) {
        sales.add(sale);
        printCurrentState();
    }

    private void printCurrentState(){
        try{
            PrintWriter logStream = new PrintWriter(new FileWriter("total_revenue.txt"), true);
            logStream.println("=======================");
            logStream.println("Current revenue: " + totalRevenueSoFar());
            logStream.println("=======================");
        } catch (IOException e) {
            System.out.println("CANNOT PRINT TO FILE");
            e.printStackTrace();
        }
    }

    private Amount totalRevenueSoFar(){
        Amount sum = new Amount(0);
        for(Sale sale : sales){
            sum = sum.add(sale.getTotalCostAmount());
        }
        return sum;
    }


//    @Override
//    public void printTotalRevenue(){
//        //THIS REUSES CODE FROM FileLogger.java!!!
//        try{
//            logStream = new PrintWriter(new FileWriter("total_revenue.txt"), true);
//        } catch (IOException e) {
//            System.out.println("CANNOT PRINT TOTAL REVENUE TO FILE");
//            e.printStackTrace();
//        }
//    }
//
//    public void print(Amount totalRevenueSum){
//        logStream.println(totalRevenueSum);
//    }

}
