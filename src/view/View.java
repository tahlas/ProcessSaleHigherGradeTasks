package view;

import controller.Controller;
import model.Amount;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in this controller.
 */
public class View {
    private final Controller contr;

    /**
     * Creates a new instance that uses the specified controller for alls to other layers.
     *
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr){
        this.contr = contr;
    }

    /**
     * Performs a fake sale by calling all system operations in the controller.
     */
    public void runFakeExecution(){
        contr.startSale();
        contr.scanItem("abc123");
        contr.scanItem("abc123");
        contr.scanItem("def456");
        Amount amountPaid = new Amount(100);
        contr.endSaleAndPay(amountPaid);
    }
}
