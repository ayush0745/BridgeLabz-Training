public class DeluxeRoom extends Room {

    // Calls parent constructor
    public DeluxeRoom(int roomNumber) {
        super(roomNumber);
    }

    // Deluxe room price
    @Override
    public double getBasePrice() {
        return 2500;
    }
}
