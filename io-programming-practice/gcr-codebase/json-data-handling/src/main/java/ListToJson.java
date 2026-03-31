import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Student> students = Arrays.asList(
                    new Student("Ayush", 20),
                    new Student("Rohit", 22),
                    new Student("Neha", 21)
            );

            // Convert List to JSON array
            String jsonArray = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(students);

            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
