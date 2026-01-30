import java.util.*;
import java.util.regex.*;

public class ExtractLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // List of programming languages
        String[] languages = {"Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "PHP", "Swift", "Kotlin", "Rust"};

        List<String> foundLanguages = new ArrayList<>();

        for (String lang : languages) {
            // Use regex to match whole words, case-insensitive
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(lang) + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                foundLanguages.add(lang);
            }
        }

        // Print result
        System.out.println(String.join(", ", foundLanguages));
    }
}
