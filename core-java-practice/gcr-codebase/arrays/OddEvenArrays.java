import java.util.Scanner;

// program to split numbers into odd and even arrays
public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        // check if it is a positive number
        if (number <= 0) {
            System.out.println("Error: Not a natural number.");
            return; // exit the program
        }

        // size is number/2 + 1 
        int[] evenArr = new int[number / 2 + 1];
        int[] oddArr = new int[number / 2 + 1];
        
        int evenIndex = 0;
        int oddIndex = 0;

        // loop 
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                // save even numbers
                evenArr[evenIndex] = i;
                evenIndex++;
            } else {
                // save odd numbers
                oddArr[oddIndex] = i;
                oddIndex++;
            }
        }

        // print even numbers 
        System.out.print("Even numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenArr[i] + " ");
        }

        // print odd numbers 
        System.out.print("\nOdd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddArr[i] + " ");
        }

        scanner.close();
    }
}