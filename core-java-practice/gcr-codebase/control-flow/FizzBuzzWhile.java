
import java.util.Scanner;
// level 2 control flow problems
public class FizzBuzzWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            if (n > 0) {
                int i = 1; // Initialize counter
                while (i <= n) {
                    if (i % 3 == 0 && i % 5 == 0) {
                        System.out.println("FizzBuzz");
                    } else if (i % 3 == 0) {
                        System.out.println("Fizz");
                    } else if (i % 5 == 0) {
                        System.out.println("Buzz");
                    } else {
                        System.out.println(i);
                    }
                    i++; // Increment counter
                }
            } 
            else {
                System.out.println("Please enter a positive integer.");
            }
        } 
        else {
            System.out.println("Invalid input.");
        }
        scanner.close();
    }
}