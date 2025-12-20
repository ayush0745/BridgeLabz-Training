import java.util.Scanner;

// calculate bonuses and total salary costs for Zara company
public class ZaraBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // arrays for 10 employees
        double[] oldSalaries = new double[10];
        double[] serviceYears = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        
        double totalOldSalary = 0, totalNewSalary = 0, totalBonusPayout = 0;

        // input loop with validation
        System.out.println("Enter Employee Data");
        for (int i = 0; i < 10; i++) {
            System.out.print("Employee " + (i + 1) + " Salary: ");
            double s = scanner.nextDouble();
            System.out.print("Employee " + (i + 1) + " Years of Service: ");
            double y = scanner.nextDouble();

            // check if inputs are valid numbers
            if (s <= 0 || y < 0) {
                System.out.println("Invalid data. Please re-enter for this employee.");
                i--; // decrement index to repeat this employee
                continue;
            }

            oldSalaries[i] = s;
            serviceYears[i] = y;
        }

        // calculation loop
        for (int i = 0; i < 10; i++) {
            
            double bonusRate = (serviceYears[i] > 5) ? 0.05 : 0.02;
            
            bonuses[i] = oldSalaries[i] * bonusRate;
            newSalaries[i] = oldSalaries[i] + bonuses[i];
            totalOldSalary += oldSalaries[i];
            totalBonusPayout += bonuses[i];
            totalNewSalary += newSalaries[i];
        }

        // display total financial results
        System.out.println("Company Totals");
        System.out.printf("Total Old Salary  : %.2f\n", totalOldSalary);
        System.out.printf("Total Bonus Paid  : %.2f\n", totalBonusPayout);
        System.out.printf("Total New Salary  : %.2f\n", totalNewSalary);

        scanner.close();
    }
}