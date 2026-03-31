import java.util.Scanner;

public class MonthlyCalendar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input
        System.out.print("Enter month (1-12): ");
        int userMonth = scanner.nextInt();
        System.out.print("Enter year: ");
        int userYear = scanner.nextInt();

        // Get month name, first day, and total days
        String monthName = getMonthName(userMonth);
        int firstDay = getFirstDayOfMonth(userMonth, userYear);
        int totalDays = getDaysInMonth(userMonth, userYear);

        // Display results 
        displayCalendar(monthName, userYear, firstDay, totalDays);

        scanner.close();
    }

    // Method to get the name of the month using an array
    public static String getMonthName(int month) {
        String[] monthNames = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return monthNames[month];
    }

    // Method to check for Leap Year 
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    // Method to get number of days using an array and leap year check
    public static int getDaysInMonth(int month, int year) {
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return monthDays[month];
    }

    // Method to get the first day 
    public static int getFirstDayOfMonth(int m, int y) {
        int d = 1; 
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0; 
    }

    // Method to display the calendar
    public static void displayCalendar(String monthName, int year, int firstDay, int totalDays) {
        System.out.println("\n" + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

      
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    "); 
        }

        
        for (int day = 1; day <= totalDays; day++) {
           
            System.out.printf("%3d ", day);

            
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}