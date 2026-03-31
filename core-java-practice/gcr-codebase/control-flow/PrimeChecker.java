import java.util.Scanner;

// Creating Class with name PrimeChecker indicating the purpose is to 
// determine if a number has only two factors: 1 and itself
public class PrimeChecker {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to check if it is prime: ");
        
        // Get the input value for the number to be checked
        int number = scanner.nextInt();

        // Initialize a boolean to true if number is greater than 1
        boolean isPrime = number > 1;

        // Perform check only if the number is greater than 1
        if (number > 1) {
            
            // Loop through all numbers starting from 2 up to the number
            for (int i = 2; i < number; i++) {
              
                // Check if the number is divisible by the current loop index
                if (number % i == 0) {
                    // If divisible, it is not prime and we stop the loop
                    isPrime = false;
                    break;
                }
            }
        }

        // Check the boolean status and print the final result
        if (isPrime) {
            System.out.println(number + " is a Prime Number.");
        } 
        else {
            System.out.println(number + " is not a Prime Number.");
        }

        // Closing the Scanner Stream
        scanner.close();
    }
}