
class Employee {

    // Static variable shared by all employees
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;

    // Final variable (cannot be changed once assigned)
    private final int id;

    private String name;
    private String designation;

    // Constructor using 'this' keyword
    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details using instanceof
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println();
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Invalid employee instance.");
        }
    }

    // Main method
    public static void main(String[] args) {

        Employee emp1 = new Employee(101, "Thamarai", "Software Engineer");
        Employee emp2 = new Employee(102, "Rohan", "Project Manager");

        Employee.displayTotalEmployees();

        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
    }
}
