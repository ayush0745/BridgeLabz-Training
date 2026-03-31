import java.util.*;
class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " | Price: " + price +
               " | Rating: " + rating +
               " | Discount: " + discount + "%";
    }
}

public class ECommerceSorting {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 70000, 4.5, 10));
        products.add(new Product("Phone", 30000, 4.7, 20));
        products.add(new Product("Headphones", 2000, 4.2, 30));

        // Sort by price (Low to High)
        products.sort((p1, p2) ->
                Double.compare(p1.price, p2.price));

        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);

        // Sort by rating (High to Low)
        products.sort((p1, p2) ->
                Double.compare(p2.rating, p1.rating));

        System.out.println("\nSorted by Rating:");
        products.forEach(System.out::println);

        // Sort by discount (High to Low)
        products.sort((p1, p2) ->
                Double.compare(p2.discount, p1.discount));

        System.out.println("\nSorted by Discount:");
        products.forEach(System.out::println);
    }
}
