import java.util.*;

class Student implements Comparable<Student> {

    int score;

    Student(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student other) {
        return this.score - other.score;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }
}

public class GenericInterface {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(80));
        studentList.add(new Student(50));
        studentList.add(new Student(90));
        studentList.add(new Student(70));

        Collections.sort(studentList);

        System.out.println(studentList);
    }
}