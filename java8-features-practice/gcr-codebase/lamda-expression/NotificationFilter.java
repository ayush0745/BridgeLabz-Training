import java.util.*;
import java.util.function.Predicate;
class Alert {
    String message;
    String type;
    int priority;

    Alert(String message, String type, int priority) {
        this.message = message;
        this.type = type;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return type + " | Priority: " + priority + " | " + message;
    }
}


public class NotificationFilter {

    public static void main(String[] args) {

        List<Alert> alerts = List.of(
            new Alert("Heart rate critical", "EMERGENCY", 1),
            new Alert("Time for medication", "MEDICATION", 2),
            new Alert("Daily health tips", "GENERAL", 5),
            new Alert("Blood pressure high", "EMERGENCY", 1)
        );

        // User preference: only emergency alerts
        Predicate<Alert> emergencyOnly =
                alert -> alert.type.equals("EMERGENCY");

        // User preference: high priority alerts (priority <= 2)
        Predicate<Alert> highPriority =
                alert -> alert.priority <= 2;

        // Apply filters
        alerts.stream()
              .filter(emergencyOnly.and(highPriority))
              .forEach(System.out::println);
    }
}
