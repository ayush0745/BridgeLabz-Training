public class EventManagerApp {
    public static void main(String[] args) {

        Ticket[] tickets = {
            new Ticket(500),
            new Ticket(1200),
            new Ticket(300),
            new Ticket(800),
            new Ticket(150)
        };

        // Sort tickets by price
        TicketSorter.quickSort(tickets, 0, tickets.length - 1);

        System.out.println("Sorted Ticket Prices:");
        for (Ticket t : tickets) {
            System.out.print(t.price + " ");
        }
    }
}
