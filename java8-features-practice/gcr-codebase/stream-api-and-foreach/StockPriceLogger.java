import java.util.*;

public class StockPriceLogger {

    public static void main(String[] args) {

        // Simulated live stock price feed
        List<Double> stockPrices = Arrays.asList(
            1250.50,
            1265.75,
            1248.20,
            1272.90,
            1280.10
        );

        // Print each stock price update
        stockPrices.forEach(price ->
                System.out.println("Stock Price Update: ₹" + price)
        );
    }
}
