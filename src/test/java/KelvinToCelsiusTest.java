import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class KelvinToCelsiusTest {

    private final Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @ParameterizedTest(name = "{0} K = {1} °C")
    @CsvSource({
            "0, -273.15",
            "273.15, 0",
            "300, 26.85",
            "373.15, 100"
    })
    public void testKelvinToCelsius(double kelvin, double expectedCelsius) {
        calculator.kelvinToCelsius(kelvin);
        assertEquals(expectedCelsius, calculator.getResult(), DELTA,
                "Kelvin to Celsius conversion does not seem to work correctly");
    }
}
