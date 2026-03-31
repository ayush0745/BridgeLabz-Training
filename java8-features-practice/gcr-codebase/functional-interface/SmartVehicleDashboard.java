public class SmartVehicleDashboard {

    // Interface
    interface Vehicle {

        void displaySpeed();

        // New feature for electric vehicles
        default void displayBatteryPercentage() {
            // Default behavior for non-electric vehicles
            System.out.println("Battery information not available");
        }
    }

    // Car (non-electric)
    static class Car implements Vehicle {
        public void displaySpeed() {
            System.out.println("Car speed: 80 km/h");
        }
        // Uses default battery method
    }

    // Bike (non-electric)
    static class Bike implements Vehicle {
        public void displaySpeed() {
            System.out.println("Bike speed: 60 km/h");
        }
        // Uses default battery method
    }

    // Electric Car
    static class ElectricCar implements Vehicle {
        public void displaySpeed() {
            System.out.println("Electric Car speed: 90 km/h");
        }

        @Override
        public void displayBatteryPercentage() {
            System.out.println("Battery: 75%");
        }
    }

    // Main method
    public static void main(String[] args) {

        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle electricCar = new ElectricCar();

        car.displaySpeed();
        car.displayBatteryPercentage();

        bike.displaySpeed();
        bike.displayBatteryPercentage();

        electricCar.displaySpeed();
        electricCar.displayBatteryPercentage();
    }
}
