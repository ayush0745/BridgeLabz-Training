import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        int[] counts = countVowelsAndConsonants(text);

        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }

    public static String checkChar(char ch) {
        // Convert to lowercase using ASCII (A is 65, a is 97, diff is 32)
        if (ch >= 65 && ch <= 90) {
            ch = (char) (ch + 32);
        }

        if (ch >= 97 && ch <= 122) { // Is it a letter?
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static int[] countVowelsAndConsonants(String str) {
        int vCount = 0, cCount = 0;
        for (int i = 0; i < str.length(); i++) {
            String result = checkChar(str.charAt(i));
            if (result.equals("Vowel")) vCount++;
            else if (result.equals("Consonant")) cCount++;
        }
        return new int[]{vCount, cCount};
    }
}