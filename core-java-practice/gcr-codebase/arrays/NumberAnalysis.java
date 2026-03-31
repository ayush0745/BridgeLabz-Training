import java.util.Scanner;

// Creating Class with name NumberAnalysis indicating the purpose is to 
// analyze five numbers and compare the first and last elements
public class NumberAnalysis {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Define an integer array of 5 elements 
        int[] numbers = new int[5];

        // take user input to store in the array
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        System.out.println("\n--- Analysis of Numbers ---");

        // Loop through the array using the length property
        for (int i = 0; i < numbers.length; i++) {
            
            // If the number is positive, check for even or odd numbers
            if (numbers[i] > 0) {
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is Positive and Even");
                } 
                else {
                    System.out.println(numbers[i] + " is Positive and Odd");
                }
            } 
            // If the number is negative, print negative
            else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is Negative");
            } 
            // Else if the number is zero, print zero
            else {
                System.out.println(numbers[i] + " is Zero");
            }
        }

        System.out.println("Comparing First and Last Elements");

        // Finally compare the first and last element of the array
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        if (first == last) {
            // Display if they are equal
            System.out.println("The first and last elements are equal (" + first + ").");
        } else if (first > last) {
            // Display if the first is greater than the last
            System.out.println("The first element (" + first + ") is greater than the last element (" + last + ").");
        } else {
            // Display if the first is less than the last
            System.out.println("The first element (" + first + ") is less than the last element (" + last + ").");
        }

        // Closing the Scanner Stream
        input.close();
    }
}