package view;

import model.Amount;

import java.io.FileWriter;
import java.io.PrintWriter;

public class TotalRevenueFileOutput extends TotalRevenueTemplate {
    private PrintWriter logStream;

    @Override
    protected void doShowTotalIncome(Amount totalRevenue) throws Exception {
        if(logStream == null){
            logStream = new PrintWriter(new FileWriter("total_revenue.txt"), true);
        }
        logStream.println("Current revenue: " + totalRevenue);
        logStream.println("=======================");
    }

    @Override
    protected void handleErrors(Exception e){
        System.out.println("CANNOT PRINT TO FILE: " + e.getMessage());
        e.printStackTrace();
    }
}
