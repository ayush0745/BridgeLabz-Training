public class UsernameValidator {

    public static boolean isValidUsername(String username) {
        return username.matches("^[A-Za-z][A-Za-z0-9_]{4,14}$");
    }

    public static void main(String[] args) {

        String[] usernames = {"user_123", "123user", "us"};

        for (String name : usernames) {
            if (isValidUsername(name))
                System.out.println(name + " → Valid");
            else
                System.out.println(name + " → Invalid");
        }
    }
}
