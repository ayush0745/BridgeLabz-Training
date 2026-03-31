import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private String grade;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}

public class GroupByGrade {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Aman", "A"),
            new Student("Riya", "B"),
            new Student("Karan", "A"),
            new Student("Neha", "C"),
            new Student("Vikas", "B")
        );

        // Group by grade and collect student names
        Map<String, List<String>> groupedStudents =
            students.stream()
                    .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())
                    ));

        // Print result
        groupedStudents.forEach((grade, names) ->
            System.out.println("Grade " + grade + ": " + names)
        );
    }
}
