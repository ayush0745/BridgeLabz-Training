import java.util.*;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();

        System.out.print("Word to replace: ");
        String target = scanner.next();

        System.out.print("Replace with: ");
        String replacement = scanner.next();

        String ans = replaceWord(sentence, target, replacement);

        System.out.println("Modified sentence: " + ans);
    }

    public static String replaceWord(String sentence, String target, String replacement) {
        // Split sentence into words
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            // Check if current word matches the target
            if (words[i].equals(target)) {
                result.append(replacement);
            } else {
                result.append(words[i]);
            }

          
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}