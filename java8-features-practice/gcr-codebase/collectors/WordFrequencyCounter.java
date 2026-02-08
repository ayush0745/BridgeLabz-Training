import java.util.*;
import java.util.stream.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        String paragraph = "Java is powerful and Java is popular and Java is fast";

        // Convert paragraph to word frequency map
        Map<String, Integer> wordCount =
                Arrays.stream(paragraph.toLowerCase().split("\\s+"))
                      .collect(Collectors.toMap(
                              word -> word,      // key = word
                              word -> 1,         // initial count
                              Integer::sum       // merge function for duplicates
                      ));

        // Print result
        wordCount.forEach((word, count) ->
                System.out.println(word + " : " + count));
    }
}
