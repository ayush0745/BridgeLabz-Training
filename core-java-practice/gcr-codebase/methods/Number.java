import java.util.Scanner;

// programm to find smallest and largest
public class Number {
	//method to find smallest and largest
	public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        // Find the smallest
        int smallest = Math.min(number1, Math.min(number2, number3));
        
        // Find the largest
        int largest = Math.max(number1, Math.max(number2, number3));
        
        return new int[]{smallest, largest};
    }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter number 1:");
		int num1 = scanner.nextInt();
		System.out.println("enter number 2:");
		int num2 = scanner.nextInt();
		System.out.println("enter number 3:");
		int num3 = scanner.nextInt();
		
		//call the method
		int[] result = findSmallestAndLargest(num1, num2, num3);
		
		//Display results
        System.out.println("Results:");
        System.out.println("Smallest: " + result[0]);
        System.out.println("Largest: " + result[1]);
        
        scanner.close();
	}
}
