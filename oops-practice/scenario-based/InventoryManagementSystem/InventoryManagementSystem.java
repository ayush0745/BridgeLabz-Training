public class InventoryManagementSystem {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        AlertService alertService = new EmailAlertService();

        Product p1 = new Product(1, "Keyboard", 10);
        Product p2 = new Product(2, "Mouse", 3);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        try {
            inventory.updateStock(2, 2);
            inventory.updateStock(1, 0);   // Exception case
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n📊 Current Inventory:");
        inventory.showInventory();

        System.out.println("\n🔔 Stock Monitoring:");
        inventory.monitorStock(alertService);
    }
}
