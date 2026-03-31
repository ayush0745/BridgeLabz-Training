import java.util.Scanner;
// level 1 control flow problem
public class NaturalSumComparison {
    public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);
        
   
        int n = scanner.nextInt();

        // Check if the number is actually a natural number 
        if (n <= 0) {
            System.out.println("That's not a natural number! Please try again with a number > 0.");
        } 
        else {
            
            //  Calculate the sum manually using a loop
          
            int loopSum = 0;
            int currentNumber = 1;
            
            while (currentNumber <= n) {
                loopSum += currentNumber; 
                currentNumber++;          
            }

            //  Calculate the sum using the famous math shortcut
            
            int formulaSum = n * (n + 1) / 2;

         
            System.out.println("Result from the loop: " + loopSum);
            System.out.println("Result from the math formula: " + formulaSum);

            
            if (loopSum == formulaSum) {
                System.out.println("Both methods match perfectly.");
            } else {
                System.out.println("The results are different.");
            }
        }
        
        scanner.close();
    }
}