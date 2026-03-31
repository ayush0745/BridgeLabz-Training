public class StandardRoom extends Room {

    // Calls parent constructor
    public StandardRoom(int roomNumber) {
        super(roomNumber);
    }

    // Standard room price
    @Override
    public double getBasePrice() {
        return 1500;
    }
}
