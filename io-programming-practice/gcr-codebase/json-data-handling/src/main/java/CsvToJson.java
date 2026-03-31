import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.util.List;
import java.util.Map;

public class CsvToJson {
    public static void main(String[] args) {
        try {
            File csvFile = new File("E:\\BridgeLabz-Training\\io-programming-practice\\gcr-codebase\\csv-data-handling\\students.csv");

            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header

            // Read CSV into List of Maps
            MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(csvFile);

            List<Map<String, String>> csvList = it.readAll();

            // Convert List of Maps to JSON
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writerWithDefaultPrettyPrinter()
                                    .writeValueAsString(csvList);

            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
