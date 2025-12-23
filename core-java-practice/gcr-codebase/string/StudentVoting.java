import java.util.Scanner;
import java.util.Random;

public class StudentVoting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // 1. Generate Ages
        int[] ages = generateAges(n);

        // 2. Process Eligibility
        String[][] report = checkEligibility(ages);

        // 3. Display
        displayTable(report);
    }

    // Generates random 2-digit ages
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 1; // Random age 1-90
        }
        return ages;
    }

    // Evaluates age and stores in 2D array
    public static String[][] checkEligibility(int[] ages) {
        String[][] report = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            report[i][0] = String.valueOf(ages[i]);
            
            if (ages[i] < 0) {
                report[i][1] = "false (Invalid)";
            } else if (ages[i] >= 18) {
                report[i][1] = "true";
            } else {
                report[i][1] = "false";
            }
        }
        return report;
    }

    public static void displayTable(String[][] data) {
        System.out.println("\nAge\tCan Vote");
        System.out.println("-----------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }
}