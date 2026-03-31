//The Superclass
class Vehicle {
    String model;
    int maxSpeed;

    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void displayDetails() {
        System.out.println("Model: " + model + " | Max Speed: " + maxSpeed + " km/h");
    }
}

//The Interface
interface Refuelable {
    void refuel();
}

//Subclass ElectricVehicle 
class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println(model + " is charging its " + batteryCapacity + " kWh battery.");
    }
}

//Subclass PetrolVehicle (Hybrid Inheritance: Extends + Implements)
class PetrolVehicle extends Vehicle implements Refuelable {
    double fuelTankCapacity;

    PetrolVehicle(String model, int maxSpeed, double fuelTankCapacity) {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling at the gas station. Tank capacity: " + fuelTankCapacity + "L");
    }
}

public class VehicleManagementSystem{
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle mustang = new PetrolVehicle("Ford Mustang", 260, 60.5);

        System.out.println("--- Electric Vehicle ---");
        tesla.displayDetails();
        tesla.charge();

        System.out.println("\n--- Petrol Vehicle ---");
        mustang.displayDetails();
        mustang.refuel();
    }
}