import java.util.Scanner;

public class NumberException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter some text : ");
        String userInput = sc.next();

      
       
        handleException(userInput);
        
        System.out.println("Program continues running...");
    }

    // Method to generate the Exception
    public static void generateException(String text) {
        System.out.println("Attempting to convert without try-catch...");
        int number = Integer.parseInt(text); 
        System.out.println("Converted number: " + number);
    }

    // Method to handle the Exception
    public static void handleException(String text) {
        try {
            System.out.println("Attempting to convert inside try-catch...");
            int number = Integer.parseInt(text);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: The text '" + text + "' is not a valid number!");
        } catch (RuntimeException e) {
            System.out.println("A general runtime error occurred.");
        }
    }
}