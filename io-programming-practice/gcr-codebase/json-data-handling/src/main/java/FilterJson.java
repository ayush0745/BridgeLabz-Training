import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Iterator;

public class FilterJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read JSON array
            JsonNode rootNode = mapper.readTree(new File("E:\\\\BridgeLabz-Training\\\\io-programming-practice\\\\gcr-codebase\\\\json-data-handling\\\\src\\\\main\\\\java\\\\students.json"));

            System.out.println("Students with age > 25:");

            // Loop through JSON array
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode student = elements.next();

                int age = student.get("age").asInt();

                if (age > 25) {
                    System.out.println(student.toPrettyString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
