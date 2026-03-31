public class PrototypeCloning {

    // Prototype class
    static class Product implements Cloneable {

        int id;
        String name;
        double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        // Overriding clone() method
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone(); // shallow copy
        }

        @Override
        public String toString() {
            return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
        }
    }

    // Main method
    public static void main(String[] args) {

        try {
            // Predefined prototype object
            Product original = new Product(101, "Laptop", 75000);

            // Clone the prototype
            Product copy = (Product) original.clone();

            System.out.println("Original: " + original);
            System.out.println("Cloned  : " + copy);

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }
    }
}
