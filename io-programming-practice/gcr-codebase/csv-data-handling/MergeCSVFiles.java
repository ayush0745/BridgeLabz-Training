import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {

    public static void main(String[] args) {

        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "students_merged.csv";

        Map<String, String[]> marksMap = new HashMap<>();
        String line;

        try (
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            FileWriter writer = new FileWriter(outputFile)
        ) {

            // Skip header of students2.csv
            br2.readLine();

            // Store ID -> (Marks, Grade)
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                marksMap.put(data[0], new String[]{data[1], data[2]});
            }

            // Write header to output file
            writer.append("ID,Name,Age,Marks,Grade\n");

            // Skip header of students1.csv
            br1.readLine();

            // Merge data
            while ((line = br1.readLine()) != null) {
                String[] data1 = line.split(",");
                String id = data1[0];

                if (marksMap.containsKey(id)) {
                    String[] data2 = marksMap.get(id);

                    writer.append(
                        id + "," +
                        data1[1] + "," +
                        data1[2] + "," +
                        data2[0] + "," +
                        data2[1] + "\n"
                    );
                }
            }

            System.out.println("CSV files merged successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
