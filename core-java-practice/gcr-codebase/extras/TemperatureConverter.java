import java.util.Scanner;

public class TemperatureConverter {

    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

  
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double f = scanner.nextDouble();
            System.out.printf("%.2f is equal to %.2f\n", f, fahrenheitToCelsius(f));
        } else if (choice == 2) {
            System.out.print("Enter temperature in Celsius: ");
            double c = scanner.nextDouble();
            System.out.printf("%.2f is equal to %.2f\n", c, celsiusToFahrenheit(c));
        } else {
            System.out.println("Invalid choice. Please restart the program.");
        }

        scanner.close();
    }
}