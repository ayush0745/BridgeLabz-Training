
import java.util.Scanner;
// level 1 control flow problem
public class FactorialUsingFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number ");
        int num = sc.nextInt();

        if (num < 1) {
            System.out.println("Please enter a natural number ");
        } else {
            long factorial = 1;
            for (int i = 1; i <= num; i++) {
                factorial *= i;
            }
            System.out.println("The factorial of " + num + " is " + factorial);
        }
        sc.close();
    }
}