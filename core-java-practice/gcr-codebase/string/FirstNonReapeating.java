import java.util.Scanner;

public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        char result = findFirstNonRepeating(input);

        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("All characters are repeating.");
        }
    }

    // Method to find the first non-repeating character
    public static char findFirstNonRepeating(String str) {
        // Step 1: Create frequency array for 256 ASCII characters
        int[] frequency = new int[256];

        // Step 2: Loop to count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i)]++;
        }

        // Step 3: Loop through text again to find first char with frequency 1
        for (int i = 0; i < str.length(); i++) {
            if (frequency[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return '\0'; // Return null character if none found
    }
}