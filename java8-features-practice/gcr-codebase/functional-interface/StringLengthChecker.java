import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {

        String message = "Please submit your documents today.";
        int limit = 20;

        // Function to get length of string
        Function<String, Integer> stringLength =
                msg -> msg.length();

        int length = stringLength.apply(message);

        if (length > limit) {
            System.out.println(" Message exceeds character limit");
        } else {
            System.out.println(" Message is within character limit");
        }

        System.out.println("Length: " + length);
    }
}
