package controller;

import integration.*;
import model.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This is the application's only controller. All calls to the model pass through this class.
 */
public class Controller {
    private final Printer printer;
    private final Register register;
    private final HandlerCreator handlerCreator;
    private Sale sale;
    private ArrayList<TotalRevenueObserver> totalRevenueObservers = new ArrayList<>();

    /**
     * Creates a new instance.
     *
     * @param printer The printer that is used to print the receipt.
     * @param register The register that is used by the cashier.
     * @param handlerCreator The handler creator that is used to create other handlers.
     */
    public Controller(Printer printer, Register register, HandlerCreator handlerCreator) {
        this.printer = printer;
        this.register = register;
        this.handlerCreator = handlerCreator;
    }

    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale(){
        sale = new Sale();
        sale.addTotalRevenueObservers(totalRevenueObservers);
    }

    /**
     * Scans an item.
     *
     * @param itemID the itemID of the item to scan.
     */
    public void scanItem(String itemID){
        InventoryHandler inventoryHandler = handlerCreator.getInventoryHandler();
        ItemDTO scannedItem;
        try{
            scannedItem = inventoryHandler.getItemDTO(itemID);
        } catch(SQLException sqle){
            throw new OperationFailedException("Could not connect to the database. Item with itemID: " + itemID + " could not be scanned.", sqle);
        } catch(ItemNotFoundException e){
            throw new OperationFailedException("Item with itemID: " + itemID + " could not be scanned.", e);
        }

        sale.addItem(scannedItem);
        register.presentCurrentScannedItem(sale, scannedItem);
    }

    /**
     * Ends the sale and processes the payment.
     * @param amountPaid The total price of the sale.
     */
    public void pay(Amount amountPaid, CustomerID customerID){
        DiscountHandler discountHandler = DiscountHandlerSelector.getDiscountHandler(customerID);
        applyDiscount(discountHandler);
        CashPayment payment = new CashPayment(amountPaid);
        sale.payForSale(payment);
//        Receipt receipt = sale.getReceipt();
//        printer.printReceipt(receipt);

    }

    public void printReceipt(){
        Receipt receipt = sale.getReceipt();
        printer.printReceipt(receipt);
    }

    public void displayInfoToRegister(){
        register.presentChangeToGiveToCustomer(sale);
        register.addPaymentToRegister(sale.getPayment().getTotalCostForSale());
        sale.endSale();
    }


    /**
     * Applies a discount to the sale.
     *
     * @param discountHandler The discount handler that will be used to apply the discount.
     */
    private void applyDiscount(DiscountHandler discountHandler){
        sale.applyDiscount(discountHandler);
    }

    /**
     * Adds a total revenue observer.
     *
     * @param observer The observer to add.
     */
    public void addTotalRevenueObserver(TotalRevenueObserver observer){
        totalRevenueObservers.add(observer);
    }


}
