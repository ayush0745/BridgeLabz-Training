import java.util.Scanner;
// level 1 control flow problem
public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a Natural Number .");
        } else {
            // 1. Compute using for loop
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }

            // 2. Compute using formula
            int formulaSum = n * (n + 1) / 2;

            System.out.println("Sum using for loop: " + loopSum);
            System.out.println("Sum using formula: " + formulaSum);

            if (loopSum == formulaSum) {
                System.out.println("Both results match!");
            }
        }
    }
}