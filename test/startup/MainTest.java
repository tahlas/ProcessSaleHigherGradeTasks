package startup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This uses the test from lecture 10. It is currently a placeholder...
 */
class MainTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUpStreams(){
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void cleanUpStreams(){
        outContent = null;
        System.setOut(originalSysOut);
    }

    @Test
    void testMain() {
        String[] args = null;
        Main.main(args);
        String result = outContent.toString();
        assertTrue(result.contains("Begin Receipt"),"The receipt header should be printed.");
        assertTrue(result.contains("End receipt"), "The receipt footer should be printed.");
    }


//    private Main instanceToTest;
//    private ByteArrayOutputStream printoutBuffer;
//    private PrintStream originalSysOut;
//
//    @BeforeEach
//    void setUp() {
//        instanceToTest = new Main();
//        printoutBuffer = new ByteArrayOutputStream();
//        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
//        originalSysOut = System.out;
//        System.setOut(inMemSysOut);
//    }
//
//    @AfterEach
//    void tearDown() {
//        instanceToTest = null;
//        printoutBuffer = null;
//        System.setOut(originalSysOut);
//    }
//
//    @Test
//    public void testUIHasStarted(){
//        String[] args = null;
//        Main.main(args);
//        String printout = printoutBuffer.toString();
//        String expectedOutput = "started";
//        assertTrue(printout.contains(expectedOutput), "UI did not start correctly");
//    }
}