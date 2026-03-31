import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String text1 = "My SSN is 123-45-6789.";
        String text2 = "My SSN is 123456789.";

        validateSSN(text1);
        validateSSN(text2);
    }

    public static void validateSSN(String text) {
        // Regex for valid SSN format: XXX-XX-XXXX
        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("\"" + matcher.group() + "\" is valid");
        } else {
            // Optionally, check if there's a number without dashes
            Pattern simplePattern = Pattern.compile("\\b\\d{9}\\b");
            Matcher simpleMatcher = simplePattern.matcher(text);
            if (simpleMatcher.find()) {
                System.out.println(" \"" + simpleMatcher.group() + "\" is invalid");
            } else {
                System.out.println("No valid SSN found in the text");
            }
        }
    }
}
