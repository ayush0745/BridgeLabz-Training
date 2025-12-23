import java.util.Scanner;


public class IndexExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter some text: ");
        String text = sc.nextLine();

        // 1. Generate Exception (will crash the program)
        // generateIndexException(text);

        // 2. Handle Exception (safe)
        handleIndexException(text);
    }

    public static void generateIndexException(String text) {
        System.out.println("Crashing with index out of bounds...");
        // Using length of string as index (which is always 1 out of bounds)
        System.out.println(text.charAt(text.length())); 
    }

    public static void handleIndexException(String text) {
        try {
            System.out.println("Safe check: Accessing invalid index...");
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e);
        }
    }
}