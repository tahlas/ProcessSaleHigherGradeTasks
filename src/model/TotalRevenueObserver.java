package model;



public interface TotalRevenueObserver {
//    /**
//     * Invoked when a sale ends.
//     *
//     * @param totalRevenueSum The revenue from the sale that ended.
//     */
    //void printTotalRevenue(Amount totalRevenueSum);

    void newSale(Sale sale);
}
