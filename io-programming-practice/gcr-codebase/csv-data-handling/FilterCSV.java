import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSV {
    public static void main(String[] args) {

        String filePath = "students.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            System.out.println("Students scoring more than 80 marks:");
            System.out.println("-----------------------------------");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                if (marks > 80) {
                    System.out.println(
                        "ID: " + id +
                        ", Name: " + name +
                        ", Age: " + age +
                        ", Marks: " + marks
                    );
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
