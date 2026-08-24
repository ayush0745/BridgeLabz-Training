public class Email {

    public static boolean isValidEmail(String email) {
        return email.matches(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        );
    }

    public static void main(String[] args) {

        String[] emails = {
            "user@gmail.com",
            "john.doe@yahoo.com",
            "abc123@outlook.com",
            "test.user@company.in",
            "hello+java@gmail.com",

            "usergmail.com",       
            "user@gmail",          
            "user@.com",           
            "user@gmail..com",     
            "@gmail.com"           
        };

        for (String email : emails) {
            System.out.println(email + " -> " + isValidEmail(email));
        }
    }
}