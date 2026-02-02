import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {

        String filePath = "employees.csv";

        try (FileWriter writer = new FileWriter(filePath)) {

            // Write header
            writer.append("ID,Name,Department,Salary\n");

            // Write employee records
            writer.append("1,Ayush,IT,50000\n");
            writer.append("2,Rahul,HR,45000\n");
            writer.append("3,Priya,Finance,55000\n");
            writer.append("4,Neha,Marketing,48000\n");
            writer.append("5,Amit,Operations,47000\n");

            System.out.println("CSV file written successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
