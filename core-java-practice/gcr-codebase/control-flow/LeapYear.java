// Creating Class with name RectangleCalc to indicate the purpose is to 
// calculate geometric properties of a rectangle
import java.util.Scanner;

class RectangleCalc {
   public static void main(String[] args) {
      // Create a Scanner Object to read user input from the console
      Scanner input = new Scanner(System.in);

      // Prompt user and get input values for length and width
      System.out.print("Enter length: ");
      double length = input.nextDouble();
      
      System.out.print("Enter width: ");
      double width = input.nextDouble();

      // Calculate area (length * width) and perimeter (2 * (length + width))
      double area = length * width;
      double perimeter = 2 * (length + width);

      // Display the calculated results to the user
      System.out.println("For a rectangle with length " + length + " and width " + width + ":");
      System.out.println("The Area is: " + area);
      System.out.println("The Perimeter is: " + perimeter);

      // Closing the Scanner Stream to free up system resources
      input.close();
   }
}