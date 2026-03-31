import java.util.Scanner;

class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked; 

    // Constructor
    public MovieTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = false;
    }

    // Method to book a ticket
    public void bookTicket() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    // Method to display ticket details
    public void displayDetails() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("Price: $" + price);
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }

    public static void main(String[] args) {
      
        MovieTicket ticket = new MovieTicket("Dragon", "A10", 120.0);

        //  status before booking
        ticket.displayDetails();

        //First booking attempt
        ticket.bookTicket();

        // Duplicate booking attempts
        ticket.bookTicket();
        ticket.bookTicket();

        //Display final details
        ticket.displayDetails();
    }
}