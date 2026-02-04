public class VehicleRentalSystem {

    // Interface
    interface Vehicle {
        void rent();
        void returnVehicle();
    }

    // Car class
    static class Car implements Vehicle {
        public void rent() {
            System.out.println("Car rented successfully");
        }

        public void returnVehicle() {
            System.out.println("Car returned successfully");
        }
    }

    // Bike class
    static class Bike implements Vehicle {
        public void rent() {
            System.out.println("Bike rented successfully");
        }

        public void returnVehicle() {
            System.out.println("Bike returned successfully");
        }
    }

    // Bus class
    static class Bus implements Vehicle {
        public void rent() {
            System.out.println("Bus rented successfully");
        }

        public void returnVehicle() {
            System.out.println("Bus returned successfully");
        }
    }

    // Main method
    public static void main(String[] args) {

        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle bus = new Bus();

        car.rent();
        bike.rent();
        bus.rent();

        car.returnVehicle();
        bike.returnVehicle();
        bus.returnVehicle();
    }
}
