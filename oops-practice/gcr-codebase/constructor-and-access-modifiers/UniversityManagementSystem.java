class Student {
    // Access specifiers
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor
    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public methods to access and modify private CGPA
    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

// Subclass demonstrating protected access
class PostgraduateStudent extends Student {
    String specialization;

    PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    void displayDetails() {
        System.out.println("Roll Number: " + rollNumber); 
        System.out.println("Name: " + name);               
        System.out.println("CGPA: " + getCGPA());          
        System.out.println("Specialization: " + specialization);
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(
                101, "Ayush", 8.6, "Computer Science");

        pg.displayDetails();
        pg.setCGPA(9.0); // modifying CGPA
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}
