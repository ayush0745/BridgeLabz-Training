import java.util.Scanner;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check: ");
        int inputNumber = sc.nextInt();

        // Get count of digits
        int count = countDigits(inputNumber);
        System.out.println("Digit Count: " + count);

        // Store digits in array
        int[] digits = getDigitsArray(inputNumber);
        System.out.print("Digits Array: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();

        //  Duck Number Check
        System.out.println("Is Duck Number? " + isDuckNumber(digits));

        //  Armstrong Number Check
        System.out.println("Is Armstrong Number? " + isArmstrongNumber(inputNumber, digits));

        //  Largest and Second Largest
        int[] largestPair = findLargestAndSecond(digits);
        System.out.println("Largest: " + largestPair[0] + ", Second Largest: " + largestPair[1]);

        //  Smallest and Second Smallest
        int[] smallestPair = findSmallestAndSecond(digits);
        System.out.println("Smallest: " + smallestPair[0] + ", Second Smallest: " + smallestPair[1]);

        sc.close();
    }

    
    public static int countDigits(int num) {
        if (num == 0) return 1;
        return String.valueOf(Math.abs(num)).length();
    }

    public static int[] getDigitsArray(int num) {
        String s = String.valueOf(Math.abs(num));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
      
        for (int d : digits) {
            if (d == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrongNumber(int originalNum, int[] digits) {
        
        double sum = 0;
        int power = digits.length;
        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return (int) sum == originalNum;
    }

    public static int[] findLargestAndSecond(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[]{largest, secondLargest};
    }

    public static int[] findSmallestAndSecond(int[] digits) {
        
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[]{smallest, secondSmallest};
    }
}