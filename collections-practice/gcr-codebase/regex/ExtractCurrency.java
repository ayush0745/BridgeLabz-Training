import java.util.*;
import java.util.regex.*;

public class ExtractCurrency {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        // Regex to match currency values like $45.99 or 10.50
        Pattern pattern = Pattern.compile("\\$?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);

        List<String> amounts = new ArrayList<>();
        while (matcher.find()) {
            amounts.add(matcher.group());
        }

        System.out.println(String.join(", ", amounts));
    }
}
