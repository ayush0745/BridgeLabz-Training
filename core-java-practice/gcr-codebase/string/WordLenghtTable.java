import java.util.Scanner;

public class WordLengthTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        // Split text into words manually
        String[] words = customSplit(input);

        
        String[][] wordData = getWordData(words);

        // 3. Display in tabular format
        System.out.println("\nWord Analysis Table");
        System.out.println("Word\t\tLength");
       

        for (int i = 0; i < wordData.length; i++) {
            String word = wordData[i][0];
            // Convert String length back to Integer for display
            int length = Integer.parseInt(wordData[i][1]);
            
            System.out.println(word + "  " + length);
        }
    }

    // Method to find length without .length() using Exception logic
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

    // Method to split text into words using charAt()
    public static String[] customSplit(String text) {
        int textLen = findLength(text);
        int spaceCount = 0;

        // Count spaces to determine array size
        for (int i = 0; i < textLen; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        String[] words = new String[spaceCount + 1];
        String currentWord = "";
        int wordIdx = 0;

        for (int i = 0; i < textLen; i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                words[wordIdx++] = currentWord;
                currentWord = "";
            } else {
                currentWord += c;
            }
        }
        words[wordIdx] = currentWord; // Catch the last word
        return words;
    }

  
    public static String[][] getWordData(String[] words) {
        String[][] data = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            // Get length of the specific word manually
            int len = findLength(words[i]);
            // Convert int to String using valueOf()
            data[i][1] = String.valueOf(len);
        }
        return data;
    }
}