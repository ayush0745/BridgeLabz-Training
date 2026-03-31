import java.util.Scanner;

// Creating Class with name HarshadChecker indicating the purpose is to 
// check if a number is divisible by the sum of its digits
public class HarshadChecker {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        
        // Get the input value for the number variable
        int number = scanner.nextInt();
        
        // Create an integer variable sum with initial value 0
        int sum = 0;
        
        // Store the input in a temporary variable to process digits
        int temp = number;

        // Create a while loop to access each digit of the number
        while (temp != 0) {
            // Find the last digit using the modulus operator
            int digit = temp % 10;
            
            // Inside the loop, add each digit of the number to sum
            sum = sum + digit;
            
            // Remove the last digit using integer division
            temp = temp / 10;
        }

        // Check if the number is perfectly divisible by the sum
        if (number % sum == 0) {
            // If the number is divisible by the sum, print Harshad Number
            System.out.println(number + " is a Harshad Number.");
        } else {
            // Otherwise, print Not a Harshad Number
            System.out.println(number + " is Not a Harshad Number.");
        }

        // Closing the Scanner Stream
        scanner.close();
    }
}