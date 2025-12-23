import java.util.Scanner;

public class IllegalArgumentException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String text = sc.next();

        // 1. Generate the crash
        // generateArgException(text); // Uncomment this to see the crash

        // 2. Handle the crash
        handleArgException(text);
    }

    public static void generateArgException(String text) {
        // Logically impossible: start at 5 and end at 2
        System.out.println(text.substring(5, 2));
    }

    public static void handleArgException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Start index cannot be greater than end index!");
        } catch (RuntimeException e) {
            System.out.println("A general runtime error occurred.");
        }
    }
}