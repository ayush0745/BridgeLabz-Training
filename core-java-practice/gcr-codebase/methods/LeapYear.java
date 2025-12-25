import java.util.Scanner;

public class LeapYearChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }
        sc.close();
    }

     // Checks if a year is a leap year based on Gregorian calendar rules.
     
    public static boolean isLeapYear(int year) {
      
        if (year < 1582) {
            System.out.println("Year must be 1582 or later");
            return false;
        }

        
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        
        return false;
    }
}