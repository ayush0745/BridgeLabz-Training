public abstract class RegistrationService {
    public abstract void registerStudent(Student student);
    public abstract void enroll(Student student, Course course)
            throws CourseLimitExceededException;
}
