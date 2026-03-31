import java.util.*;
import java.util.stream.*;

class Order {
    private String customerName;
    private double amount;

    public Order(String customerName, double amount) {
        this.customerName = customerName;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }
}

public class OrderRevenueSummary {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
            new Order("Aman", 250.50),
            new Order("Riya", 300.00),
            new Order("Aman", 150.00),
            new Order("Karan", 500.00),
            new Order("Riya", 200.00)
        );

        // Sum order totals per customer
        Map<String, Double> revenueSummary =
                orders.stream()
                      .collect(Collectors.groupingBy(
                              Order::getCustomerName,
                              Collectors.summingDouble(Order::getAmount)
                      ));

        // Print result
        revenueSummary.forEach((customer, total) ->
                System.out.println(customer + " total revenue: " + total));
    }
}
