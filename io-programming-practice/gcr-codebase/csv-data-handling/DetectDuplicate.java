import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicate {

    public static void main(String[] args) {

        String filePath = "students.csv";
        String line;

        // Stores unique IDs
        Set<String> seenIds = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            System.out.println("Duplicate Records:");
            System.out.println("------------------");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];

                // If ID already exists, it's a duplicate
                if (!seenIds.add(id)) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
