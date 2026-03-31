import java.util.Scanner;

public class PerimeterOfRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = scanner.nextDouble();
        double breadth = scanner.nextDouble();
        double perimeter = 2 * (length + breadth);
        System.out.println("Perimeter of Rectangle is: " + perimeter);
    }

}
