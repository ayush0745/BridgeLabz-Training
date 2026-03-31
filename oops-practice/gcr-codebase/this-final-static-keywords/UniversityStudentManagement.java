class Student {

    // Static variable shared across all students
    private static String universityName = "Global University";
    private static int totalStudents = 0;

    // Final variable (cannot be changed once assigned)
    private final int rollNumber;

    private String name;
    private String grade;

    // Constructor using 'this' keyword
    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to display student details using instanceof
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println();
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Invalid student instance.");
        }
    }

    // Method to update grade using instanceof
    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        }
    }

    // Main method
    public static void main(String[] args) {

        Student s1 = new Student(101, "Hemashree", "A");
        Student s2 = new Student(102, "Sharmila", "B");

        Student.displayTotalStudents();

        s1.displayStudentDetails();
        System.out.println();

        s2.displayStudentDetails();
        s2.updateGrade("A");
        s2.displayStudentDetails();
    }
}
