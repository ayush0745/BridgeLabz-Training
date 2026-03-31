import java.util.Scanner;

// program to find how many times each digit appears in a number
public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        // count digits to set array size
      // for negative inputs
        long temp = Math.abs(number); 
        int count = 0;
        if (temp == 0) count = 1;
        
        long countTemp = temp;
        while (countTemp > 0) {
            countTemp /= 10;
            count++;
        }

        // store digits in an array
        int[] digitsArr = new int[count];
        long storeTemp = temp;
        for (int i = 0; i < count; i++) {
            digitsArr[i] = (int)(storeTemp % 10);
            storeTemp /= 10;
        }

        //create frequency array
        int[] freq = new int[10];
        
        // loop 
        for (int i = 0; i < count; i++) {
            int digit = digitsArr[i];
            freq[digit]++; 
        }

        // display results
    
        for (int i = 0; i < 10; i++) {
            // only print digits that appeared at least once
            if (freq[i] > 0) {
                System.out.println("Digit " + i + " appears " + freq[i] + " times");
            }
        }

        scanner.close();
    }
}