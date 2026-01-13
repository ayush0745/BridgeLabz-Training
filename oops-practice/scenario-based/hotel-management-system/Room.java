public class Room {
    int roomNumber;
    boolean available = true;

    // Constructor to initialize room number
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    // Base price of room
    public double getBasePrice() {
        return 1000;
    }
}
