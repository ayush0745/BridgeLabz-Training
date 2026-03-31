import java.util.*;

public class IoTSensorReadings {

    public static void main(String[] args) {

        // Simulated IoT sensor readings
        List<Double> sensorReadings = Arrays.asList(
            22.5,
            35.8,
            18.2,
            40.1,
            27.6,
            45.9
        );

        double threshold = 30.0;

        // Stream processing
        sensorReadings.stream()
                      // filter readings above threshold
                      .filter(reading -> reading > threshold)

                      // print the readings
                      .forEach(reading ->
                          System.out.println("High Reading: " + reading)
                      );
    }
}
