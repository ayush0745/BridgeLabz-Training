import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read JSON file
            JsonNode rootNode = mapper.readTree(new File("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data-handling\\src\\main\\java\\user.json"));

            // Extract specific fields
            String name = rootNode.get("name").asText();
            String email = rootNode.get("email").asText();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
