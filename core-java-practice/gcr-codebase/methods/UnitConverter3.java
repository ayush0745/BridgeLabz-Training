import java.util.Scanner;

public class UnitConverter {

     // Converts Fahrenheit to Celsius
     
    public static double convertFahrenheitToCelsius(double fahrenheit) {
       
        double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit2celsius;
    }

 
     //Converts Celsius to Fahrenheit
   
    public static double convertCelsiusToFahrenheit(double celsius) {
        // formula: (C * 9/5) + 32
        double celsius2fahrenheit = (celsius * 9 / 5) + 32;
        return celsius2fahrenheit;
    }

     // Converts Pounds to Kilograms
     
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

   //Converts Kilograms to Pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    // Converts Gallons to Liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    // Converts Liters to Gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Extended Unit Converter (Temp, Weight, Volume) ---");

        // Temperature Input
        System.out.print("Enter temperature in Fahrenheit: ");
        double f = scanner.nextDouble();
        System.out.printf("%.2fF is %.2fC%n", f, convertFahrenheitToCelsius(f));

        // Weight Input
        System.out.print("\nEnter weight in Pounds: ");
        double lbs = scanner.nextDouble();
        System.out.printf("%.2f lbs is %.4f kg%n", lbs, convertPoundsToKilograms(lbs));

        // Volume Input
        System.out.print("\nEnter volume in Gallons: ");
        double gal = scanner.nextDouble();
        System.out.printf("%.2f Gallons is %.4f Liters%n", gal, convertGallonsToLiters(gal));

        scanner.close();
    }
}