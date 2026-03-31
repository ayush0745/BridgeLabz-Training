import java.util.Scanner;
//level 2 control flow problem

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();

        System.out.print("Enter the power : ");
        int power = scanner.nextInt();

        // Check for positive integers
        if (number >= 0 && power >= 0) {
            long result = 1; 
            
            for (int i = 1; i <= power; i++) {
                result = result * number;
            }

            System.out.println(number + " raised to the power of " + power + " is: " + result);
        }
        else {
            System.out.println("Please enter positive integers for both inputs.");
        }
        scanner.close();
    }
}
      