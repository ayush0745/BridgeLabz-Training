import java.lang.annotation.*;
import java.lang.reflect.Field;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.FIELD)           // Can only be applied to fields
@interface MaxLength {
    int value(); // Maximum allowed length
}

//  User class with a field annotated
class User {
    
    @MaxLength(10) // Maximum length of 10 characters
    private String username;

    // Constructor with validation
    public User(String username) {
        this.username = username;
        validateFields(); // Check annotated fields
    }

    // Validate fields annotated with @MaxLength
    private void validateFields() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                field.setAccessible(true);
                try {
                    Object value = field.get(this);
                    if (value instanceof String) {
                        String str = (String) value;
                        if (str.length() > maxLength.value()) {
                            throw new IllegalArgumentException(
                                field.getName() + " exceeds maximum length of " + maxLength.value()
                            );
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }
}

// Test the annotation
public class MaxLengthAnnotation {
    public static void main(String[] args) {
        try {
            User user1 = new User("ShortName"); // Valid
            System.out.println("User1 created: " + user1.getUsername());

            User user2 = new User("ThisNameIsWayTooLong"); // Invalid
            System.out.println("User2 created: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
