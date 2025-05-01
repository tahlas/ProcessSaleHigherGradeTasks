package controller;

import integration.*;
import model.Amount;
import model.CashPayment;
import model.Item;
import model.Sale;
import model.Receipt;

/**
 * This is the application's only controller. All calls to the model pass through this class.
 */
public class Controller {
    private Printer printer;
    private Register register;
    private HandlerCreator handlerCreator;

    public Controller(Printer printer, Register register, HandlerCreator handlerCreator) {
        this.printer = printer;
        this.register = register;
        this.handlerCreator = handlerCreator;
    }

    private Sale sale;
    private Item item;

    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale(){
        sale = new Sale();
        item = new Item();
    }

    /**
     * Scans an item.
     */
    public void scanItem(String itemID){
        InventoryHandler inventoryHandler = handlerCreator.getInventoryHandler(); //osäker om den bör vara såhär
        ItemDTO scannedItem = inventoryHandler.getItemDTO(itemID);
        sale.addItem(scannedItem);
        register.presentCurrentSoldItem(sale);
    }


    /**
     * Ends the sale and processes the payment.
     * @param amountPaid The total price of the sale.
     */
    public void endSaleAndPay(Amount amountPaid){
        //sale.endSale(); //1.1 tror inte den ska göra något
        CashPayment payment = new CashPayment(amountPaid); //1.2
        //item.payForItems(payment); kanske fixar senare
        Receipt receipt = sale.getReceipt();//1.5
        printer.printReceipt(receipt);
    }

}
