import java.util.Scanner;
//level 2 control flow problem
public class GreatestFactorFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an number: ");
        int number = scanner.nextInt();
        int greatestFactor = 1;
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break; 
            }
        }
        System.out.println("The greatest factor  is: " + greatestFactor);
        scanner.close();
    }
}

        
      
       