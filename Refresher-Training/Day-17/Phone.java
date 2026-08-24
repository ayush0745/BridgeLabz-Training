public class Phone {

    public static boolean isValidPhone(String phone) {
        return phone.matches(
            "^(\\+\\d{1,3}[-.]?)?\\(?\\d{3}\\)?[- .]?\\d{3}[- .]?\\d{4}$"
        );
    }

    public static void main(String[] args) {

        String[] phones = {
            "5551234567",
            "555-123-4567",
            "+1 555-123-4567",
            "(555) 123-4567",
            "555.123.4567",

            "555123456",       // too few digits
            "555-ABC-4567"     // letters
        };

        for (String phone : phones) {
            System.out.println(phone + " -> " + isValidPhone(phone));
        }
    }
}