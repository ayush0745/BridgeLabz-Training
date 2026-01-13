// Queue implementation using array
class VehicleQueue {
    private String[] queue;
    private int front = -1, rear = -1;
    private int size;

    VehicleQueue(int size) {
        this.size = size;
        queue = new String[size];
    }

    // Add vehicle to queue
    public void enqueue(String vehicleNo) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow! Vehicle waiting area full");
            return;
        }
        if (front == -1) front = 0;
        queue[++rear] = vehicleNo;
        System.out.println(vehicleNo + " added to waiting queue");
    }

    // Remove vehicle from queue
    public String dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow! No vehicles waiting");
            return null;
        }
        return queue[front++];
    }
}
