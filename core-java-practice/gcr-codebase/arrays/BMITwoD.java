import java.util.Scanner;

// program to manage team bmi data using a 2d array for numbers
public class BMITwoD{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int num = scanner.nextInt();

        // 2D array define
        double[][] personData = new double[num][3];
        String[] weightStatus = new String[num];

        // collect and calculate data for each person
        for (int i = 0; i < num; i++) {
            System.out.println("\nRecording data for person " + (i + 1));
            
            // get weight with positive value check
            while (true) {
                System.out.print("Weight (kg): ");
                personData[i][0] = scanner.nextDouble();
                if (personData[i][0] > 0) break;
                System.out.println("Please enter a positive value.");
            }

            // get height with positive value check
            while (true) {
                System.out.print("Height (cm): ");
                personData[i][1] = scanner.nextDouble();
                if (personData[i][1] > 0) break;
                System.out.println("Please enter a positive value.");
            }

            // math for bmi 
            double m = personData[i][1] / 100.0;
            personData[i][2] = personData[i][0] / (m * m);

            // logic to determine weight
            double currentBMI = personData[i][2];
            if (currentBMI < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (currentBMI <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (currentBMI <= 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

     // display results 
       
        for (int i = 0; i < num; i++) {
            int id = i + 1;
            double weight = personData[i][0];
            double height = personData[i][1];
            double bmi = personData[i][2];
            String status = weightStatus[i];

           
            System.out.println("Person #" + id + ": BMI = " + bmi + " (" + status + ")");
        }
        scanner.close();
    }
}