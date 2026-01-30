import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    void testDivideByZeroThrowsException() {
        MathUtils mathUtils = new MathUtils();

        assertThrows(ArithmeticException.class, () -> {
            mathUtils.divide(10, 0);
        });
    }
}