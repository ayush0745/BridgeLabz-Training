import java.util.Scanner;

// Creating Class with name DigitCounter indicating the purpose is to 
// count the total number of digits in a given integer
public class DigitCounter {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        
        // Get the input value for the number to be processed
        int number = scanner.nextInt();
        
        // Initialize the count variable to track the number of digits
        int count = 0;

        // Handle the specific case where the input is 0 since it has one digit
        if (number == 0) {
            count = 1;
        } 
        else {
            
            // Loop until the number becomes zero to count each position
            while (number != 0) {
                // Remove the last digit using integer division by 10
                number = number / 10;
                
                // Increment the counter for each digit removed
                count++;
            }
        }

        // Display the final count of digits to the console
        System.out.println("Number of digits: " + count);
        
        // Closing the Scanner Stream
        scanner.close();
    }
}
