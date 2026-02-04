public class BackgroundJobExecution {

    public static void main(String[] args) {

        // Runnable task using lambda
        Runnable backgroundTask = () -> {
            System.out.println("Background job started...");
            try {
                Thread.sleep(2000); // simulate work
            } catch (InterruptedException e) {
                System.out.println("Job interrupted");
            }
            System.out.println("Background job finished.");
        };

        // Execute task asynchronously
        Thread workerThread = new Thread(backgroundTask);
        workerThread.start();

        System.out.println("Main thread continues execution...");
    }
}
