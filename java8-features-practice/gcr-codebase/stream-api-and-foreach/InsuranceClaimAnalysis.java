import java.util.*;
import java.util.stream.Collectors;

public class InsuranceClaimAnalysis {

    // Claim class
    static class Claim {
        String claimType;
        double amount;

        Claim(String claimType, double amount) {
            this.claimType = claimType;
            this.amount = amount;
        }
    }

    // Main method
    public static void main(String[] args) {

        List<Claim> claims = Arrays.asList(
            new Claim("Health", 50000),
            new Claim("Vehicle", 30000),
            new Claim("Health", 70000),
            new Claim("Travel", 15000),
            new Claim("Vehicle", 45000),
            new Claim("Health", 60000),
            new Claim("Travel", 20000)
        );

        // Calculate average claim amount per claim type
        Map<String, Double> averageClaimAmount =
                claims.stream()
                      .collect(Collectors.groupingBy(
                          c -> c.claimType,
                          Collectors.averagingDouble(c -> c.amount)
                      ));

        // Display result
        averageClaimAmount.forEach((type, avg) ->
                System.out.println(type + " Claim Average: ₹" + avg));
    }
}
