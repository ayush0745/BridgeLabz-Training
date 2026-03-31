// This program measures the execution time of a method using reflection.
import java.lang.reflect.Method;

class TaskRunner {
    public void longRunningTask() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class MethodTimingReflection {
    public static void main(String[] args) throws Exception {
        TaskRunner runner = new TaskRunner();
        Class<?> cls = runner.getClass();
        Method method = cls.getMethod("longRunningTask");

        long start = System.nanoTime();
        method.invoke(runner);
        long end = System.nanoTime();

        long durationMillis = (end - start) / 1_000_000;
        System.out.println("Method longRunningTask execution time: " + durationMillis + " ms");
    }
}


