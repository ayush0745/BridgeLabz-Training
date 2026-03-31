import java.util.Scanner;

// reverse a number by swapping digit positions in arrays
public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        long num = scanner.nextLong();
        
        //count digits to set array size
        int count = 0;
        long tempNum = num;
        while (tempNum != 0) {
            tempNum /= 10;
            count++;
        }

        //store digits in the first array
        int[] digits = new int[count];
        tempNum = num;
        for (int i = 0; i < count; i++) {
            digits[i] = (int)(tempNum % 10);
            tempNum /= 10;
        }

        //create a second array for the reverse order
        int[] reversed = new int[count];
        for (int i = 0; i < count; i++) {
            
            reversed[i] = digits[count - 1 - i];
        }

        // display the reversed array
        System.out.print("Reversed digits: ");
        for (int val : reversed) {
            System.out.print(val);
        }
        System.out.println();

        scanner.close();
    }
}