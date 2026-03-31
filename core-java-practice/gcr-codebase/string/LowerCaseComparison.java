import java.util.Scanner;

public class LowerCaseComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.println("Enter the text to convert to lowercase:");
        String userInput = sc.nextLine();

        // Get Lowercase using the built-in String method
        String builtInLower = userInput.toLowerCase();

        // Get Lowercase using our custom 
        String customLower = manualToLower(userInput);

        // Compare the two results 
        boolean match = compareStrings(builtInLower, customLower);

        // 5. Display results
        System.out.println("\nOriginal: " + userInput);
        System.out.println("Built-in result: " + builtInLower);
        System.out.println("Custom result:   " + customLower);
        System.out.println("Do they match?   " + match);

        sc.close();
    }

    // Method to convert uppercase to lowercase 
    public static String manualToLower(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
         
            if (ch >= 65 && ch <= 90) {
                
                result += (char) (ch + 32);
            } else {
              
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