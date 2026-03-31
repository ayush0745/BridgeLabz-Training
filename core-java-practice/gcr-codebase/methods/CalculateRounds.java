import java.util.Scanner;

public class CalculateRounds {

    // Method to calculate the number of rounds 
    public static double calculateRounds(double s1, double s2, double s3) {
        double totalDistanceMeters = 5000;
        double perimeter = s1 + s2 + s3;
        
        // Rounds = Total Distance / Perimeter
        return totalDistanceMeters / perimeter;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        // Taking input for the three sides
        System.out.print("Enter side 1 : ");
        double side1 = input.nextDouble();
        
        System.out.print("Enter side 2 : ");
        double side2 = input.nextDouble();
        
        System.out.print("Enter side 3: ");
        double side3 = input.nextDouble();

        // Calculate rounds
        double roundsNeeded = calculateRounds(side1, side2, side3);

        // Output the result
       
        System.out.printf("\nTo complete a 5km run, the athlete must complete %.2f rounds.\n", roundsNeeded);

        input.close();
    }
}