import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Make it available at runtime
@Target(ElementType.METHOD)         // Can only be applied to methods
@interface ImportantMethod {
    String level() default "HIGH"; // Optional parameter with default value
}
//Apply the annotation to a class
class TaskManager {

    @ImportantMethod // Uses default level "HIGH"
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    @ImportantMethod(level = "MEDIUM") // Explicit level
    public void normalTask() {
        System.out.println("Executing normal task...");
    }

    public void minorTask() { // Not annotated
        System.out.println("Executing minor task...");
    }
}

// Retrieve and print annotated methods
public class ImportantMethodAnnotation {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Method[] methods = tm.getClass().getDeclaredMethods();

        System.out.println("Important Methods:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("- " + method.getName() + " [Level: " + annotation.level() + "]");
            }
        }

        System.out.println("\nExecuting all tasks:");
        tm.criticalTask();
        tm.normalTask();
        tm.minorTask();
    }
}
