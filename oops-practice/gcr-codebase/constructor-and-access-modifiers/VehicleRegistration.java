class Vehicle {
    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable 
    static double registrationFee = 1500.0;

    // Parameterized constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
        System.out.println("-------------------------");
    }

    //method to update registration fee
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Ayush", "Car");
        Vehicle v2 = new Vehicle("Riya", "Bike");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        // Update fee for all vehicles
        Vehicle.updateRegistrationFee(2000.0);

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
