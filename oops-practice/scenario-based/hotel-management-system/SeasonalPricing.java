public class SeasonalPricing implements PricingStrategy {

    // Increases price during peak season
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 1.2;
    }
}
