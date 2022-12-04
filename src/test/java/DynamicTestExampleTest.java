import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import java.util.Arrays;
import java.util.stream.Stream;

import org.example.Zadanie_1.Calculator;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class DynamicTestExampleTest {
    @TestFactory
    Stream<DynamicTest> testDifferentMultiplications() {
        Calculator calculator = new Calculator();
        int[][] data = new int[][]{{1,2,2}, {2,3,6}, {4,1,4}};
        return Arrays.stream(data).map(entry -> {
            int val1 = entry[0];
            int val2 = entry[1];
            int result = entry[2];
            return dynamicTest(val1+" * "+val2+" = "+ result,
                    () -> {
                        assertEquals(result, calculator.multiply(val1,val2));
                    });
        });
    }

    @TestFactory
    Stream<DynamicTest> testDifferentDividing() {
        Calculator calculator = new Calculator();
        int[][] data = new int[][]{{4,2,2}, {9,3,3}, {2,0,0}};
        return Arrays.stream(data).map(entry -> {
            int val1 = entry[0];
            int val2 = entry[1];
            int result = entry[2];
            return dynamicTest(val1+" / "+val2+" = "+ result,
                    () -> {
                        try {
                            int results = calculator.dividing(val1, val2);
                            assertEquals(result, results);
                        }
                        catch(ArithmeticException e){
                            // ERROR
                        }
                    });
        });
    }
}
