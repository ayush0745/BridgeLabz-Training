import java.util.Scanner;

// program to track BMI data for a whole team
public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of persons: ");
        int n = scanner.nextInt();

        // arrays to store 
        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] bmis = new double[n];
        String[] statuses = new String[n];

        // loop to collect height and weight for everyone
        for (int i = 0; i < n; i++) {
            System.out.println("\nData for person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            weights[i] = scanner.nextDouble();
            System.out.print("Height (cm): ");
            heights[i] = scanner.nextDouble();

            // convert cm to meters for the formula
            double heightInMeters = heights[i] / 100.0;
            
            // calculate BMI and save to array
            bmis[i] = weights[i] / (heightInMeters * heightInMeters);

            // determine status based on BMI table
            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] <= 24.9) {
                statuses[i] = "Normal weight";
            } else if (bmis[i] <= 29.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }

        // display the final result
       
        System.out.printf("%-10s %-12s %-12s %-8s %-15s\n", "Person", "Weight(kg)", "Height(cm)", "BMI", "Status");
        
        for (int i = 0; i < n; i++) {
            // using printf to keep the table rows aligned and decimals clean
            System.out.printf("%-10d %-12.2f %-12.2f %-8.2f %-15s\n", 
                (i + 1), weights[i], heights[i], bmis[i], statuses[i]);
        }

        scanner.close();
    }
}