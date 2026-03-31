// Parent class
class Animal {
    // Method in parent class
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Child class
class Dog extends Animal {
    // Overriding the makeSound method
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Main class to test
public class OverrideAnnotation {
    public static void main(String[] args) {
        // Creating an object of Dog
        Dog myDog = new Dog();

        // Calling the overridden method
        myDog.makeSound(); // Output: Woof! Woof!
    }
}
