import java.util.Scanner;

public class ManualSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        // 1. Built-in split
        String[] builtInWords = text.split(" ");

        // 2. Custom split
        String[] customWords = customSplit(text);

        // 3. Compare and Display
        boolean match = compareArrays(builtInWords, customWords);
        
        System.out.println("\nResults match: " + match);
        System.out.println("Words found: ");
        for (String w : customWords) {
            System.out.println("- " + w);
        }
    }

    // Helper method to find length without .length()
    public static int findLength(String s) {
        int count = 0;
        try {
            while (true) { s.charAt(count); count++; }
        } catch (Exception e) { return count; }
    }

    public static String[] customSplit(String text) {
        int len = findLength(text);
        int spaceCount = 0;

        // Count spaces to determine number of words
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') spaceCount++;
        }

        int wordCount = spaceCount + 1;
        String[] words = new String[wordCount];
        int wordIndex = 0;
        String currentWord = "";

        // Loop through and build words character by character
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words[wordIndex++] = currentWord;
                currentWord = ""; // reset for next word
            } else {
                currentWord += text.charAt(i);
            }
        }
        words[wordIndex] = currentWord; // Add the last word
        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
}