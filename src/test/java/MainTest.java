import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MainTest {

    private final PrintStream originalOut = System.out;

    @AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainClassCanBeInstantiated() {
        Main app = new Main();
        assertTrue(app != null);
    }

    @Test
    public void testMainRunsAndPrintsExpectedOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Main.main(new String[0]);

        String consoleOutput = output.toString();
        assertTrue(consoleOutput.contains("...Power on..."));
        assertTrue(consoleOutput.contains("Add 500      = 500.0"));
        assertTrue(consoleOutput.contains("Add 200      = 700.0"));
        assertTrue(consoleOutput.contains("Subtract 100 = 600.0"));
        assertTrue(consoleOutput.contains("Divide by 2  = 300.0"));
        assertTrue(consoleOutput.contains("Multiply by 10 = 3000.0"));
        assertTrue(consoleOutput.contains("...Resetting..."));
        assertTrue(consoleOutput.contains("...Power off..."));
    }
}

