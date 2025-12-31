class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    public static void main(String[] args) {
        HotelBooking b1 = new HotelBooking(); // default
        HotelBooking b2 = new HotelBooking("Ayush", "Deluxe", 3); // parameterized
        HotelBooking b3 = new HotelBooking(b2); // copy

        System.out.println(b1.guestName + ", " + b1.roomType + ", " + b1.nights);
        System.out.println(b2.guestName + ", " + b2.roomType + ", " + b2.nights);
        System.out.println(b3.guestName + ", " + b3.roomType + ", " + b3.nights);
    }
}
