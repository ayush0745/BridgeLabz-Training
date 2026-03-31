import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String fileName = "input2.txt";
        Map<String, Integer> wordCount = new HashMap<>();

        // 🔹 Reading file and counting words
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {

                // Remove punctuation & convert to lowercase
                String[] words = line
                        .toLowerCase()
                        .replaceAll("[^a-zA-Z ]", "")
                        .split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word,
                                wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
            return;
        }

        // 🔹 Sorting words by frequency
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(wordCount.entrySet());

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // 🔹 Display top 5 words
        System.out.println("Top 5 most frequent words:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
            count++;
            if (count == 5)
                break;
        }
    }
}
