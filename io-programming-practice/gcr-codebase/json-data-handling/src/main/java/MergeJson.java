import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class MergeJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read both JSON files
            ObjectNode json1 = (ObjectNode) mapper.readTree(new File("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data-handling\\src\\main\\java\\json1.json"));
            ObjectNode json2 = (ObjectNode) mapper.readTree(new File("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\json-data-handling\\src\\main\\java\\json2.json"));

            // Merge json2 into json1
            json1.setAll(json2);

            // Print merged JSON
            System.out.println(json1.toPrettyString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
