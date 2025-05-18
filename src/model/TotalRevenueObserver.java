package model;



public interface TotalRevenueObserver {

    /**
     * Invoked when a sale ends.
     *
     * @param revenue The revenue of the sale that recently ended.
     */
    void newSale(Amount revenue);
}
