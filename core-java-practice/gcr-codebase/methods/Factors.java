import java.util.Scanner;

public class Factors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find its factors: ");
        int num = sc.nextInt();

        //Get Factors Array
        int[] factors = findFactors(num);

        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println();

        // Perform Calculations
        System.out.println("Greatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors: " + findSumOfFactors(factors));
        System.out.println("Product of Factors: " + findProductOfFactors(factors));
        System.out.println("Product of Cubes of Factors: " + findProductOfCubes(factors));

        sc.close();
    }

   
     //find factors using loop
    public static int[] findFactors(int num) {
       
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }

        // Second loop to store factors
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }
     
   // Returns the greatest factor  
    public static int findGreatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors) {
            if (f > max) max = f;
        }
        return max;
    }
    
   // Calculates the sum of all elements in the factors array.
    public static long findSumOfFactors(int[] factors) {
        long sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    //Calculates the product of all elements in the factors array.
     public static double findProductOfFactors(int[] factors) {
        double product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }
     
   // Calculates the product of the cubes of each factor.
    public static double findProductOfCubes(int[] factors) {
        double product = 1;
        for (int f : factors) {
            product *= Math.pow(f, 3);
        }
        return product;
    }
}