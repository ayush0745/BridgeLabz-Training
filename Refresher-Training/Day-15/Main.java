interface Animal {

   
    int MAX_AGE = 20;

    void eat();
}

interface Pet extends Animal {

    void play();
}

class Dog implements Pet {

    @Override
    public void eat() {
        System.out.println("Eating");
    }

    @Override
    public void play() {
        System.out.println("Playing, max age is " + MAX_AGE);
    }

    void showMaxAge() {
        System.out.println("Dog method: " + MAX_AGE);
    }
}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.eat();
        dog.play();


        System.out.println("Animal.MAX_AGE: " + Animal.MAX_AGE);

        dog.showMaxAge();
    }
}