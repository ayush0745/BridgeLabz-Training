import java.lang.annotation.*;
import java.lang.reflect.Method;

//  Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Make it available at runtime
@Target(ElementType.METHOD)         // Can only be applied to methods
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Use the annotation in a class
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}

// 3️⃣ Retrieve annotation details using Reflection
public class TaskInfoAnnotation {
    public static void main(String[] args) throws Exception {
        TaskManager tm = new TaskManager();

        // Get the method
        Method method = tm.getClass().getMethod("completeTask");

        // Check if the method has @TaskInfo annotation
        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo info = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + info.priority());
            System.out.println("Assigned To: " + info.assignedTo());
        }

        // Call the method
        tm.completeTask();
    }
}
