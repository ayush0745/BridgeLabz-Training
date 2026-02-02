import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD)         // Can only be applied to methods
@interface LogExecutionTime {
}

// Class with methods to test
class TaskManager {

    @LogExecutionTime
    public void quickTask() {
        // Simulate a fast task
        for (int i = 0; i < 1000; i++) {
            int x = i * i;
        }
    }

    @LogExecutionTime
    public void slowTask() {
        // Simulate a slower task
        try {
            Thread.sleep(100); // Sleep for 100 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Main class to measure execution time
public class Log {
    public static void main(String[] args) throws Exception {
        TaskManager tm = new TaskManager();
        Method[] methods = tm.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime(); // Start time
                method.invoke(tm);                  // Execute the method
                long endTime = System.nanoTime();   // End time
                long duration = endTime - startTime;
                System.out.println(method.getName() + " executed in " + duration + " nanoseconds.");
            }
        }
    }
}
