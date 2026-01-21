class AssignmentCourse extends CourseType {

    public AssignmentCourse() {
        super("Assignments");
    }

    @Override
    public String getType() {
        return "Assignment-Based Course";
    }
}
