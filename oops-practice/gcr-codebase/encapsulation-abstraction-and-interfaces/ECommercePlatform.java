abstract class Product {
    private int productId;
    private String name;
    private double price;
    
    public Product(int productId, String name, double price) {
        this.productId = productId; // Fixed assignment
        this.name = name;
        this.price = price;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    
    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax(double price);
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    // Changed id to int to match parent
    public Electronics(int id, String name, double price) { 
        super(id, name, price); 
    }

    @Override
    public double calculateDiscount() { return getPrice() * 0.15; }

    @Override
    public double calculateTax(double price) { return price * 0.18; }

    @Override
    public String getTaxDetails() { return "Electronics Tax (18%)"; }
}

class Groceries extends Product {
    public Groceries(int id, String name, double price) { 
        super(id, name, price); 
    }

    @Override
    public double calculateDiscount() { return 0.0; }
}
 class ECommercePlatForm {
    public static void main(String[] args) {
        Product[] cart = {
            new Electronics(1, "Smartphone", 1000),
            new Groceries(2, "Rice", 50)
        };

        for (Product p : cart) {
            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() - discount;

            System.out.println("Product: " + p.getName());
            
            // Safe check for Interface
            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                double tax = t.calculateTax(finalPrice);
                finalPrice += tax;
                System.out.println(t.getTaxDetails() + ": $" + tax);
            }

            System.out.println("Final Price: $" + finalPrice);
            System.out.println("-------------------------");
        }
    }
}