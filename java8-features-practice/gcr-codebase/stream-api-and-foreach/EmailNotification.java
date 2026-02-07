import java.util.*;

public class EmailNotification {

    public static void main(String[] args) {

        List<String> emails = Arrays.asList(
            "ayush@gmail.com",
            "rahul@gmail.com",
            "sneha@gmail.com",
            "priya@gmail.com"
        );

        // Send notification to each email
        emails.forEach(email -> sendEmailNotification(email));
    }

    // Simulated email sending method
    private static void sendEmailNotification(String email) {
        System.out.println("Notification email sent to: " + email);
    }
}
