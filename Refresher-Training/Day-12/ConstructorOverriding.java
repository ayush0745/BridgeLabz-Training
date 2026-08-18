class Student {
    String name;
    int age;
    String course;

    
    public Student() {
        this("Unknown", 0, "Not assigned");
    }

    public Student(String name) {
        this(name, 18, "General Studies");
    }

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        
        Student student1 = new Student();

        Student student2 = new Student("Ayush");

        Student student3 = new Student("Rahul", 21, "Computer Science");

        student1.display();
        student2.display();
        student3.display();
    }
}