import java.util.Scanner;

public class ArrayException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //  Define an array 
        System.out.print("How many names do you want to enter? ");
        int size = sc.nextInt();
        String[] names = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        generateException(names);

        // Call the method that handles the exception
        System.out.println(" Handling Exception ");
        handleException(names);
    }

   
    public static void generateException(String[] names) {
        int badIndex = names.length + 5; 
        System.out.println("Accessing index " + badIndex + ": " + names[badIndex]);
    }

   
    public static void handleException(String[] names) {
        try {
            int badIndex = names.length + 5;
            System.out.println("Attempting to access index " + badIndex + "...");
            System.out.println(names[badIndex]);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: That index is outside the array limits!");
        } 
        catch (RuntimeException e) {
            System.out.println("Error: A general runtime problem occurred.");
        }
    }
}