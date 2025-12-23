import java.util.Scanner;

public class LowerCaseComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Take user input (nextLine captures spaces)
        System.out.println("Enter the text to convert to lowercase:");
        String userInput = sc.nextLine();

        // 2. Get Lowercase using the built-in String method
        String builtInLower = userInput.toLowerCase();

        // 3. Get Lowercase using our custom ASCII method
        String customLower = manualToLower(userInput);

        // 4. Compare the two results using our custom comparison method
        boolean match = compareStrings(builtInLower, customLower);

        // 5. Display results
        System.out.println("\nOriginal: " + userInput);
        System.out.println("Built-in result: " + builtInLower);
        System.out.println("Custom result:   " + customLower);
        System.out.println("Do they match?   " + match);

        sc.close();
    }

    // Method to convert uppercase to lowercase using ASCII math
    public static String manualToLower(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            // Check if character is Uppercase ('A' is 65, 'Z' is 90)
            if (ch >= 65 && ch <= 90) {
                // Add 32 to move from Uppercase range to Lowercase range
                result += (char) (ch + 32);
            } else {
                // If it's already lowercase or a symbol, keep it as is
                result += ch;
            }
        }
        return result;
    }

    // Method to compare two strings character by character
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}