import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter details");
		String s = scanner.next();
		
		scanner.close();
		String [] str = s.split(":");
		
		String flightNumber = str[0];
		String flightName = str[1];
		int passengerCount = Integer.parseInt(str[2]);
		double currentFuelLevel = Double.parseDouble(str[3]);
		
		FlightUtil flight = new FlightUtil();
		
		try {
			flight.validateFlightNumber(flightNumber);
			flight.validateFlightName(flightName);
			flight.validatePassengerCount(passengerCount, flightName);
			double fuelRequired = flight.calculateFuelToFillTank( flightName, currentFuelLevel);
			System.out.println( "Fuel required to fill the tank: " + fuelRequired + " liters" );
				           
				    
				
		}
		catch (InvalidFlightException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
