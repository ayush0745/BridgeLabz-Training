import java.util.Scanner;

public class TicketBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepBooking = true;

    

        // Loop through multiple customers
        while (keepBooking) {
            double totalBill = 0.0;

            System.out.print("\nEnter Movie Type: ");
            String movieType = scanner.next().toLowerCase();

            // Use switch for Movie Type pricing
            switch (movieType) {
                case "action":
                case "sci-fi":
                    totalBill += 15.0; // Premium movies
                    break;
                case "comedy":
                case "horror":
                    totalBill += 12.0; // Standard movies
                    break;
                default:
                    System.out.println("Unknown genre. Applying standard rate of 10.");
                    totalBill += 10.0;
            }

            System.out.print("Enter Seat Type (Gold/Silver): ");
            String seatType = scanner.next().toLowerCase();

            // Use if for Seat Type upgrades
            if (seatType.equals("gold")) {
                totalBill += 5.0; // Gold upgrade fee
                System.out.println("Gold seat selected ");
            } else {
                System.out.println("Silver seat selected");
            }

            System.out.print("Add Snacks? (yes/no): ");
            String wantsSnacks = scanner.next().toLowerCase();

            if (wantsSnacks.equals("yes")) {
                totalBill += 8.0; // Flat snack combo price
            }

            // Output final summary
            System.out.println("\Receipt __________");
            System.out.println("Final Bill: " + totalBill);

            // Check if there is another customer in line
            System.out.print("\nBook for another customer? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (response.equals("no")) {
                keepBooking = false;
            }
        }

        System.out.println("closed");
        scanner.close();
    }
}