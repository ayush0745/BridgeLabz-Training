import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerialization {
    public static void main(String[] args) {

        String fileName = "employees.dat";

        // Creating employee list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Ayush", "IT", 55000));
        employees.add(new Employee(2, "Riya", "HR", 45000));
        employees.add(new Employee(3, "Karan", "Finance", 60000));

        // 🔹 Serialization
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");

        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }

        // 🔹 Deserialization
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            List<Employee> empList =
                    (List<Employee>) ois.readObject();

            System.out.println("\nEmployees retrieved from file:");
            for (Employee emp : empList) {
                emp.display();
            }

        } catch (IOException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
