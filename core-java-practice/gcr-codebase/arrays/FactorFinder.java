import java.util.Scanner;

// find factors 
public class FactorFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to find factors: ");
        int num = scanner.nextInt();

        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // loop 
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                
                // if array is full, we need more space
                if (index == maxFactor) {
                    maxFactor = maxFactor * 2; // double the size
                    int[] temp = new int[maxFactor];
                    
                    // copy old elements to the new temp array
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp; 
                }

                // store the factor
                factors[index] = i;
                index++;
            }
        }

        // display all stored factors
        System.out.print("Factors of " + num + " are: ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        scanner.close();
    }
}