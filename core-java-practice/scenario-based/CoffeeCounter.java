import java.util.Scanner;

// Creating Class with name CoffeeCounter indicating the purpose is to 
// manage cafe orders and calculate the total bill including GST
public class CoffeeCounter {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner scanner = new Scanner(System.in);
        
        // Define the GST rate as a constant percentage
        double gstRate = 0.18;

        // Use a while loop to continue taking orders until "exit" is typed
        while (true) {
            System.out.println("--- Coffee Menu: Espresso, Latte, Cappuccino (Type 'exit' to quit) ---");
            System.out.print("Enter coffee type: ");
            String coffeeType = scanner.next().toLowerCase();

            // Check if the user wants to break the loop and close the program
            if (coffeeType.equals("exit")) {
                System.out.println("Closing the Coffee Counter. Goodbye!");
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            double price = 0;

            // Use a switch statement to set the price based on the coffee type selected
            switch (coffeeType) {
                case "espresso":
                    price = 150.0;
                    break;
                case "latte":
                    price = 200.0;
                    break;
                case "cappuccino":
                    price = 180.0;
                    break;
                default:
                    System.out.println("Invalid coffee type. Please try again.");
                    continue; // Skip the rest of the loop for invalid input
            }

            // Calculate the total bill by multiplying price and quantity
            double baseBill = price * quantity;

            // Find the GST amount using arithmetic operators
            double gstAmount = baseBill * gstRate;
            
            // Find the final total by adding the base bill and the GST
            double finalTotal = baseBill + gstAmount;

            // Display the order summary and the final bill amount
            System.out.println("Base Bill: " + baseBill);
            System.out.println("GST (18%): " + gstAmount);
            System.out.println("Total Amount to Pay: " + finalTotal);
        }

        // Closing the Scanner Stream
        input.close();
    }
}