class Vehicle {

    // Static variable common for all vehicles
    private static double registrationFee = 150.0;

    // Final variable for unique registration number
    private final String registrationNumber;

    private String ownerName;
    private String vehicleType;

    // Constructor using 'this'
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    // Method to display vehicle details
    public void displayVehicleDetails() {
        // Using instanceof
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Invalid vehicle object");
        }
    }

    // Main method
    public static void main(String[] args) {

        Vehicle vehicle1 = new Vehicle("Honest raj", "Sedan", "ABC123");
        Vehicle vehicle2 = new Vehicle("Price danish", "SUV", "XYZ789");

        vehicle1.displayVehicleDetails();
        System.out.println();
        vehicle2.displayVehicleDetails();
    }
}
