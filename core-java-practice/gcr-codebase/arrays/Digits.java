import java.util.Scanner;

// program to store digits in an array and find the two largest values
public class Digits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
      // using long for larger numbers
        long number = scanner.nextLong(); 
        
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // loop to extract digits until number is 0
        while (number != 0) {
            // break if we hit the array limit
            if (index == maxDigit) {
                break;
            }

            // get the last digit and add to array
            int lastDigit = (int)(number % 10);
            digits[index] = lastDigit;
            
            index++;
         // remove the last digit
            number = number / 10; 
        }

        int largest = 0;
        int secondLargest = 0;

        //  find the top two
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                // current largest becomes second largest
                secondLargest = largest;
                largest = digits[i];
            } 
            else if (digits[i] > secondLargest && digits[i] != largest) {
                // update second largest if current digit is between the two
                secondLargest = digits[i];
            }
        }

        // display the results
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        scanner.close();
    }
}