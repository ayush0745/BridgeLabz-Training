import java.util.Scanner;

class Item {
    String itemCode;
    String itemName;
    double price;

    // Constructor 
    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    public void displayItem() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }

    // Method to calculate total cost 
    public double calculateTotal(int quantity) {
        return this.price * quantity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Item item1 = new Item("01AA", "Water bottle", 500.0);
        Item item2 = new Item("01BB", "Rice", 700.0);
        Item item3 = new Item("02AA", "blackboard", 400.0);

        // Displaying the items
        item1.displayItem();
        item2.displayItem();
        item3.displayItem();

        // Example of calculating total cost for a specific item
        System.out.print("Enter quantity for " + item1.itemName + ": ");
        int qty = scanner.nextInt();
        System.out.println("Total Cost: " + item1.calculateTotal(qty));

        scanner.close();
    }
}