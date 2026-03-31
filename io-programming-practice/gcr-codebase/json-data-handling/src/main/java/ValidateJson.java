import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ValidateJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // If JSON is invalid, this line will throw an exception
            mapper.readTree(new File("E:\\\\BridgeLabz-Training\\\\io-programming-practice\\\\gcr-codebase\\\\json-data-handling\\\\src\\\\main\\\\java\\\\json1.json"));

            System.out.println(" JSON is valid");

        } catch (Exception e) {
            System.out.println(" Invalid JSON");
            e.printStackTrace();
        }
    }
}
