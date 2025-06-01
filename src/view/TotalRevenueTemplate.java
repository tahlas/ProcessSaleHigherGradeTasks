package view;

import model.Amount;
import model.TotalRevenueObserver;

/**
 *
 */
public abstract class TotalRevenueTemplate implements TotalRevenueObserver {
    private Amount totalRevenue = new Amount(0);

//    @Override
//    public void newSale(Amount revenue) {
//        totalRevenue = totalRevenue.add(revenue);
//        //printCurrentState();
//    }

    /**
     * Calculate the total amount paid since the program started.
     * @param priceOfTheSaleThatWasJustMade The price of the sale that was just made.
     */
    @Override
    public void newSale(Amount priceOfTheSaleThatWasJustMade){
        calculateTotalRevenue(priceOfTheSaleThatWasJustMade);
        showTotalIncome(totalRevenue);
    }

    private void showTotalIncome(Amount totalRevenue){
        try{
            doShowTotalIncome(totalRevenue);
        } catch (Exception e){
            handleErrors(e);
        }
    }

    private void calculateTotalRevenue(Amount revenue){
        totalRevenue = totalRevenue.add(revenue);
    }

    /**
     * Shows the total income since the program started.
     *
     * @param totalRevenue The total revenue from all sales.
     *
     * @throws Exception If an error occurs while showing the total income.
     */
    protected abstract void doShowTotalIncome(Amount totalRevenue) throws Exception;

    /**
     * Handles errors that occur while showing the total income.
     *
     * @param e The exception that was thrown while trying to show the total income.
     */
    protected abstract void handleErrors(Exception e);
}


