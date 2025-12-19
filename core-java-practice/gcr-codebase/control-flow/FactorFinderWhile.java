import java.util.Scanner;
//level 2 control flow problem

public class FactorFinderWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (number > 0) {
            int counter = 1;
            System.out.print("Factors are: ");
            
            
            while (counter <= number) {
                if (number % counter == 0) {
                    System.out.print(counter + " ");
                }
                counter++; 
            }
            System.out.println();
         } 
         else {
            System.out.println("Please enter a positive integer.");
         }
        
        scanner.close();
    }
}
           

           
