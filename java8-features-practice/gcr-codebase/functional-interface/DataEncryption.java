public class DataEncryption {

    // Custom marker interface
    interface SensitiveData {
        // no methods
    }

    // Sensitive class
    static class UserCredentials implements SensitiveData {
        String username;
        String password;

        UserCredentials(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    // Another sensitive class
    static class BankDetails implements SensitiveData {
        String accountNumber;
        double balance;

        BankDetails(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }
    }

    // Non-sensitive class
    static class ProductInfo {
        String productName;
        double price;
    }

    // Encryption processor
    static class EncryptionProcessor {

        static void encryptIfSensitive(Object obj) {
            if (obj instanceof SensitiveData) {
                System.out.println("Encrypting sensitive data: "
                        + obj.getClass().getSimpleName());
            } else {
                System.out.println("No encryption needed for: "
                        + obj.getClass().getSimpleName());
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        UserCredentials user = new UserCredentials("Ayush", "pass@123");
        BankDetails bank = new BankDetails("1234567890", 50000);
        ProductInfo product = new ProductInfo();

        EncryptionProcessor.encryptIfSensitive(user);
        EncryptionProcessor.encryptIfSensitive(bank);
        EncryptionProcessor.encryptIfSensitive(product);
    }
}
