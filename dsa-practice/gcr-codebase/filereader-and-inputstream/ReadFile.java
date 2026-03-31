import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close(); // closes FileReader as well
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
