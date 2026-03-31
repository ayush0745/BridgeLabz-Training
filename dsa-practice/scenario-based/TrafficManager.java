import java.util.*;

// Vehicle node for Circular Linked List
class Vehicle {
    String number;
    Vehicle next;

    Vehicle(String number) {
        this.number = number;
        this.next = null;
    }
}

// Circular Linked List for Roundabout
class Roundabout {
    private Vehicle tail = null;

    // Add vehicle to roundabout
    public void addVehicle(String number) {
        Vehicle newVehicle = new Vehicle(number);

        if (tail == null) {
            tail = newVehicle;
            tail.next = tail;
        } else {
            newVehicle.next = tail.next;
            tail.next = newVehicle;
            tail = newVehicle;
        }
        System.out.println("Vehicle entered roundabout: " + number);
    }

    // Remove vehicle from roundabout
    public void removeVehicle() {
        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Vehicle head = tail.next;

        if (head == tail) {
            System.out.println("Vehicle exited roundabout: " + head.number);
            tail = null;
        } else {
            System.out.println("Vehicle exited roundabout: " + head.number);
            tail.next = head.next;
        }
    }

    // Display roundabout
    public void display() {
        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        System.out.print("Roundabout vehicles: ");
        Vehicle temp = tail.next;
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println("(back to start)");
    }
}

// Queue for waiting vehicles
class VehicleQueue {
    private Queue<String> queue;
    private int capacity;

    VehicleQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public void enqueue(String vehicle) {
        if (queue.size() == capacity) {
            System.out.println("Queue Overflow! Vehicle waiting denied: " + vehicle);
            return;
        }
        queue.add(vehicle);
        System.out.println("Vehicle added to waiting queue: " + vehicle);
    }

    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return null;
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void display() {
        System.out.println("Waiting Queue: " + queue);
    }
}

// Main class
public class TrafficManager {
    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        VehicleQueue waitingQueue = new VehicleQueue(3);

        // Vehicles arrive
        waitingQueue.enqueue("CAR-101");
        waitingQueue.enqueue("CAR-102");
        waitingQueue.enqueue("CAR-103");
        waitingQueue.enqueue("CAR-104"); // overflow

        waitingQueue.display();

        // Move vehicles into roundabout
        while (!waitingQueue.isEmpty()) {
            String car = waitingQueue.dequeue();
            if (car != null) {
                roundabout.addVehicle(car);
            }
        }

        roundabout.display();

        // Vehicles exit
        roundabout.removeVehicle();
        roundabout.display();

        roundabout.removeVehicle();
        roundabout.display();

        roundabout.removeVehicle();
        roundabout.removeVehicle(); // empty case
    }
}
