import java.util.Scanner;

public class UpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Take user input
        System.out.println("Enter the text to convert:");
        String userInput = sc.nextLine();

        // Get Uppercase using built-in method
        String builtInUpper = userInput.toUpperCase();

        //  Get Uppercase using custom method
        String customUpper = manualToUpper(userInput);

        //  Compare using custom comparison method
        boolean match = compareStrings(builtInUpper, customUpper);

        // Display results
        System.out.println("\nOriginal: " + userInput);
        System.out.println("Built-in result: " + builtInUpper);
        System.out.println("Custom result:   " + customUpper);
        System.out.println("Do they match?   " + match);

        sc.close();
    }

   
    public static String manualToUpper(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            // Check if character is lowercase 
            if (ch >= 97 && ch <= 122) {
              
                result += (char) (ch - 32);
            } else {
                
                result += ch;
            }
        }
        return result;
    }

    // Method to compare two strings character by character
    public static boolean compareStrings(String s1, String s2) {
        // If lengths are different, they aren't the same
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