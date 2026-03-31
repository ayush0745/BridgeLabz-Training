// Base Class
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayBasicInfo() {
        System.out.println("Name: " + name + " | Age: " + age);
    }
}

// Subclass Teacher
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Role: Teacher (Subject: " + subject + ")");
    }
}

// Subclass Student
class Student extends Person {
    int gradeLevel;

    Student(String name, int age, int gradeLevel) {
        super(name, age);
        this.gradeLevel = gradeLevel;
    }

    void displayRole() {
        System.out.println("Role: Student (Grade: " + gradeLevel + ")");
    }
}

// Subclass Staff
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Role: Staff (Department: " + department + ")");
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Teacher prof = new Teacher("Mr. Smith", 45, "Physics");
        Student stud = new Student("Alice", 16, 11);
        Staff admin = new Staff("Mrs. Jones", 50, "Registrar");

        prof.displayBasicInfo();
        prof.displayRole();

        System.out.println(); 

        stud.displayBasicInfo();
        stud.displayRole();
    }
}