import java.util.*;

public class AddToNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int sum = num1 + num2;
        System.out.println(num1 + num2 + "=" + sum);
    }
}