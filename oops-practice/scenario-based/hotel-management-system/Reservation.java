public class Reservation {
    Guest guest;
    Room room;

    // Links guest with room
    public Reservation(Guest guest, Room room) {
        this.guest = guest;
        this.room = room;
    }
}
