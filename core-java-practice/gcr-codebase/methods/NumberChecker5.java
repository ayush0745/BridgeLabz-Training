import java.util.Scanner;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to analyze: ");
        int n = sc.nextInt();

        System.out.println("\n--- Divisor Analysis ---");
        System.out.println("Is Perfect?   : " + isPerfect(n));
        System.out.println("Is Abundant?  : " + isAbundant(n));
        System.out.println("Is Deficient? : " + isDeficient(n));

        System.out.println("\n--- Digit Analysis ---");
        System.out.println("Is Strong?    : " + isStrong(n));

        sc.close();
    }

    public static int sumOfProperDivisors(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

   
    public static boolean isPerfect(int num) {
        return num > 0 && sumOfProperDivisors(num) == num;
    }

    public static boolean isAbundant(int num) {
        return num > 0 && sumOfProperDivisors(num) > num;
    }

  
    public static boolean isDeficient(int num) {
        return num > 0 && sumOfProperDivisors(num) < num;
    }

   
    public static boolean isStrong(int num) {
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return sum == num;
    }

    // method to calculate factorial of a digit.
    
    public static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }
        return fact;
    }
}