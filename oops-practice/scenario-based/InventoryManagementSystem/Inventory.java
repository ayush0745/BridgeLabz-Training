import java.util.*;

public class Inventory {
    private Map<Integer, Product> products = new HashMap<>();
    private static final int LOW_STOCK_LIMIT = 5;

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Product added: " + product.getProductName());
    }

    public void updateStock(int productId, int quantity)
            throws OutOfStockException {

        Product product = products.get(productId);

        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        if (quantity <= 0) {
            throw new OutOfStockException(
                    product.getProductName() + " is out of stock!"
            );
        }

        product.setQuantity(quantity);
    }

    public void monitorStock(AlertService alertService) {
        for (Product product : products.values()) {
            if (product.getQuantity() <= LOW_STOCK_LIMIT) {
                alertService.sendLowStockAlert(product);
            }
        }
    }

    public void showInventory() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}
