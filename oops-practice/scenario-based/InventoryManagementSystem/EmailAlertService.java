public class EmailAlertService implements AlertService {

    @Override
    public void sendLowStockAlert(Product product) {
        System.out.println("⚠ LOW STOCK ALERT: " 
            + product.getProductName()
            + " | Remaining: " + product.getQuantity());
    }
}
