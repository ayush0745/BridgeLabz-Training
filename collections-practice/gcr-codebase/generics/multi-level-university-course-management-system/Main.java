import java.util.List;

public class Main {
    public static void main(String[] args) {

        Course<ExamCourse> math =
            new Course<>("Mathematics", "Science", new ExamCourse());

        Course<AssignmentCourse> cs =
            new Course<>("Data Structures", "Computer Science", new AssignmentCourse());

        Course<ResearchCourse> phd =
            new Course<>("AI Research", "Engineering", new ResearchCourse());

        List<CourseType> courseTypes = List.of(
            math.getCourseType(),
            cs.getCourseType(),
            phd.getCourseType()
        );

        CourseUtils.displayCourses(courseTypes);
    }
}
