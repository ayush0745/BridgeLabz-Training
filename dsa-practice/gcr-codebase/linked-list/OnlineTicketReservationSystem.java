import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName,
                  String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservation {
    private Ticket head;
    private int count;

    // Add ticket at end
    public void addTicket(int id, String customer, String movie,
                          String seat, String time) {
        Ticket newTicket = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = newTicket;
            newTicket.next = head;
        }
        count++;
    }

    // Remove ticket by ID
    public void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket curr = head, prev = null;

        do {
            if (curr.ticketId == id) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else if (curr == head) {
                    Ticket temp = head;
                    while (temp.next != head)
                        temp = temp.next;
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                count--;
                System.out.println("Ticket removed successfully");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Ticket not found");
    }

    // Display tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by customer
    public void searchByCustomer(String name) {
        if (head == null) return;

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found for this customer");
    }

    // Search by movie
    public void searchByMovie(String movie) {
        if (head == null) return;

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found for this movie");
    }

    public int totalTickets() {
        return count;
    }

    private void displayTicket(Ticket t) {
        System.out.println(
            "Ticket ID: " + t.ticketId +
            ", Customer: " + t.customerName +
            ", Movie: " + t.movieName +
            ", Seat: " + t.seatNumber +
            ", Time: " + t.bookingTime
        );
    }
}

public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservation system = new TicketReservation();

        // 🔹 PRE-ADDED TICKETS
        system.addTicket(101, "Ayush", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Ravi", "Interstellar", "B3", "1:30 PM");
        system.addTicket(103, "Neha", "Inception", "C5", "4:00 PM");

        int choice;

        do {
            System.out.println("\n=== ONLINE TICKET RESERVATION ===");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search by Customer Name");
            System.out.println("5. Search by Movie Name");
            System.out.println("6. Total Booked Tickets");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String customer = sc.nextLine();

                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();

                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();

                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();

                    system.addTicket(id, customer, movie, seat, time);
                    System.out.println("Ticket booked successfully");
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    system.removeTicket(sc.nextInt());
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer Name: ");
                    system.searchByCustomer(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Movie Name: ");
                    system.searchByMovie(sc.nextLine());
                    break;

                case 6:
                    System.out.println("Total Tickets Booked: " + system.totalTickets());
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

        sc.close();
    }
}
