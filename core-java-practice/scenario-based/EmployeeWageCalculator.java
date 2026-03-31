import java.util.Random;

public class EmployeeWageCalculator {
    // Constants for the class
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public static final int WAGE_PER_HOUR = 20;
    public static final int NUM_OF_WORKING_DAYS = 20;
    public static final int MAX_HRS_IN_MONTH = 100;

    public static void main(String[] args) {
        // UC 1: Display Welcome Message
        System.out.println("Welcome to Employee Wage Computation Program");

        // Variables for computation
     // UC 6: Calculate Wages till a condition of total working hours or days is reached 
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

      
        while (totalEmpHrs < 100 && totalWorkingDays < 20) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3; // UC 1: Random Attendance 
            int empHrs = 0;

            switch (empCheck) { // UC 4: Switch Case
                case 1: // Part-time 
                    empHrs = 8; // Assume Part-time Hour is 8 
                    break;
                case 2: // Full-time
                    empHrs = 8; // Assume Full Day Hour is 8 
                    break;
                default:
                    empHrs = 0;
            }

            // Check to ensure adding hours doesn't exceed the 100-hour hard limit
            if (totalEmpHrs + empHrs > 100) {
                empHrs = 100 - totalEmpHrs;
            }

            totalEmpHrs += empHrs;
            System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " + empHrs);
        }
        System.out.println("Total working days :" + totalWorkingDays);
        System.out.println("TotalWorking hours : " + totalEmpHrs);
        int totalEmpWage = totalEmpHrs * 20; // Wage per hour is 20 
        System.out.println("Total Emp Wage: " + totalEmpWage);
    }
}