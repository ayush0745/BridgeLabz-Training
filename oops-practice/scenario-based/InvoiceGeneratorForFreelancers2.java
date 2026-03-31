import java.util.Scanner;

// Custom Exception
class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGeneratorForFreelancers2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter invoice details:");
            String input = sc.nextLine();

            String[] tasks = parseInvoice(input);
            int totalAmount = getTotalAmount(tasks);

            System.out.println("Total Invoice Amount: " + totalAmount + " INR");

        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Parse Invoice String
    public static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        if (!input.contains("-")) {
            throw new InvalidInvoiceFormatException("Invalid format: '-' missing");
        }

        return input.split(",");
    }

    // Calculate Total Amount
    public static int getTotalAmount(String[] tasks) throws InvalidInvoiceFormatException {
        int total = 0;

        for (String task : tasks) {
            String[] parts = task.split("-");

            if (parts.length < 2) {
                throw new InvalidInvoiceFormatException("Invalid task format: " + task);
            }

            String amountPart = parts[1].trim();

            // Extract numeric amount
            String[] amountTokens = amountPart.split(" ");
            if (amountTokens.length == 0) {
                throw new InvalidInvoiceFormatException("Amount missing in: " + task);
            }

            try {
                int amount = Integer.parseInt(amountTokens[0]);
                total += amount;
            } catch (NumberFormatException e) {
                throw new InvalidInvoiceFormatException(
                    "Invalid amount in task: " + task
                );
            }
        }

        return total;
    }
}
