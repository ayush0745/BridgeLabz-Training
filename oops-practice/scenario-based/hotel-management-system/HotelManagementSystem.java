public class HotelManagementSystem {
    public static void main(String[] args) {

        Guest g1 = new Guest(1, "Ayush");
        Room r1 = new DeluxeRoom(101);

        PricingStrategy pricing = new SeasonalPricing();
        HotelService service = new HotelService();

        try {
            Reservation res = service.bookRoom(g1, r1);

            double bill = pricing.calculatePrice(r1.getBasePrice());
            System.out.println("Room booked successfully");
            System.out.println("Total Bill: ₹" + bill);

            service.checkout(r1);
            System.out.println("Checked out successfully");

        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
