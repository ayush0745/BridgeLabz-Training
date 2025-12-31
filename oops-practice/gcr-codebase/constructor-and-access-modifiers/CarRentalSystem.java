class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay;

    // Default constructor
    CarRental() {
        customerName = "Customer";
        carModel = "Standard";
        rentalDays = 1;
        costPerDay = 1000.0;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.costPerDay = 1000.0;
    }

    // Method to calculate total cost
    double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    public static void main(String[] args) {
        CarRental r1 = new CarRental();
        CarRental r2 = new CarRental("Ayush", "Sedan", 5);

        System.out.println("Total cost : " + r1.calculateTotalCost());
        System.out.println("Total cost : " + r2.calculateTotalCost());
    }
}
