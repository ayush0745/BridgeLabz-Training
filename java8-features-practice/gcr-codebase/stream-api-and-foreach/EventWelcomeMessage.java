import java.util.*;

public class EventWelcomeMessage {

    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
            "Ayush",
            "Rahul",
            "Sneha",
            "Priya",
            "Karan"
        );

        // Print welcome message for each attendee
        attendees.forEach(name ->
                System.out.println("Welcome to the event, " + name + "!")
        );
    }
}
