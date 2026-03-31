public class TrafficManager {
    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        VehicleQueue queue = new VehicleQueue(3);

        // Vehicles arrive
        queue.enqueue("CAR-101");
        queue.enqueue("CAR-102");
        queue.enqueue("CAR-103");
        queue.enqueue("CAR-104"); // Overflow

        // Move vehicles from queue to roundabout
        String v;
        v = queue.dequeue();
        if (v != null) roundabout.addVehicle(v);

        v = queue.dequeue();
        if (v != null) roundabout.addVehicle(v);

        // Display roundabout
        roundabout.display();

        // Vehicle exits
        roundabout.removeVehicle();
        roundabout.display();

        // Another vehicle enters
        v = queue.dequeue();
        if (v != null) roundabout.addVehicle(v);

        roundabout.display();
    }
}
