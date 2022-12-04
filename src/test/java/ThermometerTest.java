import org.example.Zadanie_1.Calculator;
import org.example.Zadanie_1.Thermometer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThermometerTest {
    Thermometer thermometer;
    @BeforeEach
    void init() {
        thermometer = new Thermometer(10, 30);
        thermometer.setCurrentTemp(20);
    }

    @Test
    @DisplayName("Ensure correct adding a degrees (NotEquals)")
    void testAddingDegreesNotEquals() {
        assertNotEquals(20, thermometer.addDegrees(5),
                "Adding 5 degrees shouldnt be 20");

    }

    @Test
    @DisplayName("Ensure correct adding a degrees (Equals)")
    void testAddingDegreesEquals() {
        assertEquals(25, thermometer.addDegrees(5),
                "Adding 5 degrees shouldnt be 25");

    }

    @Test
    @DisplayName("CurrentTemp should be belowe zero (AssertTrue)")
    void testCurrentTempBelowZeroAssertTrue() {
        thermometer.setCurrentTemp(-1);
        assertTrue(thermometer.isBelowZero());
    }

    @Test
    @DisplayName("CurrentTemp should be belowe zero (AssertFalse)")
    void testCurrentTempBelowZeroAssertFalse() {
        thermometer.setCurrentTemp(10);
        assertFalse(thermometer.isBelowZero());
    }

    @Test
    @DisplayName("CurrentTemp should be null (assertNull)")
    void testCurrentTempShouldBeNull() {
        thermometer.setCurrentTemp((Integer) null);
        assertNull(thermometer.getCurrentTemp());
    }

    @Test
    @DisplayName("CurrentTemp should be not null (assertNotNull)")
    void testCurrentTempShouldBeNotNull() {
        thermometer.setCurrentTemp(1);
        assertNotNull(thermometer.getCurrentTemp());
    }

    // ZADANIE 1.3
    @Test
    void exceptionTesting() {
        Throwable exception =
                assertThrows(NumberFormatException.class, () -> thermometer.setCurrentTemp(Integer.valueOf("es")));
        assertEquals("For input string: \"es\"", exception.getMessage());
    }
}
