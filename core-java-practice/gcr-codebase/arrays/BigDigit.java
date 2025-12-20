import java.util.Scanner;

// program to find top two digits using a resizing array
public class BigDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        long originalNumber = number; 
        
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // extract every digit
        while (number != 0) {
            // if array is full, increase size by 10
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                
                // copy old data to new larger array
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }
                digits = temp; 
            }

            digits[index] = (int)(number % 10);
            index++;
            number /= 10;
        }

        int largest = -1;
        int secondLargest = -1;

        // find the two biggest digits
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
        
        scanner.close();
    }
}