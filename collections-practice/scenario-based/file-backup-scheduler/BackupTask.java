class BackupTask implements Comparable<BackupTask> {

    private String folderPath;
    private int priority;

    public BackupTask(String folderPath, int priority) throws InvalidBackupPathException {
        if (folderPath == null || folderPath.isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path!");
        }
        this.folderPath = folderPath;
        this.priority = priority;
    }

    public void executeBackup() {
        System.out.println("Backing up folder: " + folderPath + " | Priority: " + priority);
    }

    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(this.priority, other.priority);
    }
}
