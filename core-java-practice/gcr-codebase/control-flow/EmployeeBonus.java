import java.util.Scanner;
// level 1
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking inputs
        System.out.print("Enter employee salary: ");
        double salary = sc.nextDouble();
        
        System.out.print("Enter years of service: ");
        int years = sc.nextInt();

        // Checking eligibility
        if (years > 5) {
            double bonus = salary * 0.05;
            System.out.println("Congratulations! You are eligible for a bonus.");
            System.out.println("Your bonus amount is: " + bonus);
        } else {
            System.out.println("No bonus assigned. Required service is more than 5 years.");
        }
    }
}