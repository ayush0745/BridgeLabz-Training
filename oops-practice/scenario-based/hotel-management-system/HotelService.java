public class HotelService {

    // Books room if available
    public Reservation bookRoom(Guest guest, Room room)
            throws RoomNotAvailableException {

        if (!room.available) {
            throw new RoomNotAvailableException("Room not available!");
        }

        room.available = false; // Mark room as booked
        return new Reservation(guest, room);
    }

    // Checkout process
    public void checkout(Room room) {
        room.available = true; // Make room available again
    }
}
