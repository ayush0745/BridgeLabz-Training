public class ZaraBonusCalculator {

    public static void main(String[] args) {
        //Initialize 10 employees with 2 columns
        double[][] employeeData = initializeEmployeeData(10);

        //Calculate Bonus and New Salary
        double[][] results = calculateBonusAndNewSalary(employeeData);

        //Calculate totals and display the report
        displayPayrollReport(employeeData, results);
    }

  
    public static double[][] initializeEmployeeData(int count) {
        double[][] data = new double[count][2];
        for (int i = 0; i < count; i++) {
            
            data[i][0] = (Math.random() * 90000) + 10000;
            // Random years of service between 0 and 10
            data[i][1] = (int) (Math.random() * 11);
        }
        return data;
    }

 
    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        int count = employeeData.length;
        double[][] results = new double[count][2];

        for (int i = 0; i < count; i++) {
            double oldSalary = employeeData[i][0];
            double serviceYears = employeeData[i][1];
            double bonusPercent = (serviceYears > 5) ? 0.05 : 0.02;

            double bonusAmount = oldSalary * bonusPercent;
            results[i][0] = oldSalary + bonusAmount;
            results[i][1] = bonusAmount;            
        }
        return results;
    }

    // Calculates totals and displays everything in a formatted table.
     
    public static void displayPayrollReport(double[][] oldData, double[][] newData) {
        double sumOldSalary = 0, sumNewSalary = 0, totalBonus = 0;

        System.out.printf("%-10s %-12s %-10s %-12s %-12s%n", 
                          "Employee", "Old Salary", "Service", "Bonus", "New Salary");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < oldData.length; i++) {
            double oldSal = oldData[i][0];
            double service = oldData[i][1];
            double bonus = newData[i][1];
            double newSal = newData[i][0];

            sumOldSalary += oldSal;
            sumNewSalary += newSal;
            totalBonus += bonus;

            System.out.printf("%-10d %-12.2f %-10.0f %-12.2f %-12.2f%n", 
                              (i + 1), oldSal, service, bonus, newSal);
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s %-12.2f %-10s %-12.2f %-12.2f%n", 
                          "TOTALS", sumOldSalary, "", totalBonus, sumNewSalary);
    }
}