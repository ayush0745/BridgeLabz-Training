class MathUtility {

    // Method to calculate factorial
    public static long factorial(int n) {
        if (n < 0) {
            return -1; // invalid for negative numbers
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to find GCD using Euclidean Algorithm
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to find nth Fibonacci number
    public static int fibonacci(int n) {
        if (n < 0) {
            return -1; // invalid
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

// Test class
public class MathsTest {
    public static void main(String[] args) {

        // Factorial tests
        System.out.println("Factorial(5): " + MathUtility.factorial(5));
        System.out.println("Factorial(0): " + MathUtility.factorial(0));
        System.out.println("Factorial(-3): " + MathUtility.factorial(-3));

        // Prime tests
        System.out.println("IsPrime(7): " + MathUtility.isPrime(7));
        System.out.println("IsPrime(1): " + MathUtility.isPrime(1));
        System.out.println("IsPrime(-5): " + MathUtility.isPrime(-5));

        // GCD tests
        System.out.println("GCD(20, 30): " + MathUtility.gcd(20, 30));
        System.out.println("GCD(0, 10): " + MathUtility.gcd(0, 10));
        System.out.println("GCD(-8, 12): " + MathUtility.gcd(-8, 12));

        // Fibonacci tests
        System.out.println("Fibonacci(7): " + MathUtility.fibonacci(7));
        System.out.println("Fibonacci(0): " + MathUtility.fibonacci(0));
        System.out.println("Fibonacci(-4): " + MathUtility.fibonacci(-4));
    }
}
