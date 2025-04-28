package view;

import controller.Controller;

import java.sql.SQLOutput;

/**
 * This is a placeholder for the real view. it contains a hardcoded execution with calls to all
 * system operations in this controller.
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance, that uses the specified controller for alls to other layers.
     *
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr){
        this.contr = contr;
    }

    /**
     * Performs a fake sale, bu calling all system operations in the controller.
     */
    public void runFakeExecution(){
        contr.startSale();
        System.out.println("A new sale has been started.");
    }
}
