import java.util.Scanner;

// Creating Class with name LeapYearLogical indicating the purpose is to 
// check if a year is a leap year using combined logical operators
public class LeapYearLogical {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a year: ");
        
        // Get the input value for the year
        int year = scanner.nextInt();

        // Ensure the year is within the Gregorian calendar range
        if (year >= 1582) {
            
            // Check if the year is divisible by 4 and not 100, or if it is divisible by 400
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                // If conditions are met, it is a leap year
                System.out.println(year + " is a Leap Year.");
            } 
            else {
                // If conditions are not met, it is not a leap year
                System.out.println(year + " is not a Leap Year.");
            }
            
        } 
        else {
            // Print a message for years outside the valid calendar range
            System.out.println("Year must be 1582 or later.");
        }
        
        // Closing the Scanner Stream
        scanner.close();
    }
}