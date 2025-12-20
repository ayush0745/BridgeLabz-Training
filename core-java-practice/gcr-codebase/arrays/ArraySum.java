import java.util.Scanner;

// program to collect up to 10 numbers and calculate their sum
public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // create array and a sum variable
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0; // tracking how many numbers are actually entered

        // infinite loop to get user entries
        while (true) {
            System.out.print("Enter a number : ");
            double input = scanner.nextDouble();

            // break if user enters 0 or a negative number
            if (input <= 0) {
                break;
            }

            // assign input to array 
            numbers[index] = input;
            index++;

            // stop if the array is full
            if (index == 10) {
                System.out.println("Array is full.");
                break;
            }
        }

        System.out.println("Results");
        
        //calculate the total
        for (int i = 0; i < index; i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
            total = total + numbers[i]; // add current element to total
        }

        // display the final sum
        System.out.println("Final Total: " + total);

        scanner.close();
    }
}