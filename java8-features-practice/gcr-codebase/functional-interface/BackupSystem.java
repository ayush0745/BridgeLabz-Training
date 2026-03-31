public class BackupSystem {

    // Marker interface (no methods)
    interface BackupSerializable {
        // no methods
    }

    // Class marked for backup
    static class UserData implements BackupSerializable {
        String username;
        String email;

        UserData(String username, String email) {
            this.username = username;
            this.email = email;
        }
    }

    // Another class marked for backup
    static class TransactionData implements BackupSerializable {
        int transactionId;
        double amount;

        TransactionData(int transactionId, double amount) {
            this.transactionId = transactionId;
            this.amount = amount;
        }
    }

    // Class NOT marked for backup
    static class TempCache {
        String tempData;
    }

    // Backup processor
    static class BackupProcessor {

        static void processBackup(Object obj) {
            if (obj instanceof BackupSerializable) {
                System.out.println("Backing up object: "
                        + obj.getClass().getSimpleName());
            } else {
                System.out.println("Object not eligible for backup: "
                        + obj.getClass().getSimpleName());
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        UserData user = new UserData("Ayush", "ayush@email.com");
        TransactionData txn = new TransactionData(101, 2500);
        TempCache cache = new TempCache();

        BackupProcessor.processBackup(user);
        BackupProcessor.processBackup(txn);
        BackupProcessor.processBackup(cache);
    }
}
