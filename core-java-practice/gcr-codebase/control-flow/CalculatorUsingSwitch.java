import java.util.Scanner;

// Creating Class with name CalculatorUsingSwitch indicating the purpose is to 
// perform basic arithmetic operations using a switch case statement
public class CalculatorUsingSwitch {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Get input values for the two numbers and the operator
        System.out.print("Enter first number: ");
        double first = input.nextDouble();
        
        System.out.print("Enter second number: ");
        double second = input.nextDouble();
        
        System.out.print("Enter an operator: ");
        String op = input.next();

        // Based on the input value of the op, perform specific operations
        switch (op) {
            
            // If op is +, perform addition between first and second
            case "+":
                System.out.println(first + " + " + second + " = " + (first + second));
                break;

            // If op is -, perform subtraction between first and second
            case "-":
                System.out.println(first + " - " + second + " = " + (first - second));
                break;

            // If op is *, perform multiplication between first and second
            case "*":
                System.out.println(first + " * " + second + " = " + (first * second));
                break;

            // If op is /, perform division between first and second
            case "/":
                // Check if the second number is not zero before dividing
                if (second != 0) {
                    System.out.println(first + " / " + second + " = " + (first / second));
                } else {
                    System.out.println("Error! Division by zero.");
                }
                break;

            // If op is neither of those 4 values, print Invalid Operator
            default:
                System.out.println("Invalid Operator");
        }

        // Closing the Scanner Stream
        input.close();
    }
}