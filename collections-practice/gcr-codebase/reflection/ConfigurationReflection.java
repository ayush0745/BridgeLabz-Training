// This program shows how to access and modify a private static field using reflection.
import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class ConfigurationReflection {
    public static void main(String[] args) throws Exception {
        System.out.println("Original API_KEY: " + Configuration.getApiKey());

        Class<Configuration> cls = Configuration.class;
        Field apiKeyField = cls.getDeclaredField("API_KEY");
        apiKeyField.setAccessible(true);

        apiKeyField.set(null, "NEW_SECRET_KEY_123");

        System.out.println("Modified API_KEY: " + Configuration.getApiKey());
    }
}


