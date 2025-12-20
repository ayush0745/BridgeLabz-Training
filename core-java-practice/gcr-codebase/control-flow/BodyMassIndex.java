import java.util.Scanner;

// Creating Class with name BMICalculator indicating the purpose is to 
// calculate Body Mass Index and determine weight status based on height and weight
public class BodyMassIndex {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner scanner = new Scanner(System.in);

        // Get the input values for weight in kg and height in cm
        System.out.print("Enter weight in kg: ");
        double weight = scanner.nextDouble();
        
        System.out.print("Enter height in cm: ");
        double heightCm = scanner.nextDouble();

        // Convert the height from centimeters to meters for the calculation
        double heightInMeters = heightCm / 100.0;

        // Find the BMI using the formula: weight / (height * height)
        double bmi = weight / (heightInMeters * heightInMeters);

        // Initialize a string to hold the weight status
        String status = "";

        // Check the calculated BMI against the standard table to determine status
        if (bmi < 18.5) {
            status = "Underweight";
        } 
        else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "Normal weight";
        } 
        else if (bmi >= 25.0 && bmi <= 39.9) {
            status = "Overweight";
        } 
        else {
            status = "Obese";
        }

        // Display the final BMI value and the corresponding weight category
        System.out.printf("Your BMI is: %.2f\n", bmi);
        System.out.println("Weight Status: " + status);

        // Closing the Scanner Stream
        scanner.close();
    }
}