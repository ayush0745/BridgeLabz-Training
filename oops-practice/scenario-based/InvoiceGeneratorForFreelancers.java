import java.util.Scanner;

public class InvoiceGeneratorForFreelancers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter invoice details:");
        String input = sc.nextLine();

        String[] tasks = parseInvoice(input);
        int totalAmount = getTotalAmount(tasks);

        System.out.println("Total Invoice Amount: " + totalAmount + " INR");

        sc.close();
    }

    // Method to split invoice string into tasks
    public static String[] parseInvoice(String input) {
        return input.split(",");
    }

    // Method to calculate total amount
    public static int getTotalAmount(String[] tasks) {
        int total = 0;

        for (String task : tasks) {
            String[] parts = task.split("-");

            String amountPart = parts[1].trim();      // "3000 INR"
            String[] amountTokens = amountPart.split(" ");

            int amount = Integer.parseInt(amountTokens[0]);
            total += amount;
        }

        return total;
    }
}
