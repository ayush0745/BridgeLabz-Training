import java.util.*;

public class ECommerceManagementSystem {

    static List<Product> products = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static int orderCounter = 1;

    public static void main(String[] args) {

        products.add(new Product(1, "Laptop", 60000, 5));
        products.add(new Product(2, "Phone", 30000, 10));
        products.add(new Product(3, "Headphones", 2000, 20));

        Customer customer = new Customer(101, "Ayush");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Products\n2. Place Order\n3. Cancel Order\n4. Track Orders\n5. Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Product p : products) {
                        p.display();
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    Product selectedProduct = null;
                    for (Product p : products) {
                        if (p.id == pid && p.stock >= qty) {
                            selectedProduct = p;
                            break;
                        }
                    }

                    if (selectedProduct == null) {
                        System.out.println("Product not available");
                        break;
                    }

                    Order order = new Order(orderCounter++, selectedProduct, qty);
                    double amount = order.getTotalAmount();

                    System.out.println("Select Payment: 1.Card 2.UPI 3.Wallet");
                    int payChoice = sc.nextInt();

                    Payment payment;
                    if (payChoice == 1)
                        payment = new CardPayment();
                    else if (payChoice == 2)
                        payment = new UPIPayment();
                    else
                        payment = new Wallet();

                    try {
                        payment.pay(amount);
                        selectedProduct.stock -= qty;
                        order.confirmOrder();  
                        orders.add(order);
                        System.out.println("Order placed successfully with Order ID: " + order.orderId);
                    } catch (PaymentFailedException e) {
                        System.out.println("Payment Failed: " + e.getMessage());
                    }


                case 3:
                    System.out.print("Enter Order ID: ");
                    int oid = sc.nextInt();

                    boolean found = false;
                    for (Order o : orders) {
                        if (o.orderId == oid) {
                            o.cancelOrder();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Order ID not found");
                    }
                    break;

                case 4:
                    if (orders.isEmpty()) {
                        System.out.println("No orders found");
                    } else {
                        for (Order o : orders) {
                            o.trackOrder();
                        }
                    }
                    break;


                case 5:
                    System.out.println("Thank you for shopping!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
