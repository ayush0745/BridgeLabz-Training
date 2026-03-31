class Order {
    int orderId;
    Product product;
    int quantity;
    String status;

    public Order(int orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.status = "Pending Payment";
    }

    public double getTotalAmount() {
        return product.price * quantity;
    }

    public void confirmOrder() {
        status = "Confirmed";
    }

    public void cancelOrder() {
        if (status.equals("Confirmed")) {
            status = "Cancelled";
            product.stock += quantity;
            System.out.println("Order " + orderId + " cancelled successfully");
        } else if (status.equals("Cancelled")) {
            System.out.println("Order already cancelled");
        } else {
            System.out.println("Order cannot be cancelled");
        }
    }

    public void trackOrder() {
        System.out.println(
            "Order ID: " + orderId +
            " | Product: " + product.name +
            " | Qty: " + quantity +
            " | Status: " + status
        );
    }
}
