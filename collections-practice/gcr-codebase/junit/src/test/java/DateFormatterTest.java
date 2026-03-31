import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    private DateFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new DateFormatter();
    }

    // Valid date
    @Test
    void testValidDate() {
        String result = formatter.formatDate("2024-01-30");
        assertEquals("30-01-2024", result);
    }

    // Invalid format
    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("30-01-2024");
        });
    }

    // Invalid date value
    @Test
    void testInvalidDateValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("2024-02-30");
        });
    }

    // Null input
    @Test
    void testNullDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate(null);
        });
    }
}
