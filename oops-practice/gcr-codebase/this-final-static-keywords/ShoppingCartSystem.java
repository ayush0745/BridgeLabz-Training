 class Product {

    // Static variable shared across all products
    private static double discount = 10.0; // percentage

    // Final variable (cannot be changed once assigned)
    private final String productID;

    private String productName;
    private double price;
    private int quantity;

    // Constructor using 'this' keyword
    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method to display product details using instanceof
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");

            double discountedPrice = price - (price * discount / 100);
            System.out.println("Price after Discount: $" + discountedPrice);
            System.out.println();
        } else {
            System.out.println("Invalid product instance.");
        }
    }

    // Main method
    public static void main(String[] args) {

        Product p1 = new Product("P001", "Laptop", 1200.0, 5);
        Product p2 = new Product("P002", "Smartphone", 800.0, 10);

        // Display product details
        p1.displayProductDetails();
        p2.displayProductDetails();
    }
}
