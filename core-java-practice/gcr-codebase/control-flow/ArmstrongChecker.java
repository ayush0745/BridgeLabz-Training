import java.util.Scanner;

// Creating Class with name ArmstrongChecker indicating the purpose is to 
// check if the sum of the cubes of its digits is equal to the number itself
public class ArmstrongChecker {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        
        // Get the input value for the number to be checked
        int number = scanner.nextInt();
        
        // Initialize the sum variable to store the result of the cubes
        int sum = 0;
        
        // Store the input in originalNumber to process it without losing the original value
        int originalNumber = number;

        // Loop until originalNumber becomes zero to process every digit
        while (originalNumber != 0) {
            
            // Find the last digit of the number using the modulus operator
            int digit = originalNumber % 10;
            
            // Add the cube of the extracted digit to the running sum
            sum = sum + (digit * digit * digit);
            
            // Remove the last digit from the number using integer division
            originalNumber = originalNumber / 10;
        }

        // Compare the original input number with the calculated sum of cubes
        if (number == sum) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        
        // Closing the Scanner Stream
        scanner.close();
    }
}