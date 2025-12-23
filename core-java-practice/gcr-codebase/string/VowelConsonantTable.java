import java.util.Scanner;

public class VowelConsonantTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter some text: ");
        String input = sc.nextLine();

        // 1. Generate the 2D analysis data
        String[][] analysis = analyzeString(input);

        // 2. Display the results in a table
        displayTable(analysis);
        
        sc.close();
    }

    // Method 1: Logic to check a single character
    public static String checkCharacterType(char ch) {
        // Convert to lowercase using ASCII (A=65, a=97, diff=32)
        if (ch >= 65 && ch <= 90) {
            ch = (char) (ch + 32);
        }

        // Check if it is a letter (a-z)
        if (ch >= 97 && ch <= 122) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method 2: Process the string into a 2D array
    public static String[][] analyzeString(String str) {
        String[][] data = new String[str.length()][2];

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            data[i][0] = String.valueOf(currentChar); // Store the char as String
            data[i][1] = checkCharacterType(currentChar); // Store the type
        }
        return data;
    }

    // Method 3: Display the 2D array in a tabular format
    public static void displayTable(String[][] table) {
        System.out.println("\n--- Character Analysis ---");
        System.out.println("Char\tType");
        System.out.println("--------------------------");

        for (int i = 0; i < table.length; i++) {
            // Using \t for simple column alignment
            System.out.println(table[i][0] + "\t" + table[i][1]);
        }
    }
}