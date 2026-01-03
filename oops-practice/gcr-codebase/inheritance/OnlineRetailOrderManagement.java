class Order {
    protected String orderId;
    protected String orderDate;

    // Constructor
    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to get order status
    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;

    // Constructor
    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    // Constructor
    DeliveredOrder(String orderId, String orderDate,
                   String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

public class OnlineRetailSystem {
    public static void main(String[] args) {
        DeliveredOrder order1 = new DeliveredOrder(
                "ORD123",
                "2026-01-01",
                "TRK456789",
                "2026-01-03"
        );

        System.out.println("Order ID: " + order1.orderId);
        System.out.println("Order Date: " + order1.orderDate);
        System.out.println("Tracking Number: " + order1.trackingNumber);
        System.out.println(order1.getOrderStatus());
    }
}
