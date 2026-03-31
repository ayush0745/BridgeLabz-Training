import java.util.Scanner;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int inputNumber = sc.nextInt();

        //  Digits Array
        int[] digits = getDigitsArray(inputNumber);
        System.out.println("Digit Count: " + digits.length);

        //  Sum of Digits
        int sum = findSumOfDigits(digits);
        System.out.println("Sum of Digits: " + sum);

        //Sum of Squares
        double sumSquares = findSumOfSquares(digits);
        System.out.println("Sum of Squares: " + sumSquares);

        // Harshad Number Check
        boolean isHarshad = isHarshadNumber(inputNumber, digits);
        System.out.println("Is Harshad Number? " + isHarshad);

        // Frequency of Digits
        int[][] frequencyMap = findDigitFrequency(digits);
        System.out.println("\nDigit Frequency Table:");
        System.out.println("Digit | Frequency");
        System.out.println("-----------------");
        for (int[] row : frequencyMap) {
            System.out.printf("  %d   |    %d%n", row[0], row[1]);
        }

        sc.close();
    }

    
     // Converts number to an array of its individual digits.

    public static int[] getDigitsArray(int num) {
        String s = String.valueOf(Math.abs(num));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

    // Calculates the sum of elements in the digits array.
    
    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    // Calculates the sum of squares of digits.
    
    public static double findSumOfSquares(int[] digits) {
        double sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    // A number is Harshad if: Number % (Sum of Digits) == 0.
     
    public static boolean isHarshadNumber(int num, int[] digits) {
        int sum = findSumOfDigits(digits);
        if (sum == 0) return false; // Avoid division by zero
        return num % sum == 0;
    }

  
    public static int[][] findDigitFrequency(int[] digits) {
        
        int[] counts = new int[10];
        int uniqueCount = 0;

        for (int d : digits) {
            if (counts[d] == 0) uniqueCount++;
            counts[d]++;
        }

   
        int[][] result = new int[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (counts[i] > 0) {
                result[index][0] = i;     
                result[index][1] = counts[i]; 
                index++;
            }
        }
        return result;
    }
}