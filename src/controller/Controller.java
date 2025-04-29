package controller;

import integration.HandlerCreator;
import integration.ItemDTO;
import integration.Printer;
import integration.Register;
import model.Amount;
import model.CashPayment;
import model.Item;
import model.Sale;

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
    public void scanItem(String itemID, int itemQuantity){
        ItemDTO scannedItem = getItemDTO(itemID);

    }


    /**
     * Ends the sale and processes the payment.
     * @param paidAmount The total price of the sale.
     */
    public void endSaleAndPay(Amount paidAmount){
        sale.endSale();
        CashPayment payment = new CashPayment(paidAmount);
    }

}
