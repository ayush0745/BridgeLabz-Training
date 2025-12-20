import java.util.Scanner;

// program to calculate subject grades and percentages for students
public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int num = scanner.nextInt();

        // arrays for students marks
        double[][] marks = new double[num][3]; 
        double[] percentages = new double[num];
        String[] grades = new String[num];

        // collect input for each student
        for (int i = 0; i < num; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            
            // physics marks
            System.out.print("Physics: ");
            marks[i][0] = scanner.nextDouble();
            
            // chemistry marks
            System.out.print("Chemistry: ");
            marks[i][1] = scanner.nextDouble();
            
            // maths marks
            System.out.print("Maths: ");
            marks[i][2] = scanner.nextDouble();

            // validate that no marks are negative
            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Error: Marks must be positive. Try again.");
                i--; 
                continue;
            }

            // calculate percentage 
            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            // calculate grade
            double p = percentages[i];
            if (p >= 80) {
                grades[i] = "A"; 
            } else if (p >= 70) {
                grades[i] = "B"; 
            } else if (p >= 60) {
                grades[i] = "C"; 
            } else if (p >= 50) {
                grades[i] = "D"; 
            } else if (p >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R"; 
            }
        }

        // display final table
       
        System.out.printf("%-10s %-8s %-8s %-8s %-12s %-5s\n", "Student", "Phys", "Chem", "Math", "Percentage", "Grade");
        
        for (int i = 0; i < num; i++) {
            System.out.printf("%-10d %-8.1f %-8.1f %-8.1f %-12.2f %-5s\n", 
                (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }

        scanner.close();
    }
}