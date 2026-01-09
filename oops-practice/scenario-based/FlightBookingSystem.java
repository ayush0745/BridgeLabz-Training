import java.util.*;

// User class
class User {
    int userId;
    String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

// Flight class
class Flight {
    int flightId;
    String source;
    String destination;
    int seats;

    public Flight(int flightId, String source, String destination, int seats) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }

    public void displayFlight() {
        System.out.println("Flight ID: " + flightId +
                ", Source: " + source +
                ", Destination: " + destination +
                ", Seats: " + seats);
    }
}

// Booking class
class Booking {
    User user;
    Flight flight;

    public Booking(User user, Flight flight) {
        this.user = user;
        this.flight = flight;
    }

    public void displayBooking() {
        System.out.println("User: " + user.name +
                ", Flight ID: " + flight.flightId +
                ", " + flight.source + " to " + flight.destination);
    }
}

// Main application
public class FlightBookingSystem {

    // Array to store flights
    static Flight[] flights = new Flight[3];

    // List to store bookings
    static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {

        // Initialize flights
        flights[0] = new Flight(101, "Delhi", "Mumbai", 5);
        flights[1] = new Flight(102, "Pune", "Bangalore", 3);
        flights[2] = new Flight(103, "Delhi", "Chennai", 2);

        // Create user
        User user1 = new User(1, "Ayush");

        // Search flight
        searchFlight("delhi", "mumbai");

        // Book flight
        bookFlight(user1, 101);

        // Display bookings
        displayBookings();
    }

    // Search flight using case-insensitive comparison
    public static void searchFlight(String source, String destination) {
        System.out.println("Available Flights:");
        for (Flight f : flights) {
            if (f.source.equalsIgnoreCase(source) &&
                f.destination.equalsIgnoreCase(destination)) {
                f.displayFlight();
            }
        }
    }

    // Book flight by flight ID
    public static void bookFlight(User user, int flightId) {
        for (Flight f : flights) {
            if (f.flightId == flightId && f.seats > 0) {
                bookings.add(new Booking(user, f));
                f.seats--;
                System.out.println("Flight booked successfully");
                return;
            }
        }
        System.out.println("Flight not available");
    }

    // Display all bookings
    public static void displayBookings() {
        System.out.println("Booking Details:");
        for (Booking b : bookings) {
            b.displayBooking();
        }
    }
}
