import java.util.*;

public class LineComparison {
    
    // UC-1: Calculate length using Cartesian formula
    public Double calculateLength(double x1, double y1, double x2, double y2) {
        double diffX = x2 - x1;
        double diffY = y2 - y1;
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }
    
    // UC-2: Check equality
    public boolean areEqual(Double length1, Double length2) {
        return length1.equals(length2);
    }
    
    // UC-3: Compare lengths
    public String compareLength(Double length1, Double length2) {
        int comparison = length1.compareTo(length2);
        if (comparison > 0) {
            return "Length 1 is greater than Length 2";
        } else if (comparison < 0) {
            return "Length 1 is less than Length 2";
        } else {
            return "Length 1 is equal to Length 2";
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to Line Comparison Computation Program");
        
        // Create instance of the main class to access its methods
        LineComparison lc = new LineComparison();
        Scanner sc = new Scanner(System.in);
        
        // Input for Line 1
        System.out.println("Enter first set of coordinates (x1 y1 x2 y2):");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        
        // Input for Line 2
        System.out.println("Enter second set of coordinates (x3 y3 x4 y4):");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();
        double x4 = sc.nextDouble();
        double y4 = sc.nextDouble();
        
        Double length1 = lc.calculateLength(x1, y1, x2, y2);
        Double length2 = lc.calculateLength(x3, y3, x4, y4);
        
        System.out.println("Length 1: " + length1);
        System.out.println("Length 2: " + length2);
        
        // Comparison Logic
        if (lc.areEqual(length1, length2)) {
            System.out.println("Lengths are equal");
        } else {
            System.out.println(lc.compareLength(length1, length2));
        }
        
        sc.close(); }
}