public class Main {
    public static void main(String[] args) {

        BackupScheduler scheduler = new BackupScheduler();

        try {
            scheduler.addTask(new BackupTask("/system/config", 1));   // Critical
            scheduler.addTask(new BackupTask("/user/documents", 3));  // Normal
            scheduler.addTask(new BackupTask("/database", 2));         // Important
            scheduler.addTask(new BackupTask("", 1));                  // Invalid
        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nExecuting Backup Tasks:");
        scheduler.executeAll();
    }
}
