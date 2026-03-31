import java.util.*;

public class Student extends Person {

    private List<Course> courses = new ArrayList<>();
    private Map<String, String> grades = new HashMap<>();
    private static final int MAX_COURSES = 5;

    public Student(int id, String name) {
        super(id, name);
    }

    public void enrollCourse(Course course) throws CourseLimitExceededException {
        if (courses.size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Maximum course limit reached!");
        }
        courses.add(course);
    }

    public void dropCourse(String courseCode) {
        courses.removeIf(c -> c.getCourseCode().equals(courseCode));
        grades.remove(courseCode);
    }

    public void addGrade(String courseCode, String grade) {
        grades.put(courseCode, grade);
    }

    public void viewGrades() {
        for (Map.Entry<String, String> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void viewCourses() {
        for (Course c : courses) {
            System.out.println(c);
        }
    }
}
