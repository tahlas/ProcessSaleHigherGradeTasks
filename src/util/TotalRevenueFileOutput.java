package util;

import model.Amount;
import model.Sale;
import model.TotalRevenueObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TotalRevenueFileOutput implements TotalRevenueObserver {
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
}
