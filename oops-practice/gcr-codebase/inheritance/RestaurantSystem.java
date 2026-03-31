//The Superclass
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayIdentity() {
        System.out.println("ID: " + id + " | Name: " + name);
    }
}

//The Interface
interface Worker {
    void performDuties(); 
}

//Subclass Chef (Inherits Person AND Implements Worker)
class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing " + specialty + " in the kitchen.");
    }
}

//Subclass Waiter (Inherits Person AND Implements Worker)
class Waiter extends Person implements Worker {
    int assignedTables;

    Waiter(String name, int id, int assignedTables) {
        super(name, id);
        this.assignedTables = assignedTables;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + assignedTables + " tables in the dining area.");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        Chef headChef = new Chef("Marco", 101, "Italian Cuisine");
        Waiter leadWaiter = new Waiter("Sarah", 202, 5);

        // Accessing methods from Superclass
        headChef.displayIdentity();
        // Accessing methods from Interface
        headChef.performDuties();

        System.out.println("---------------------------");

        leadWaiter.displayIdentity();
        leadWaiter.performDuties();
    }
}