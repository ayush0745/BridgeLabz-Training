
import java.util.Scanner;
public class UnitConverter2 {

    //converts yard to feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    // Converts feet to yards
    
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    // Converts meters to inches
     
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

   
    // Converts inches to meters
    
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

     // Converts inches to centimeters
     
    public static double convertInchesToCm(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

   
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	double yard = scanner.nextDouble();
        System.out.println("Yards to Feet: " + convertYardsToFeet(yard));
        double feet = scanner.nextDouble();
        System.out.println("Feet to Yards: " + convertFeetToYards(feet));
        double meter = scanner.nextDouble();
        System.out.println("Meters to Inches: " + convertMetersToInches(meter));
        double inches = scanner.nextDouble();
        System.out.println("Inches to Meters: " + convertInchesToMeters(inches));
        
        System.out.println("Inches to Centimeters: " + convertInchesToCm(inches));
    }
}