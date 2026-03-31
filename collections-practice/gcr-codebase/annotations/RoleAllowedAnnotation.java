import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the class-level annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // Apply to methods
@interface RoleAllowed {
    String value(); // Role required
}

// Service class with restricted methods
class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully!");
    }

    @RoleAllowed("ADMIN")
    public void resetSystem() {
        System.out.println("System reset successfully!");
    }

    public void viewDashboard() {
        System.out.println("Dashboard is visible to all users.");
    }
}

//  Main class to simulate user roles
public class RoleAllowedAnnotation {
    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER"; // Change to "ADMIN" to test admin access

        AdminService service = new AdminService();
        Method[] methods = service.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed role = method.getAnnotation(RoleAllowed.class);
                if (role.value().equals(currentUserRole)) {
                    method.invoke(service); // Allow access
                } else {
                    System.out.println("Access Denied to method: " + method.getName());
                }
            } else {
                // Methods without @RoleAllowed are accessible to everyone
                method.invoke(service);
            }
        }
    }
}
