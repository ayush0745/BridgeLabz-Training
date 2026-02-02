// This program shows how to create an object dynamically without using the new keyword.
import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int rollNo;

    public Student() {
        this.name = "Default Student";
        this.rollNo = 0;
    }

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', rollNo=" + rollNo + "}";
    }
}

public class StudentReflection {
    public static void main(String[] args) throws Exception {
        Class<?> studentClass = Class.forName("Student");

        Constructor<?> defaultCtor = studentClass.getDeclaredConstructor();
        Object defaultStudent = defaultCtor.newInstance();
        System.out.println("Created via reflection (default): " + defaultStudent);

        Constructor<?> paramCtor = studentClass.getDeclaredConstructor(String.class, int.class);
        Object customStudent = paramCtor.newInstance("Alice", 101);
        System.out.println("Created via reflection (parameterized): " + customStudent);
    }
}


