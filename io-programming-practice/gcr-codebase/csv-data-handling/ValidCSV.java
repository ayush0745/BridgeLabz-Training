import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVData {

    // Regex patterns
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_REGEX =
            "\\d{10}";

    public static void main(String[] args) {

        String filePath = "users.csv";
        String line;

        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Pattern phonePattern = Pattern.compile(PHONE_REGEX);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String email = data[2];
                String phone = data[3];

                boolean valid = true;

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid Email in row ID " + id + ": " + email);
                    valid = false;
                }

                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Invalid Phone Number in row ID " + id + ": " + phone);
                    valid = false;
                }

                if (!valid) {
                    System.out.println("❌ Invalid Row Data: " + line);
                    System.out.println("--------------------------------");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
