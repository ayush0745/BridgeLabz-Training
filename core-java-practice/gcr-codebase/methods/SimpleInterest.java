import java.util.Scanner;
//program to calculate simple interest
public class SimpleInterest {

    // Method to calculate simple interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        // Create a Scanner object t
        Scanner input = new Scanner(System.in);

        // Input Principal
        System.out.print("Enter the Principal: ");
        double p = input.nextDouble();

        // Rate
        System.out.print("Enter the Rate of Interest: ");
        double r = input.nextDouble();

        // Time
        System.out.print("Enter the Time (in years): ");
        double t = input.nextDouble();

        // Calculate using the method
        double si = calculateSimpleInterest(p, r, t);

        // Output the result
        System.out.println("\nThe Simple Interest is " + si + " for Principal " + p + 
                           ", Rate of Interest " + r + " and Time " + t);
        
        input.close();
    }
}