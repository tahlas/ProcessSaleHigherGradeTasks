package startup;

import controller.Controller;
import integration.HandlerCreator;
import integration.Printer;
import integration.Register;
import model.Amount;
import view.View;

/**
 * Starts the entire application, contains the main method used to start the application.
 */
public class Main {
    /**
     * The main method used to start the entire application.
     *
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args) {
        Printer printer = new Printer();
        Register register = new Register();
        HandlerCreator creator = new HandlerCreator(); //handlercreator ska skapa saker
        Controller contr = new Controller(printer, register, creator);
        View view = new View(contr);
        view.runFakeExecution();

//        //osäker om de ska vara här
//        contr.startSale();
//        contr.scanItem("abc123");
//        contr.scanItem("abc123");
//        contr.scanItem("def456");
//        contr.endSaleAndPay(new Amount(500));

    }
}