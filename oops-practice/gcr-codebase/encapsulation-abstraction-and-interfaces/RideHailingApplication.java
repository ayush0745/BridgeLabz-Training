abstract class Vehicle {

    // Encapsulated fields
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
    }

    // Getters (Encapsulation)
    protected double getRatePerKm() {
        return ratePerKm;
    }

    public String getDriverName() {
        return driverName;
    }
}
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}
class Car extends Vehicle implements GPS {

    private String location;

    public Car(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}
class Bike extends Vehicle implements GPS {

    private String location;

    public Bike(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // cheapest
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}
class Auto extends Vehicle implements GPS {

    private String location;

    public Auto(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // moderate charge
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}

public class RideHailingApplication {
	 public static void main(String[] args) {

	        Vehicle v1 = new Car(201, "Amit", 15);
	        Vehicle v2 = new Bike(202, "Ravi", 8);
	        Vehicle v3 = new Auto(203, "Suresh", 12);

	        calculateRideFare(v1, 10);
	        calculateRideFare(v2, 10);
	        calculateRideFare(v3, 10);
	    }

	    public static void calculateRideFare(Vehicle vehicle, double distance) {
	        vehicle.getVehicleDetails();
	        System.out.println("Distance: " + distance + " km");
	        System.out.println("Total Fare: ₹" + vehicle.calculateFare(distance));
	        System.out.println("--------------------------");
	    }
}
