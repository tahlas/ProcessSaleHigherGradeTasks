package controller;

import integration.*;
import model.Amount;
import model.CashPayment;
import model.Sale;
import model.Receipt;

/**
 * This is the application's only controller. All calls to the model pass through this class.
 */
public class Controller {
    private final Printer printer;
    private final Register register;
    private final HandlerCreator handlerCreator;

    public Controller(Printer printer, Register register, HandlerCreator handlerCreator) {
        this.printer = printer;
        this.register = register;
        this.handlerCreator = handlerCreator;
    }

    private Sale sale;

    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale(){
        sale = new Sale();
    }

    /**
     * Scans an item.
     */
    public void scanItem(String itemID){
        InventoryHandler inventoryHandler = handlerCreator.getInventoryHandler(); //osäker om den bör vara såhär
        ItemDTO scannedItem = inventoryHandler.getItemDTO(itemID);
        sale.addItem(scannedItem);
        register.presentCurrentScannedItem(sale);
    }


    /**
     * Ends the sale and processes the payment.
     * @param amountPaid The total price of the sale.
     */
    public void endSaleAndPay(Amount amountPaid){
        //sale.endSale(); //1.1 tror inte den ska göra något
        CashPayment payment = new CashPayment(amountPaid); //1.2
        sale.payForSale(payment);
        Receipt receipt = sale.getReceipt();//1.5
        printer.printReceipt(receipt);
        register.presentChangeToGiveToCustomer(sale);
        register.addPaymentToRegister(sale.totalCost_Amount());
    }

}
