import java.util.Scanner;

public class OperationOnTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input coordinates
        System.out.println("Enter coordinates for Point A (x1, y1):");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.println("Enter coordinates for Point B (x2, y2):");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.println("Enter coordinates for Point C (x3, y3):");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        System.out.println(" Collinearity Results");

        //Slope Formula
        boolean slopeResult = checkCollinearBySlope(x1, y1, x2, y2, x3, y3);
        System.out.println("Using Slope Formula: " + (slopeResult ? "Collinear" : "Not Collinear"));

        //Area Formula
        boolean areaResult = checkCollinearByArea(x1, y1, x2, y2, x3, y3);
        System.out.println("Using Area Formula: " + (areaResult ? "Collinear" : "Not Collinear"));

        sc.close();
    }

    public static boolean checkCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
      
        
        double slopeAB_num = (y2 - y1) * (x3 - x2);
        double slopeBC_num = (y3 - y2) * (x2 - x1);
        double slopeAC_num = (y3 - y1) * (x2 - x1);
        double slopeAB_num2 = (y2 - y1) * (x3 - x1);

      
        double mAB = (y2 - y1) / (x2 - x1);
        double mBC = (y3 - y2) / (x3 - x2);
        double mAC = (y3 - y1) / (x3 - x1);

        return (mAB == mBC) && (mBC == mAC);
    }

    
    public static boolean checkCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        // Using Math.abs to ensure positive area comparison
        return Math.abs(area) == 0;
    }
}