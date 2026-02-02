import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Define the repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class) // Make it repeatable
@interface BugReport {
    String description();
}

// Use the repeatable annotation on a method
class TaskManager {

    @BugReport(description = "NullPointerException occurs sometimes")
    @BugReport(description = "UI freezes on slow network")
    public void performTask() {
        System.out.println("Performing the task...");
    }
}

// Retrieve and print all bug reports using reflection
public class BugReportAnnotation {
    public static void main(String[] args) throws Exception {
        TaskManager tm = new TaskManager();
        Method method = tm.getClass().getMethod("performTask");

        // Check if there are any BugReport annotations
        if (method.isAnnotationPresent(BugReport.class) || method.isAnnotationPresent(BugReports.class)) {
            // Retrieve all repeatable annotations
            BugReport[] reports = method.getAnnotationsByType(BugReport.class);
            System.out.println("Bug Reports for performTask():");
            for (BugReport report : reports) {
                System.out.println("- " + report.description());
            }
        }

        // Call the method
        tm.performTask();
    }
}
