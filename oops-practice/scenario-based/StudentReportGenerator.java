import java.util.ArrayList;
import java.util.List;

// Custom Exception
class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

// Student Class
class Student {
    private String name;
    private String[] subjects;
    private int[] marks;

    public Student(String name, String[] subjects, int[] marks)
            throws InvalidMarkException {

        if (subjects.length != marks.length) {
            throw new InvalidMarkException("Subjects and marks count mismatch.");
        }

        this.name = name;
        this.subjects = subjects;
        this.marks = marks;

        validateMarks();
    }

    // Validate marks
    private void validateMarks() throws InvalidMarkException {
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException(
                    "Invalid mark found: " + mark + " (Marks must be 0–100)"
                );
            }
        }
    }

    // Calculate average
    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / (double) marks.length;
    }

    // Assign grade
    public String getGrade() {
        double avg = calculateAverage();

        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else return "Fail";
    }

    // Display report card
    public void displayReport() {
        System.out.println("================================");
        System.out.println("Student Name : " + name);
        System.out.println("--------------------------------");

        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-10s : %3d%n", subjects[i], marks[i]);
        }

        System.out.println("--------------------------------");
        System.out.printf("Average     : %.2f%n", calculateAverage());
        System.out.println("Grade       : " + getGrade());
        System.out.println("================================\n");
    }
}

// Main Class
public class StudentReportGenerator {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        String[] subjects = {"Maths", "Science", "English", "History"};

        try {
            students.add(
                new Student(
                    "Ayush",
                    subjects,
                    new int[]{85, 90, 78, 88}
                )
            );

            students.add(
                new Student(
                    "Ravi",
                    subjects,
                    new int[]{72, 65, 70, 68}
                )
            );

            students.add(
                new Student(
                    "InvalidStudent",
                    subjects,
                    new int[]{95, 105, 80, 70} // Invalid mark
                )
            );

        } catch (InvalidMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display all student reports
        for (Student s : students) {
            s.displayReport();
        }
    }
}
