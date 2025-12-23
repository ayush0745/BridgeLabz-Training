import java.util.Scanner;

public class FrequencyLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = sc.nextLine();

        // 1. Call the method to find frequencies
        String[] frequencyResults = findFrequency(userInput);

        // 2. Display the result
        System.out.println("\nCharacter Frequency Result:");
        System.out.println("---------------------------");
        for (String result : frequencyResults) {
            if (result != null) {
                System.out.println(result);
            }
        }
        
        sc.close();
    }

    // Method to find frequency using nested loops
    public static String[] findFrequency(String text) {
        char[] charArray = text.toCharArray();
        int[] freqArray = new int[charArray.length];
        
        // Step 1: Nested Loop logic to count frequencies
        for (int i = 0; i < charArray.length; i++) {
            // If the character is '0', it means it has already been counted
            if (charArray[i] == '0') {
                continue;
            }
            
            freqArray[i] = 1; // Initialize frequency to 1
            
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    freqArray[i]++; // Increment count
                    charArray[j] = '0'; // Set duplicate to '0' to avoid re-counting
                }
            }
        }

        // Step 2: Store characters and frequencies in a 1D String array
        String[] results = new String[charArray.length];
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            // Only store characters that weren't marked as '0'
            if (charArray[i] != '0' && charArray[i] != ' ') {
                results[count++] = charArray[i] + " occurs " + freqArray[i] + " times";
            }
        }
        
        return results;
    }
}