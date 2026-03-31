import java.util.PriorityQueue;

class BackupScheduler {

    private PriorityQueue<BackupTask> taskQueue = new PriorityQueue<>();

    public void addTask(BackupTask task) {
        taskQueue.add(task);
    }

    public void executeAll() {
        while (!taskQueue.isEmpty()) {
            BackupTask task = taskQueue.poll();
            task.executeBackup();
        }
    }
}
