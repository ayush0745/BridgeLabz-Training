import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] frequencyData = getFrequencyArray(input);

        System.out.println("\nCharacter Frequency Table:");
        System.out.println("Char\tFrequency");
        System.out.println("-----------------");
        for (int i = 0; i < frequencyData.length; i++) {
            System.out.println(frequencyData[i][0] + "\t" + frequencyData[i][1]);
        }
    }

    public static String[][] getFrequencyArray(String str) {
        // Step 1: Use ASCII array to count frequencies
        int[] counts = new int[256];
        int uniqueCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (counts[ch] == 0) {
                uniqueCount++; // Count unique characters to size the 2D array
            }
            counts[ch]++;
        }

        // Step 2: Store unique characters and frequencies in 2D array
        String[][] result = new String[uniqueCount][2];
        int rowIndex = 0;
        
        // Track which characters we've already added to the result
        boolean[] added = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!added[ch]) {
                result[rowIndex][0] = String.valueOf(ch);
                result[rowIndex][1] = String.valueOf(counts[ch]);
                added[ch] = true;
                rowIndex++;
            }
        }
        return result;
    }
}