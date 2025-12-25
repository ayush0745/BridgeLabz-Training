import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month  and year : ");
        int month = sc.nextInt();
        int year = sc.nextInt();

        displayCalendar(month, year);
    }

    // Method to get month name
    public static String getMonthName(int m) {
        String[] months = {"", "January", "February", "March", "April", "May", "June", 
                           "July", "August", "September", "October", "November", "December"};
        return months[m];
    }

    // Method to check for Leap Year
    public static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    // Method to get number of days in month
    public static int getDaysInMonth(int m, int y) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (m == 2 && isLeapYear(y)) return 29;
        return days[m];
    }

    // Gregorian algorithm 
    public static int getFirstDay(int m, int y) {
        int d = 1;
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (d + x + (31 * m0) / 12) % 7;
    }

    public static void displayCalendar(int m, int y) {
        String monthName = getMonthName(m);
        int daysInMonth = getDaysInMonth(m, y);
        int firstDay = getFirstDay(m, y);

        System.out.println("    " + monthName + " " + y);
        System.out.println(" S  M  T  W  T  F  S");

     
        for (int i = 0; i < firstDay; i++) {
            System.out.print("   ");
        }

       
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);
            
          
            if (((day + firstDay) % 7 == 0) || (day == daysInMonth)) {
                System.out.println();
            }
        }
    }
}