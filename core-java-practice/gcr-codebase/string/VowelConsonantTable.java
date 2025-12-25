import java.util.Scanner;

public class VowelConsonantTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter some text: ");
        String input = sc.nextLine();

   
        String[][] analysis = analyzeString(input);

        // Display the results in a table
        displayTable(analysis);
        
        sc.close();
    }

    //Logic to check a single character
    public static String checkCharacterType(char ch) {
        // Convert to lowercase using ASCII 
        if (ch >= 65 && ch <= 90) {
            ch = (char) (ch + 32);
        }

        // Check if it is a letter 
        if (ch >= 97 && ch <= 122) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    //Process the string into a 2D array
    public static String[][] analyzeString(String str) {
        String[][] data = new String[str.length()][2];

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            data[i][0] = String.valueOf(currentChar);
            data[i][1] = checkCharacterType(currentChar); 
        }
        return data;
    }

    //  Display the 2D array in a tabular format
    public static void displayTable(String[][] table) {
        System.out.println("\nCharacter Analysis");
     

        for (int i = 0; i < table.length; i++) {
          
            System.out.println(table[i][0] + "  " + table[i][1]);
        }
    }
}