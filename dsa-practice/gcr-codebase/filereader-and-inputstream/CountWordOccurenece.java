import java.io.*;

public class CountWordOccurrence {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String targetWord = "Java";
        int count = 0;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }

            bufferedReader.close();
            System.out.println("Occurrences of '" + targetWord + "': " + count);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
