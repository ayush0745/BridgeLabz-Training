// Circular Linked List for roundabout
class Roundabout {
    private Vehicle head = null;

    // Add vehicle to roundabout
    public void addVehicle(String vehicleNo) {
        Vehicle newNode = new Vehicle(vehicleNo);

        // If roundabout is empty
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Vehicle temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println(vehicleNo + " entered roundabout");
    }

    // Remove vehicle from roundabout
    public void removeVehicle() {
        if (head == null) {
            System.out.println("Roundabout is empty!");
            return;
        }

        // Only one vehicle
        if (head.next == head) {
            System.out.println(head.vehicleNo + " exited roundabout");
            head = null;
            return;
        }

        // Remove head vehicle
        Vehicle temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        System.out.println(head.vehicleNo + " exited roundabout");
        temp.next = head.next;
        head = head.next;
    }

    // Print current state of roundabout
    public void display() {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        System.out.print("Roundabout: ");
        Vehicle temp = head;
        do {
            System.out.print(temp.vehicleNo + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }
}
