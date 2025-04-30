package view;

import controller.Controller;
import integration.HandlerCreator;
import integration.Printer;
import integration.Register;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Handler;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private Printer printerToTest;
    private Register registerToTest;
    private Handler creatorToTest;
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        Printer printer = new Printer();
        Register register = new Register();
        HandlerCreator creator = new HandlerCreator();
        Controller contr = new Controller(printer, register, creator);
        instanceToTest = new View(contr);

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {

        instanceToTest = null;
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testRunFakeExecution(){
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();
        String expectedOutput = "started";
        assertTrue(printout.contains(expectedOutput), "UI did not start correctly");
    }

}