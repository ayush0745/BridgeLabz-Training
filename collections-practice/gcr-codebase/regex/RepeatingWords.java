import java.util.*;
import java.util.regex.*;

public class RepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        // Regex to find repeating words
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b\\s+\\1", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> repeatingWords = new LinkedHashSet<>(); // to keep order & avoid duplicates

        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }

        System.out.println(String.join(", ", repeatingWords));
    }
}
