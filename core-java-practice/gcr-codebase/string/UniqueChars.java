import java.util.Scanner;

public class UniqueChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        // Get length manually
        int len = findLength(input);

        //Extract unique characters
        char[] uniqueResult = findUniqueChars(input, len);

        //Display result
        System.out.print("Unique characters: ");
        for (char c : uniqueResult) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        sc.close();
    }

   
    public static int findLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    // Method to find unique characters
    public static char[] findUniqueChars(String str, int len) {
        char[] tempArray = new char[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char currentChar = str.charAt(i);
            boolean isDuplicate = false;

            // Inner loop check if currentChar appeared in the string before index i
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == currentChar) {
                    isDuplicate = true;
                    break;
                }
            }

            // If not found earlier, it is unique for its first occurrence
            if (!isDuplicate) {
                tempArray[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        // Create a final array with the exact size of unique characters found
        char[] finalArray = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            finalArray[i] = tempArray[i];
        }

        return finalArray;
    }
}