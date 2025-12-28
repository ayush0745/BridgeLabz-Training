import java.util.Scanner;

public class GCDAndLCM {

   
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findLCM(int a, int b, int gcd) {
        if (a == 0 || b == 0) return 0;
        
        return Math.abs(a * b) / gcd;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        int gcd = findGCD(num1, num2);
        int lcm = findLCM(num1, num2, gcd);

      
        System.out.println("GCD: " + gcd);
        System.out.println("LCM:   " + lcm);
       

        scanner.close();
    }
}