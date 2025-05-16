package view;

import controller.Controller;
import integration.InventoryHandler;
import model.Amount;
import util.FileLogger;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in this controller.
 */
public class View {
    private final Controller contr;
    private final ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
    private final FileLogger logger = FileLogger.getLogger();

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
        try{
            contr.scanItem("abc123");
            contr.scanItem("abc123");
            contr.scanItem("def456");
            contr.scanItem("invalidID");
//        } catch (ItemNotFoundException e){
//            logger.log(e.getMessage());
//            //logger.log("Item not found in inventory: " + e.getItemIDThatCanNotBeFound());
//            errorMsgHandler.showErrorMessage(e.getMessage());
        } catch (Exception e){ //according to page 188?
            logger.log(e.getMessage());
            errorMsgHandler.showErrorMessage("An unexpected error occurred while scanning the item.");
        }
        try{
            //used to throw a database failure exception (hardcoded)
            contr.scanItem(InventoryHandler.DATABASE_FAILURE_ID);
//        } catch (ItemNotFoundException e){
//            logger.log(e.getMessage());
//            //logger.log("Item not found in inventory: " + e.getItemIDThatCanNotBeFound());
//            errorMsgHandler.showErrorMessage(e.getMessage());
        } catch (Exception e){//according to page 188?
            logger.log(e.getMessage());
            errorMsgHandler.showErrorMessage("An unexpected error occurred while scanning the item.");
        }
        Amount amountPaid = new Amount(100);
        contr.endSaleAndPay(amountPaid);
    }
}
