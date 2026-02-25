import static org.junit.jupiter.api.Assertions.assertEquals;



public class KelvinToCelsiusTest {

    private Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @org.junit.jupiter.api.Test
    public void testKelvinToCelsius() {
        calculator.kelvinToCelsius(0);
        assertEquals(-273.15, calculator.getResult(), DELTA, "Kelvin to Celsius conversion does not seem to work correctly");
    }
}
