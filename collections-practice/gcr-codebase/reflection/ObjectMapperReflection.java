// This program implements a simple object mapper that sets fields from a Map using reflection.
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class User {
    public String username;
    public int age;
    private String secret;

    @Override
    public String toString() {
        return "User{username='" + username + "', age=" + age + ", secret='" + secret + "'}";
    }
}

public class ObjectMapperReflection {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String fieldName = entry.getKey();
            Object value = entry.getValue();

            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(instance, value);
            } catch (NoSuchFieldException e) {
                // Ignore unknown fields
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> props = new HashMap<>();
        props.put("username", "john_doe");
        props.put("age", 30);
        props.put("secret", "top-secret");

        User user = toObject(User.class, props);
        System.out.println("Mapped user: " + user);
    }
}


