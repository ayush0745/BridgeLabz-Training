import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD)         // Can be applied to methods
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Apply the annotation to a class
class Project {

    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature is under development...");
    }

    @Todo(task = "Add search functionality", assignedTo = "Bob")
    public void searchFeature() {
        System.out.println("Search feature is under development...");
    }

    public void completedFeature() {
        System.out.println("This feature is already completed!");
    }
}

// Retrieve and print all pending tasks using reflection
public class TodoAnnotation {
    public static void main(String[] args) {
        Project project = new Project();
        Method[] methods = project.getClass().getDeclaredMethods();

        System.out.println("Pending Tasks:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("- " + todo.task() + " | Assigned To: " + todo.assignedTo() + " | Priority: " + todo.priority());
            }
        }

        System.out.println("\nExecuting all methods:");
        project.loginFeature();
        project.searchFeature();
        project.completedFeature();
    }
}
