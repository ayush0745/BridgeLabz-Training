import java.util.Scanner;

public class Bmi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        double[][] teamData = new double[10][3];

        //Take user input
        for (int i = 0; i < 10; i++) {
            System.out.println("Member " + (i + 1) + ":");
            System.out.print("  Enter weight (kg): ");
            teamData[i][0] = sc.nextDouble();
            System.out.print("  Enter height (cm): ");
            teamData[i][1] = sc.nextDouble();
        }

        // Calculate BMI 
        calculateBmi(teamData);

        //  Determine status for each person
        String[] statuses = determineStatus(teamData);

        //  Display Results
        System.out.printf("%n%-10s %-10s %-10s %-10s %-15s%n", 
                          "Member", "Weight", "Height", "BMI", "Status");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-15s%n", 
                              (i + 1), teamData[i][0], teamData[i][1], teamData[i][2], statuses[i]);
        }
        
        sc.close();
    }

    // Calculates BMI 
    public static void calculateBmi(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100.0; // Convert cm to m
            data[i][2] = weight / (heightInMeters * heightInMeters);
        }
    }

    public static String[] determineStatus(double[][] data) {
        String[] results = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                results[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                results[i] = "Normal weight";
            } else if (bmi >= 25.0 && bmi < 29.9) {
                results[i] = "Overweight";
            } else {
                results[i] = "Obese";
            }
        }
        return results;
    }
}