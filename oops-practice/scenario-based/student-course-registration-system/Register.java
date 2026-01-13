public class Register extends RegistrationService {

    @Override
    public void registerStudent(Student student) {
        System.out.println("Student Registered: " + student.name);
    }

    @Override
    public void enroll(Student student, Course course)
            throws CourseLimitExceededException {
        student.enrollCourse(course);
        System.out.println("Enrolled in: " + course.getCourseName());
    }
}
