class Course {
    
    String courseName;
    int duration;      
    double fee;

    
    static String instituteName = "ABC Institute";

    // Parameterized constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
        System.out.println("-------------------------");
    }

    //method to update institute name
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 8, 5000);
        Course c2 = new Course("Web Development", 10, 7000);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        // Update institute name for all courses
        Course.updateInstituteName("java learning center");

        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
