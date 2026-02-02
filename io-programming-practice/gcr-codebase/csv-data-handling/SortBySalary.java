import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class SortBySalary {
    public static void main(String[] args) {

        String filePath = "employees.csv";
        String line;
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                employees.add(new Employee(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort by salary in descending order
        employees.sort(Comparator.comparingDouble(e -> -e.salary));

        // Print top 5 highest-paid employees
        System.out.println("Top 5 Highest-Paid Employees:");
        System.out.println("------------------------------");

        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            Employee e = employees.get(i);
            System.out.println(
                "ID: " + e.id +
                ", Name: " + e.name +
                ", Dept: " + e.department +
                ", Salary: " + e.salary
            );
        }
    }
}
