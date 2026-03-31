import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlightUtil util = new FlightUtil();

        try {
            System.out.println("Enter flight details");
            String input = sc.nextLine();

            String[] parts = input.split(":");

            String flightNumber = parts[0];
            String flightName = parts[1];
            int passengerCount = Integer.parseInt(parts[2]);
            double currentFuelLevel = Double.parseDouble(parts[3]);

            util.validateFlightNumber(flightNumber);
            util.validateFlightName(flightName);
            util.validatePassengerCount(passengerCount, flightName);

            double fuelRequired = util.calculateFuelToFillTank(flightName, currentFuelLevel);

            System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // Handles unexpected errors like number format
            System.out.println("Invalid input format");
        } finally {
            sc.close();
        }
    }
}
