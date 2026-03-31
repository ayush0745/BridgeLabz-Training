public class Main{
    public static void main(String[] args) {

        Product<BookCategory> book =
            new Product<>("Java Programming", 500, new BookCategory());

        Product<ClothingCategory> shirt =
            new Product<>("T-Shirt", 1200, new ClothingCategory());

        Product<GadgetCategory> phone =
            new Product<>("Smartphone", 25000, new GadgetCategory());

        DiscountService.applyDiscount(book, 10);
        DiscountService.applyDiscount(shirt, 20);
        DiscountService.applyDiscount(phone, 5);

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        catalog.displayCatalog();
    }
}
