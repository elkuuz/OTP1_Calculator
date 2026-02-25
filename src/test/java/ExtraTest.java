
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExtraTest extends AbstractParent {

    private static Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testPowerOn() {
        System.out.println("@BeforeAll Power ON (before the first test)");
        calculator.powerOn();
    }

    @AfterAll
    public static void testPowerOff() {
        System.out.println("@AfterAll Power OFF (all tests executed).");
        calculator.powerOff();
        calculator = null;
    }

    @BeforeEach
    public void testReset() {
        System.out.println("  Reset calculator.");
        calculator.reset();
        assertEquals(0, calculator.getResult(), "Reset failed");
    }

    @ParameterizedTest (name = "square ({0}) = {1}")
    @CsvSource({
        "2, 4",
        "4, 16",
        "5, 25"
    })

    public void testSquare(int input, int expected) {
        calculator.square(input);
        assertEquals(expected, calculator.getResult(), "Square does not seem to work correctly");
    }

    @ParameterizedTest(name = "sqrt({0}) = {1}")
    @CsvSource({
        "4, 2",
        "9, 3",
        "2, 1.414213562"
    })

    public void testSquareRootParameterized(double input, double expected) {
        calculator.squareRoot(input);
        assertEquals(expected, calculator.getResult(), DELTA, "Square root is incorrect");
    }

    @Test
    @DisplayName("Test negative square root")
    public void testSquareRootNegative() {
        assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-1),
                "Negative input should throw IllegalArgumentException");
    }
}
