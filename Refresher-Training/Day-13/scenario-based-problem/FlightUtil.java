import java.util.Currency;

public class FlightUtil{
	
	public boolean validateFlightNumber (String flightNumber) {
		if(flightNumber.matches("FL-[1-9][0-9]{3}")) {
			return true;
		}
		throw new InvalidFlightException("The flight number " + flightNumber +
				"invalid.");
	}
	
	public boolean validateFlightName(String flightName) {
		if(flightName.equalsIgnoreCase("SpiceJet") || flightName.equalsIgnoreCase("Vistara") ||
		   flightName.equalsIgnoreCase("IndiGo") || flightName.equalsIgnoreCase("Air Arabia") ) {
			
			return true; 
		}
		
		throw new InvalidFlightException( "the flight name " + flightName + " is inavalid.");
	}
	
	public boolean validatePassengerCount(int passengerCount, String flightName) {
		int maxCapacity = 0;
		
		if(flightName.equalsIgnoreCase("SpiceJet")) {
			maxCapacity = 396;
		}
		else if(flightName.equalsIgnoreCase("Vistara")) {
			maxCapacity = 615;
		}
		else if(flightName.equalsIgnoreCase("IndiGo")) {
			maxCapacity = 230;
		}
		else if(flightName.equalsIgnoreCase("Air Arabia")) {
			maxCapacity = 130;
		}
		if(passengerCount <=0 || passengerCount > maxCapacity) {
			throw new InvalidFlightException(
					"The passenger count " + passengerCount + " is invalid for "+ flightName
					);
				
		}
		return true;
		
	}
	
	public double calculateFuelToFillTank(String flightName, double currentFuelLevel) {
		int maxCapacity = 0;
		
		if(flightName.equalsIgnoreCase("SpiceJet")) {
			maxCapacity = 200000;
		}
		else if(flightName.equalsIgnoreCase("Vistara")) {
			maxCapacity = 300000;
		}
		else if(flightName.equalsIgnoreCase("IndiGo")) {
			maxCapacity = 250000;
		}
		else if(flightName.equalsIgnoreCase("Air Arabia")) {
			maxCapacity = 150000;
		}
		if(currentFuelLevel < 0 || currentFuelLevel > maxCapacity) {
			throw new InvalidFlightException(
					"Invalid fuel level for "+ flightName
					);
				
		}
		return maxCapacity - currentFuelLevel;
	}
	
}
