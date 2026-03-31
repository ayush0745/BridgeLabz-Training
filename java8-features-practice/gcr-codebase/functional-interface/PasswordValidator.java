public class PasswordValidator {

    // Interface with static utility method
    interface SecurityUtils {

        static boolean isStrongPassword(String password) {
            if (password.length() < 8)
                return false;

            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            for (char ch : password.toCharArray()) {
                if (Character.isUpperCase(ch)) hasUpper = true;
                else if (Character.isLowerCase(ch)) hasLower = true;
                else if (Character.isDigit(ch)) hasDigit = true;
                else hasSpecial = true;
            }

            return hasUpper && hasLower && hasDigit && hasSpecial;
        }
    }

    // Main method
    public static void main(String[] args) {

        String password = "Insure@123";

        if (SecurityUtils.isStrongPassword(password)) {
            System.out.println(" Strong password");
        } else {
            System.out.println(" Weak password");
        }
    }
}
