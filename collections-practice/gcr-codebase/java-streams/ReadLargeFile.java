import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {
    public static void main(String[] args) {

        String filePath = "large.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Case-insensitive check
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        }
    }
}
