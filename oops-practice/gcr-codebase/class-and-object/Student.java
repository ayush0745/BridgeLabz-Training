import java.util.Scanner;

class Student {
    String name;
    String rollNumber;
    double[] marks; // Array to store marks

    // Constructor
    public Student(String name, String rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade based on average marks
    public String calculateGrade() {
        double total = 0;
        for (double m : marks) {
            total += m;
        }
        double average = total / marks.length;

        if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 50) return "C";
        else return "D";
    }

    // Method to display details
    public void displayReport() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Mark" + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Grade " + calculateGrade());
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        // for Student 1
        double[] marks1 = {80.0, 70.0, 75.0};
        Student s1 = new Student("Thamarai", "ECE001", marks1);

        //for Student 2
        double[] marks2 = {60.0, 65.0, 50.0};
        Student s2 = new Student("Kannan", "CSC002", marks2);

        // Displaying Reports
        s1.displayReport();
        s2.displayReport();
    }
}