package view;

import controller.Controller;
import integration.CustomerID;
import integration.InventoryHandler;
import model.Amount;
import util.FileLogger;
import util.Logger;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in this controller.
 */
public class View {
    private final Controller contr;
    private final ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
    private final Logger logger = FileLogger.getLogger();

    /**
     * Creates a new instance that uses the specified controller for alls to other layers.
     *
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr){
        this.contr = contr;
        contr.addTotalRevenueObserver(new TotalRevenueView());
        contr.addTotalRevenueObserver(new TotalRevenueFileOutput());
    }

    /**
     * Performs a fake sale by calling all system operations in the controller.
     */
    public void runFakeExecution(){
        contr.startSale();
        try{
            System.out.println(contr.scanItem("abc123"));
            System.out.println(contr.scanItem("abc123"));
            System.out.println(contr.scanItem("def456"));
            System.out.println(contr.scanItem("invalidID"));
        } catch (Exception e){
            logger.log(e.getMessage());
            errorMsgHandler.showErrorMessage(e.getMessage());
        }
        try{
            contr.scanItem(InventoryHandler.DATABASE_FAILURE_ID);
        } catch (Exception e){
            logger.log(e.getMessage());
            errorMsgHandler.showErrorMessage(e.getMessage());
        }
        CustomerID customer1 = new CustomerID(70, false);

        contr.pay(new Amount(100), customer1);

        System.out.println("------------------ Begin Receipt -------------------");
        System.out.println(contr.printReceipt());
        System.out.println("------------------ End Receipt -------------------");
        System.out.println(contr.displayInfoToRegister());
    }


}
