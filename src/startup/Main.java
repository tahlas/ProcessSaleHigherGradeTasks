package startup;

import controller.Controller;
import integration.*;
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
        Register register = new Register(new Amount(1000));
        HandlerCreator creator = HandlerCreator.getHandlerCreator();
        Controller contr = new Controller(printer, register, creator);
        View view = new View(contr);
        view.runFakeExecution();
    }
}