public class CensorWord {

    public static void main(String[] args) {

        String input = "This is a damn bad example with some stupid words.";

        // List of bad words
        String badWordsRegex = "\\b(damn|stupid)\\b";

        // Replace bad words with ****
        String output = input.replaceAll(badWordsRegex, "****");

        System.out.println(output);
    }
}
