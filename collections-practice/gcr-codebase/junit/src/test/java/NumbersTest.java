import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumbersTest {

    private final Numbers numberUtils = new Numbers();

    //Test even numbers
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testIsEvenWithEvenNumbers(int number) {
        assertTrue(numberUtils.isEven(number));
    }

    //Test odd numbers
    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testIsEvenWithOddNumbers(int number) {
        assertFalse(numberUtils.isEven(number));
    }
}
