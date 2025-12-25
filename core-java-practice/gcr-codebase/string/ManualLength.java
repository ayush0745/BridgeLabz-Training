import java.util.Scanner;

public class ManualLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String text = sc.next();

        // Manual Length
        int customLen = getLengthManually(text);
        
        //  Built-in Length
        int builtInLen = text.length();

        System.out.println("Custom length calculation: " + customLen);
        System.out.println("Built-in length calculation: " + builtInLen);
        
        sc.close();
    }

    public static int getLengthManually(String str) {
        int count = 0;
        try {
            // Infinite loop that will eventually crash
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // The crash means we reached the end!
            return count;
        }
    }
}