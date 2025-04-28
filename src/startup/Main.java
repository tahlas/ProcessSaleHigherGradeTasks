package startup;

import controller.Controller;
import integration.HandlerCreator;
import integration.Printer;
import integration.Register;
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
        HandlerCreator creator = new HandlerCreator(); //handlercreator ska skapa saker
        Register register = new Register();
        Printer printer = new Printer();
        Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeExecution();
    }
}