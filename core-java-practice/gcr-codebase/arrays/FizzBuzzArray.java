import java.util.Scanner;

// program to solve fizzbuzz and store results in a string array
public class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int num = scanner.nextInt();

        // only proceed if it is a positive integer
        if (num > 0) {
           
            String[] results = new String[num + 1];

            // loop 
            for (int i = 0; i <= num; i++) {
                // check multiples of both 3 and 5 first
                if (i != 0 && i % 3 == 0 && i % 5 == 0) {
                    results[i] = "FizzBuzz";
                } 
                else if (i != 0 && i % 3 == 0) {
                    results[i] = "Fizz";
                } 
                else if (i != 0 && i % 5 == 0) {
                    results[i] = "Buzz";
                } 
                else {
                    // convert the integer to a string for the array
                    results[i] = String.valueOf(i);
                }
            }

            // results
            for (int i = 0; i <= num; i++) {
                System.out.println("Position " + i + " = " + results[i]);
            }

        } else {
            System.out.println("Please enter a number greater than 0.");
        }

        scanner.close();
    }
}