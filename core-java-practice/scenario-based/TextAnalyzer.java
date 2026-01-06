import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine();

        // Edge case: empty or only spaces
        if (paragraph == null || paragraph.trim().isEmpty()) {
            System.out.println("The paragraph is empty or contains only spaces.");
            sc.close();
            return;
        }

        int wordCount = countWords(paragraph);
        String longestWord = findLongestWord(paragraph);

        System.out.print("Enter word to replace: ");
        String oldWord = sc.nextLine();

        System.out.print("Enter replacement word: ");
        String newWord = sc.nextLine();

        String updatedParagraph = replaceWord(paragraph, oldWord, newWord);

        System.out.println("\nWord Count: " + wordCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("\nUpdated Paragraph:");
        System.out.println(updatedParagraph);

        sc.close();
    }

    // Method to count words
    public static int countWords(String text) {
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // Method to find longest word
    public static String findLongestWord(String text) {
        String[] words = text.trim().split("\\s+");
        String longest = "";

        for (String word : words) {
            // Remove punctuation
            word = word.replaceAll("[^a-zA-Z]", "");
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    // Method to replace word (case-insensitive)
    public static String replaceWord(String text, String oldWord, String newWord) {
        return text.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
    }
}
