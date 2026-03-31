import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int base = scanner.nextInt();

        int exponent = scanner.nextInt();
        // used power method of Math class to calculate power
        double result = Math.pow(base, exponent);
        System.out.println(result);

        scanner.close();
    }
}