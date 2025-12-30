import java.util.*;
class Employee {
    // Attributes
    String name;
    int id;
    double salary;

    // Constructor to initialize the attributes
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

     
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine(); 

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt(); 

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble(); 
       
        Employee emp = new Employee(name, id, salary);

        // Calling the method to display details
        emp.displayDetails();
    }
}