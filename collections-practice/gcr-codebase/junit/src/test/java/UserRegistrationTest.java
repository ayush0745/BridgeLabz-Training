
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    private UserRegistration registration;

    @BeforeEach
    void setUp() {
        registration = new UserRegistration();
    }

    // Valid registration
    @Test
    void testValidUserRegistration() {
        assertTrue(registration.registerUser(
                "ayush",
                "ayush@gmail.com",
                "Password123"
        ));
    }

    // Invalid username
    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("", "test@gmail.com", "Password123");
        });
    }

    // Invalid email
    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("ayush", "gmail.com", "Password123");
        });
    }

    // Invalid password
    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("ayush", "ayush@gmail.com", "pass");
        });
    }

    // ❌ Null values
    @Test
    void testNullValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser(null, null, null);
        });
    }
}
