import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    // Valid password
    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("StrongPass1"));
    }

    // Less than 8 characters
    @Test
    void testShortPassword() {
        assertFalse(validator.isValid("Abc1"));
    }

    //  No uppercase letter
    @Test
    void testNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    //  No digit
    @Test
    void testNoDigit() {
        assertFalse(validator.isValid("Password"));
    }

    // Null password
    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}
