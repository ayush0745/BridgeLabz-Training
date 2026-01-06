import java.util.Scanner;

public class SentenceFormatter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String input = sc.nextLine();

        String formattedText = formatSentence(input);

        System.out.println("\nFormatted Text:");
        System.out.println(formattedText);

        sc.close();
    }

    // Method to format the paragraph
    public static String formatSentence(String text) {

        // Trim leading and trailing spaces
        text = text.trim();

        // Replace multiple spaces with a single space
        text = text.replaceAll("\\s+", " ");

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Capitalize the first letter of each sentence
            if (capitalizeNext && Character.isLetter(ch)) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }

            // After punctuation, prepare to capitalize next letter
            if (ch == '.' || ch == '?' || ch == '!') {
                capitalizeNext = true;

                // Ensure one space after punctuation
                if (i + 1 < text.length() && text.charAt(i + 1) != ' ') {
                    result.append(' ');
                }
            }
        }

        return result.toString().trim();
    }
}
