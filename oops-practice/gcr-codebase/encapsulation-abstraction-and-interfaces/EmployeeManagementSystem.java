import java.util.ArrayList;
import java.util.List;

// Interface defining Department behavior
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract base class
abstract class Employee {
    private int employeeId;
    private String name;
    protected double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Encapsulation: Getters and Seters
    public String getName() { return name; }
    public int getEmployeeId() { return employeeId; }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("ID: " + employeeId + " | Name: " + name + " | Salary: $" + calculateSalary());
    }
}

// Concrete Subclass 1
class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary; // Fixed monthly salary
    }

    @Override
    public void assignDepartment(String deptName) { this.department = deptName; }

    @Override
    public String getDepartmentDetails() { return "Department: " + department; }
}

// Concrete Subclass 2
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hours, double rate) {
        super(id, name, 0);
        this.hoursWorked = hours;
        this.hourlyRate = rate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}



public class EmployeeManagementSystem{
    public static void main(String[] args) {
        // Create a list to hold different types of Employees
        List<Employee> employeeList = new ArrayList<>();

        // Create FullTimeEmployee and assign department
        FullTimeEmployee ft = new FullTimeEmployee(101, "Alice Johnson", 5000);
        ft.assignDepartment("Engineering");

        // Create PartTimeEmployee
        PartTimeEmployee pt = new PartTimeEmployee(102, "Bob Smith", 40, 25.0);

        // Add both to the same list (Polymorphism in action)
        employeeList.add(ft);
        employeeList.add(pt);

        System.out.println("--- Employee Payroll Report ---");

        // Iterate through the list using the Employee reference
        for (Employee emp : employeeList) {
            emp.displayDetails();
            
            // Check if the employee implements Department to show extra details
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
            System.out.println("-------------------------------");
        }
    }
}