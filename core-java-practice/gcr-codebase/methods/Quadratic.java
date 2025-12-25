import java.util.Scanner;

public class Quadratic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Equation format: ax^2 + bx + c = 0");
        System.out.print("Enter value for a: ");
        double a = sc.nextDouble();
        System.out.print("Enter value for b: ");
        double b = sc.nextDouble();
        System.out.print("Enter value for c: ");
        double c = sc.nextDouble();

        double[] roots = findRoots(a, b, c);

        // Display results
        if (roots.length == 0) {
            System.out.println("The equation has no real roots .");
        }
        else if (roots.length == 1) {
            System.out.printf("The equation has one real root: %.2f%n", roots[0]);
        }
        else {
            System.out.printf("The equation has two roots:%nRoot 1: %.2f%nRoot 2: %.2f%n", roots[0], roots[1]);
        }

        sc.close();
    }

    // Calculates the roots of a quadratic equation.
   
    public static double[] findRoots(double a, double b, double c) {
        // Calculate delta using Math.pow()
        // Formula: b^2 - 4ac
        double delta = Math.pow(b, 2) - (4 * a * c);

        // Check delta conditions
        if (delta > 0) {
            // Two real roots
            double sqrtDelta = Math.sqrt(delta);
            double root1 = (-b + sqrtDelta) / (2 * a);
            double root2 = (-b - sqrtDelta) / (2 * a);
            return new double[]{root1, root2};
            
        } else if (delta == 0) {
            // One real root
            double root = -b / (2 * a);
            return new double[]{root};
            
        } else {
            //  No real roots
            return new double[]{}; 
        }
    }
}