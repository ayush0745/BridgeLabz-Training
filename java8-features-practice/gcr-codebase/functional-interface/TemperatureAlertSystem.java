import java.util.function.Predicate;

public class TemperatureAlertSystem {

    public static void main(String[] args) {

        double temperature = 39.5;   // current temperature
        double threshold = 38.0;     // alert limit

        // Predicate to check if temperature crosses threshold
        Predicate<Double> temperatureAlert =
                temp -> temp > threshold;

        if (temperatureAlert.test(temperature)) {
            System.out.println("⚠️ Alert: Temperature crossed threshold!");
        } else {
            System.out.println("Temperature is normal.");
        }
    }
}
