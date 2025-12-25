import java.util.Scanner;

public class NumberAnalyser {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        //Taking user input
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\n--- Analysis Results ---");

       
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            System.out.print("Number " + currentNum + " is ");

            if (isPositive(currentNum)) {
                String parity = isEven(currentNum) ? "Even" : "Odd";
                System.out.println("Positive and " + parity);
            } else if (currentNum == 0) {
                System.out.println("Zero (Neither positive nor negative)");
            } else {
                System.out.println("Negative");
            }
        }

        //  Compare first and last elements
        System.out.println("\n--- Comparison of First and Last ---");
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        int comparisonResult = compare(first, last);

        if (comparisonResult == 1) {
            System.out.println("First element (" + first + ") is GREATER than the last element (" + last + ")");
        } else if (comparisonResult == 0) {
            System.out.println("First element (" + first + ") is EQUAL to the last element (" + last + ")");
        } else {
            System.out.println("First element (" + first + ") is LESS than the last element (" + last + ")");
        }

        sc.close();
    }

    // Method to check if positive
    public static boolean isPositive(int num) {
        return num > 0;
    }

    // Method to check if even
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // Method to compare two numbers
    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }
}