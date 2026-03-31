class Employee {
    // Access modifiers
    public int employeeID;
    protected String department;
    private double salary;

    // Constructor
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to access private salary
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public double getSalary() {
        return salary;
    }
}

// Subclass 
class Manager extends Employee {
    String role;

    Manager(int employeeID, String department, double salary, String role) {
        super(employeeID, department, salary);
        this.role = role;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeID); 
        System.out.println("Department: " + department);  
        System.out.println("Salary: " + getSalary());      
        System.out.println("Role: " + role);
    }

    public static void main(String[] args) {
        Manager m = new Manager(5, "IT", 7700, "software tester");

        m.displayDetails();

        m.setSalary(80000);
        System.out.println("Updated Salary: " + m.getSalary());
    }
}
