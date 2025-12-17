import java.util.Scanner;

public class Fibbonaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibbi(n));
    }

    public static int fibbi(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibbi(n - 1) + fibbi(n - 2);
    }
}