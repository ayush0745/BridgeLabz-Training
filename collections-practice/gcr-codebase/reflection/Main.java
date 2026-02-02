import java.lang.reflect.Field;

class Person {
    // Private field
    private int age;

    // Constructor
    public Person(int age) {
        this.age = age;
    }

    // Public method to display age
    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Create a Person object
            Person person = new Person(25);

            // Display original age
            person.displayAge();

            // Get the Class object
            Class<?> personClass = person.getClass();

            // Access the private field 'age'
            Field ageField = personClass.getDeclaredField("age");

            // Make it accessible
            ageField.setAccessible(true);

            // Get current value using reflection
            int currentAge = (int) ageField.get(person);
            System.out.println("Current age (via reflection): " + currentAge);

            // Modify the private field
            ageField.set(person, 35);

            // Display modified age
            System.out.println("Modified age (via reflection): " + ageField.get(person));
            person.displayAge();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
