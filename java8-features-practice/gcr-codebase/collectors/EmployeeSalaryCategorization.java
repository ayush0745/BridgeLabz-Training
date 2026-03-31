import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeSalaryCategorization {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee("Aman", "IT", 60000),
            new Employee("Riya", "HR", 50000),
            new Employee("Karan", "IT", 70000),
            new Employee("Neha", "Finance", 65000),
            new Employee("Vikas", "HR", 55000)
        );

        // Group by department and calculate average salary
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        // Print result
        avgSalaryByDept.forEach((dept, avgSalary) ->
                System.out.println(dept + " Average Salary: " + avgSalary));
    }
}
