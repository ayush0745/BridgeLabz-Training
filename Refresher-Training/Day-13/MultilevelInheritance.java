class Animal {

    void eat() {
        System.out.println("Animal eats");
    }
}

class Mammal extends Animal {

    void walk() {
        System.out.println("Mammal walks");
    }
}

class Dog extends Mammal {

    void bark() {
        System.out.println("Dog barks");
    }
}

class Puppy extends Dog {

    void play() {
        System.out.println("Puppy plays");
    }
}

public class Main {

    public static void main(String[] args) {

        Puppy p = new Puppy();

        p.eat();   
        p.walk();  
        p.bark();  
        p.play();    
 }
}