import java.util.Scanner;
// level 1 control flow problem
public class SumWithBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double userInput;

        while (true) {
           
            userInput = scanner.nextDouble();

            // Break condition: 0 or negative
            if (userInput <= 0) {
                break; 
            }

            total += userInput;
        }

        System.out.println("The final sum is: " + total);
    }
}