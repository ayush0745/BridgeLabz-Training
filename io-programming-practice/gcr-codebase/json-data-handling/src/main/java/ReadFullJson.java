import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadFullJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read JSON file
            JsonNode rootNode = mapper.readTree(new File("E:\\\\\\\\BridgeLabz-Training\\\\\\\\io-programming-practice\\\\\\\\gcr-codebase\\\\\\\\json-data-handling\\\\\\\\src\\\\\\\\main\\\\\\\\java\\\\\\\\json1.json"));

            System.out.println("Keys and Values in JSON:");

            Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                String key = field.getKey();
                String value = field.getValue().asText();
                System.out.println(key + " : " + value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
