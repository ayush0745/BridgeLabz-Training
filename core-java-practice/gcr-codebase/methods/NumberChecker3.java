import java.util.Scanner;

public class NumberChecker3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int inputNumber = sc.nextInt();

        // Get Digits Array
        int[] originalDigits = getDigitsArray(inputNumber);
        System.out.println("Digit Count: " + originalDigits.length);

        // Reverse the Array
        int[] reversedDigits = reverseArray(originalDigits);
        System.out.print("Reversed Digits: ");
        for (int d : reversedDigits) System.out.print(d + " ");
        System.out.println();

        //Palindrome Check
        boolean isPal = isPalindrome(inputNumber);
        System.out.println("Is Palindrome? " + isPal);

        //Duck Number Check
        boolean isDuck = isDuckNumber(originalDigits);
        System.out.println("Is Duck Number? " + isDuck);

        sc.close();
    }

 
    public static int[] getDigitsArray(int num) {
        String s = String.valueOf(Math.abs(num));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

     // Method to reverse the digits array.
     
    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays and check if they are equal.
    
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    // Checks if a number is a palindrome using array logic.
     
    public static boolean isPalindrome(int num) {
        int[] original = getDigitsArray(num);
        int[] reversed = reverseArray(original);
        return compareArrays(original, reversed);
    }

    // A duck number is a number that contains at least one zero.
     
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0) return true;
        }
        return false;
    }
}