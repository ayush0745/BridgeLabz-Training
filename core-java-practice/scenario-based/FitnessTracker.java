import java.util.Scanner;

// Creating Class with name BMIFitnessTracker indicating the purpose is to 
// help a fitness coach record and categorize the BMI of different clients
public class BMIFitnessTracker {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Maya's Fitness Tracker ---");

        // Get the input values for weight in kilograms and height in meters
        System.out.print("Enter client weight (kg): ");
        double weight = scanner.nextDouble();
        
        System.out.print("Enter client height (meters): ");
        double height = scanner.nextDouble();

        // Find the BMI using the formula: weight divided by height squared
        double bmi = weight / (height * height);

        // Print the calculated BMI value formatted to two decimal places
        System.out.printf("Client's Calculated BMI: %.2f\n", bmi);

        // Check the BMI value using if-else to determine the fitness category
        if (bmi < 18.5) {
            // Category for BMI results less than 18.5
            System.out.println("Category: Underweight");
        } 
        else if (bmi >= 18.5 && bmi <= 24.9) {
            // Category for healthy BMI results between 18.5 and 24.9
            System.out.println("Category: Normal weight");
        } 
        else if (bmi >= 25.0 && bmi <= 29.9) {
            // Category for BMI results between 25.0 and 29.9
            System.out.println("Category: Overweight");
        } 
        else {
            // Category for BMI results 30.0 or higher
            System.out.println("Category: Obese");
        }

        // Closing the Scanner Stream
        scanner.close();
    }
}