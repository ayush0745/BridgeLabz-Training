public class StudentReagistrationApp {
    public static void main(String[] args) {

        Student s1 = new Student(101, "Ayush");
        RegistrationService service = new Register();

        Course c1 = new Course("CS101", "Java Programming");
        Course c2 = new Course("CS102", "Data Structures");

        try {
            service.registerStudent(s1);
            service.enroll(s1, c1);
            service.enroll(s1, c2);

            s1.addGrade("CS101", "A");
            s1.addGrade("CS102", "B+");

            System.out.println("\nEnrolled Courses:");
            s1.viewCourses();

            System.out.println("\nGrades:");
            s1.viewGrades();

        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }
}
