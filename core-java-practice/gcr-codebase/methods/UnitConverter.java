import java.util.Scanner;

public class UnitConverter {

    //  Kilometers to Miles
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    // Miles to Kilometers
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    // Meters to Feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    // Feet to Meters
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Unit Conversion Utility ---");
       
        System.out.print("Enter distance in Kilometers: ");
        double km = scanner.nextDouble();
        System.out.printf("%.2f Km to Miles: %.4f%n", km, convertKmToMiles(km));
        
        System.out.print("\nEnter distance in Miles: ");
        double miles = scanner.nextDouble();
        System.out.printf("%.2f Miles to Km: %.4f%n", miles, convertMilesToKm(miles));
        
        System.out.print("\nEnter length in Meters: ");
        double meters = scanner.nextDouble();
        System.out.printf("%.2f Meters to Feet: %.4f%n", meters, convertMetersToFeet(meters));
        
        System.out.print("\nEnter length in Feet: ");
        double feet = scanner.nextDouble();
        System.out.printf("%.2f Feet to Meters: %.4f%n", feet, convertFeetToMeters(feet));

        scanner.close(); // Best practice to close the scanner
    }
}