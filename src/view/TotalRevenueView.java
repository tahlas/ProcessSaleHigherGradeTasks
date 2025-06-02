package view;

import model.Amount;


public class TotalRevenueView extends TotalRevenueTemplate {
    //unsure if it should have Amount totalRevenue
    protected void doShowTotalIncome(Amount totalRevenue){
        System.out.println("Current revenue: " + totalRevenue);
        System.out.println("==================");
    }

    protected void handleErrors(Exception e){
        System.out.println("CANNOT PRINT TO CONSOLE: " + e.getMessage());
        //e.printStackTrace();
    }
}
