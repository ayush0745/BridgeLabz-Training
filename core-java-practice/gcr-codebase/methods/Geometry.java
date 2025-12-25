import java.util.Scanner;

public class Geometry{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input coordinates for two points
        System.out.println("Enter coordinates for Point 1 (x1, y1):");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.println("Enter coordinates for Point 2 (x2, y2):");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        //Calculate Distance
        double distance = calculateDistance(x1, y1, x2, y2);

        //Calculate Line Equation 
        double[] lineParams = findLineEquation(x1, y1, x2, y2);

        //Display Results
        System.out.println("\n Geometric Analysis");
        System.out.printf("Euclidean Distance: %.4f%n", distance);
        
        if (lineParams == null) {
            System.out.println("Line Equation: x = " + x1 );
        } else {
            double m = lineParams[0];
            double b = lineParams[1];
            System.out.printf("Slope (m): %.4f%n", m);
            System.out.printf("Y-Intercept (b): %.4f%n", b);
            System.out.printf("Equation: y = %.2fx + %.2f%n", m, b);
        }

        sc.close();
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double xDiff = Math.pow((x2 - x1), 2);
        double yDiff = Math.pow((y2 - y1), 2);
        return Math.sqrt(xDiff + yDiff);
    }

   
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        // Check for vertical line to avoid division by zero
        if (x1 == x2) {
            return null;
        }

        // Calculate slope: m = (y2 - y1) / (x2 - x1)
        double m = (y2 - y1) / (x2 - x1);

        // Calculate y-intercept: b = y1 - m * x1
        double b = y1 - (m * x1);

        return new double[]{m, b};
    }
}