import java.util.Scanner;

public class NumberChecker4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check: ");
        int n = sc.nextInt();

        System.out.println("\n--- Analysis Results ---");
        System.out.println("Is Prime?       : " + isPrime(n));
        System.out.println("Is Neon?        : " + isNeon(n));
        System.out.println("Is Spy?         : " + isSpy(n));
        System.out.println("Is Automorphic? : " + isAutomorphic(n));
        System.out.println("Is Buzz?        : " + isBuzz(n));

        sc.close();
    }


    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

   
    public static boolean isNeon(int num) {
        int square = num * num;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }

    
    public static boolean isSpy(int num) {
        int sum = 0;
        int product = 1;
        int temp = Math.abs(num);
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    
    public static boolean isAutomorphic(int num) {
        int square = num * num;
        String sNum = Integer.toString(num);
        String sSquare = Integer.toString(square);
        return sSquare.endsWith(sNum);
    }

   
    public static boolean isBuzz(int num) {
        return (num % 7 == 0) || (num % 10 == 7);
    }
}