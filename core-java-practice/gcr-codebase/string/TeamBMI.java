import java.util.Scanner;

public class TeamBMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int teamSize = 10;
        
        // Array to store weight and height 
        double[][] measurements = new double[teamSize][2];

        System.out.println("Enter data for " + teamSize + " team members:");
        for (int i = 0; i < teamSize; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.print("Weight (kg): ");
            measurements[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            measurements[i][1] = sc.nextDouble();
        }

        // Generate the report
        String[][] bmiReport = processTeamData(measurements);

        // Display results
        displayReport(bmiReport);
        
        sc.close();
    }

    //  Logic to find BMI and Status for an individual
    public static String[] calculateIndividualBMI(double weight, double heightCm) {
        // Convert height cm to meters
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        
        // Determine status
        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal weight";
        else if (bmi <= 29.9) status = "Overweight";
        else status = "Obese";

        // Return BMI and Status as strings 
        return new String[]{String.format("%.2f", bmi), status};
    }

    //  Process the whole team and store in a 2D String array
    public static String[][] processTeamData(double[][] data) {
        String[][] report = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1];
            
       
            String[] result = calculateIndividualBMI(weight, height);

            report[i][0] = String.valueOf(height);
            report[i][1] = String.valueOf(weight);
            report[i][2] = result[0]; // BMI
            report[i][3] = result[1]; // Status
        }
        return report;
    }

    //  Display the data in a simple tabular format
    public static void displayReport(String[][] report) {
        System.out.println("\nHeight(cm)  Weight(kg)  BMI     Status");
    
        for (int i = 0; i < report.length; i++) {
            System.out.println(report[i][0] + "       " + 
                               report[i][1] + "       " + 
                               report[i][2] + "    " + 
                               report[i][3]);
        }
    }
}