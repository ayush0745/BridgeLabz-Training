import java.util.Scanner;
//level 2 control flow problem

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an number: ");
        int number = scanner.nextInt();
        int greatestFactor = 1;
        int counter = number - 1;
        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break; 
            }
            counter--; 
        }

        System.out.println("The greatest factor  is: " + greatestFactor);
        scanner.close();
    }
}
      
      
