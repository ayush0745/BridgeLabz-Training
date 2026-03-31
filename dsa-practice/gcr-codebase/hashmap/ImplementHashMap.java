public class ImplementHashMap {

    // Node class for Linked List
    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Node[] table;

    // Constructor
    public ImplementHashMap(int capacity) {
        this.capacity = capacity;
        table = new Node[capacity];
    }

    // Hash function
    private int hash(int key) {
        return key % capacity;
    }

    // Insert or Update
    public void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];

        // Check if key already exists
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value; // update
                return;
            }
            current = current.next;
        }

        // Insert new node at head
        Node newNode = new Node(key, value);
        newNode.next = head;
        table[index] = newNode;
    }

    // Retrieve value
    public Integer get(int key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return null; // key not found
    }

    // Remove key
    public boolean remove(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    // Display HashMap
    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Node current = table[i];
            while (current != null) {
                System.out.print("[" + current.key + "=" + current.value + "] -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    // Main method
    public static void main(String[] args) {

        ImplementHashMap map = new ImplementHashMap(5);

        map.put(1, 10);
        map.put(6, 20); // collision with key 1
        map.put(11, 30); // collision with key 1 & 6
        map.put(2, 40);

        System.out.println("HashMap contents:");
        map.display();

        System.out.println("\nGet key 6: " + map.get(6));
        System.out.println("Remove key 1: " + map.remove(1));
        System.out.println("Get key 1: " + map.get(1));

        System.out.println("\nHashMap after deletion:");
        map.display();
    }
}
