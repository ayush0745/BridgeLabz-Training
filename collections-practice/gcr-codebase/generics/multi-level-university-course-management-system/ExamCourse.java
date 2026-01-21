class ExamCourse extends CourseType {

    public ExamCourse() {
        super("Written Exam");
    }

    @Override
    public String getType() {
        return "Exam-Based Course";
    }
}
