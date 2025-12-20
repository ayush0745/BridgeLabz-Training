// Creating Class with name DayOfWeek indicating the purpose is to 
// calculate the day of the week for a given date using Gregorian formulas

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
    	// Create a Scanner Object
        Scanner scanner = new Scanner(System.in);
        
        //Taking the input for month, day, and year;
        System.out.println("Enter the month: ");
        int m = scanner.nextInt();
        System.out.println("Enter the day: ");
        int d = scanner.nextInt();
        System.out.println("Enter the year: ");
        int y = scanner.nextInt();

        // Calculate the value for y0 to handle leap year adjustments
        int y0 = y - (14 - m) / 12;

        // Calculate the value for x to help determine the day offset
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;

        // Calculate the value for m0 to shift the months
        int m0 = m + 12 * ((14 - m) / 12) - 2;

        // Find the final day of the week d0 where 0 is Sunday and 6 is Saturday
        int d0 = (d + x + (31 * m0) / 12) % 7;

        // Print the result representing the day of the week
        System.out.println(d0);
    }
}