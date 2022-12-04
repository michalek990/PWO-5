import org.example.Zadanie_1.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Multiplication of calculator")
    void testMultiply() {
        assertEquals(10, calculator.multiply(2, 5),
                "Multiplication should work");
    }
    @RepeatedTest(10)
    @DisplayName("Ensure correct multiplication by zero")
    void testMultiplicationByZero() {
        assertEquals(0, calculator.multiply(0, 10),
                "Multiplication by zero should be zero");
        assertEquals(0, calculator.multiply(1, 0),
                "Multiplication by zero should be zero");
    }
    @RepeatedTest(10)
    @DisplayName("Ensure correct multiplication by one")
    void testMultiplicationByOne() {
        assertEquals(10, calculator.multiply(1, 10),
                "Multiplication ten by one should be ten");
        assertEquals(5, calculator.multiply(1, 5),
                "Multiplication five by one should be five");
    }

    @Test
    @DisplayName("Addition of calculator")
    void testAddition() {
        assertEquals(7, calculator.add(2, 5),
                "Addition should work");
    }
    @RepeatedTest(10)
    @DisplayName("Ensure correct addition with zero")
    void testAdditionWithZero() {
        assertEquals(10, calculator.add(0, 10),
                "Addition with zero should be ten");
        assertEquals(1, calculator.add(1, 0),
                "Addition with zero should be one");
    }

    @Test
    @DisplayName("Subtracting of calculator")
    void testSubtracting() {
        assertEquals(3, calculator.subtracting(5, 2),
                "Addition should work");
    }
    @RepeatedTest(10)
    @DisplayName("Ensure correct addition with zero")
    void testSubtractingWithZero() {
        assertEquals(-10, calculator.subtracting(0, 10),
                "Subtracting with zero should be minus ten");
        assertEquals(1, calculator.subtracting(1, 0),
                "Subtracting with zero should be one");
    }

    @Test
    @DisplayName("Dividing of calculator")
    void testDividing() {
        assertEquals(5, calculator.dividing(10, 2),
                "Dividing should work");
    }
    @RepeatedTest(10)
    @DisplayName("Ensure correct dividing by zero")
    void testDividingByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.dividing(10, 0));
        assertEquals("/ by zero", exception.getMessage(),
                "Dividing by zero should be zero");

    }
    @RepeatedTest(10)
    @DisplayName("Ensure correct multiplication by one")
    void testDividingByOne() {
        assertEquals(10, calculator.dividing(10, 1),
                "Dividing ten by one should be ten");
        assertEquals(5, calculator.dividing(5, 1),
                "Dividing five by one should be five");
    }

    public static int[][] data(){
        return new int[][]{{1,2,2}, {2,3,6}, {4,1,4}};
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    void testWithParameters(int[] data) {
        Calculator calculator = new Calculator();
        int val1 = data[0];
        int val2 = data[1];
        int result = data[2];
        assertEquals(result, calculator.multiply(val1, val2));
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 2", "2, 3, 6", "4, 1, 4" })
    void testMethodFromCSV(int val1, int val2, int result) {
        Calculator calculator = new Calculator();
        assertEquals(result, calculator.multiply(val1, val2));
    }
}
