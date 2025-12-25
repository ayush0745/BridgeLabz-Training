import java.util.Scanner;

public class HandshakeCalculator {

    // Method to calculate the maximum number of handshakes
    public static int calculateHandshakes(int n) {
              return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // enter Number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        // Calculate using the method
        int totalHandshakes = calculateHandshakes(numberOfStudents);

        // Output the result
        System.out.println("The maximum number of possible handshakes among " 
                           + numberOfStudents + " students is: " + totalHandshakes);

        input.close();
    }
}