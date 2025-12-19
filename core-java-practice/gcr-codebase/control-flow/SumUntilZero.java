
import java.util.Scanner;
// level 1 control flow problem
public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double userInput;
// enter 0  to stop
        System.out.print("Enter a number ");
        userInput = scanner.nextDouble();

        while (userInput != 0) {
            total += userInput;
            System.out.print("Enter another number ");
            userInput = scanner.nextDouble();
        }

        System.out.println("The final sum is: " + total);
    }
}