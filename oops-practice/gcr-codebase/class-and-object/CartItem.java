import java.util.Scanner;

class CartItem {
    String itemName;
    double price;
    int quantity;

    // Constructor 
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add items 
    public void addItem(int qty) {
        this.quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // Method to remove items 
    public void removeItem(int qty) {
        if (qty <= this.quantity) {
            this.quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Error: Cannot remove more items than present in cart.");
        }
    }

    // Method to calculate and display total cost
    public void displayTotal() {
        double total = price * quantity;
        System.out.printf("Total cost: $%.2f%n", total);
    }

    public void displayCurrentStatus() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }

    public static void main(String[] args) {
        // Initializing item
        CartItem item = new CartItem("Laptop", 999.99, 1);
        
        // Display initial state
        item.displayCurrentStatus();

        item.addItem(2);

        item.removeItem(1);

        //Display final total
        item.displayTotal();
    }
}