import java.util.List;

class CourseUtils {

    public static void displayCourses(List<? extends CourseType> courseTypes) {
        for (CourseType type : courseTypes) {
            System.out.println(
                type.getType() + " | Evaluation: " + type.getEvaluationMethod()
            );
        }
    }
}
