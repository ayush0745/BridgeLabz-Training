class DiscountService {

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice =
                product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(discountedPrice);
    }
}
