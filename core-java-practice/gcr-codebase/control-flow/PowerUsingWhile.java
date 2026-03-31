import java.util.Scanner;
//level 2 control flow problem

public class PowerUsingWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();

        System.out.print("Enter the power: ");
        int power = scanner.nextInt();

        long result = 1;
        int counter = 0;

       
        while (counter < power) {
            result = result * number;
            counter++;
        }

        System.out.println(number + " to the power of " + power + " is: " + result);
        scanner.close();
    }
}