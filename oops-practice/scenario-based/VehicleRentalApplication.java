import java.util.*;

// Interface for rent calculation
interface IRentable {
    int calculateRent(int days);
}

// Abstract class Vehicle
abstract class Vehicle implements IRentable {
    protected int vehicleId;
    protected String brand;
    protected double ratePerDay;

    public Vehicle(int vehicleId, String brand, double ratePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.ratePerDay = ratePerDay;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    // Polymorphic method
    public abstract void displayInfo();
}

// Bike class
class Bike extends Vehicle {

    public Bike(int vehicleId, String brand, double ratePerDay) {
        super(vehicleId, brand, ratePerDay);
    }

    @Override
    public int calculateRent(int days) {
        return (int) (days * ratePerDay);
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike ID: " + vehicleId +
                ", Brand: " + brand +
                ", Rent/Day: Rs " + ratePerDay);
    }
}

// Car class
class Car extends Vehicle {

    public Car(int vehicleId, String brand, double ratePerDay) {
        super(vehicleId, brand, ratePerDay);
    }

    @Override
    public int calculateRent(int days) {
        return (int) (days * ratePerDay + 500);
    }

    @Override
    public void displayInfo() {
        System.out.println("Car ID: " + vehicleId +
                ", Brand: " + brand +
                ", Rent/Day: Rs " + ratePerDay);
    }
}

// Truck class
class Truck extends Vehicle {

    public Truck(int vehicleId, String brand, double ratePerDay) {
        super(vehicleId, brand, ratePerDay);
    }

    @Override
    public int calculateRent(int days) {
        return (int) (days * ratePerDay + 1000);
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck ID: " + vehicleId +
                ", Brand: " + brand +
                ", Rent/Day: Rs " + ratePerDay);
    }
}

// Customer class
class Customer {
    private int customerId;
    private String name;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Main application class
public class VehicleRentalApplication {

    static List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create vehicles
        vehicles.add(new Bike(1, "Yamaha", 500));
        vehicles.add(new Car(2, "Honda", 1500));
        vehicles.add(new Truck(3, "Tata", 3000));

        // Display vehicles
        displayVehicles();

        // Calculate rent using polymorphism
        int days = 3;
        for (Vehicle v : vehicles) {
            System.out.println("Vehicle ID " + v.getVehicleId() +
                    " Rent for " + days + " days: Rs " + v.calculateRent(days));
        }

        // Update vehicle
        vehicles.set(1, new Car(2, "Hyundai", 1800));

        // Delete vehicle
        vehicles.removeIf(v -> v.getVehicleId() == 1);

        // Display after update and delete
        displayVehicles();

        scanner.close();
    }

    public static void displayVehicles() {
        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
    }
}
