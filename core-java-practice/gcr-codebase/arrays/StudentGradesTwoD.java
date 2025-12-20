import java.util.Scanner;

// program to handle student marks in a 2D array and compute grades
public class StudentGradesTwoD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int num = scanner.nextInt();

       
        double[][] subjectMarks = new double[num][3];
        double[] percentages = new double[num];
        String[] grades = new String[num];

        // collect marks for each student
        for (int i = 0; i < num; i++) {
            System.out.println("\nEnter marks for student " + (i + 1) + ":");
            
            // taking input for three subjects
            System.out.print("Physics: ");
            subjectMarks[i][0] = scanner.nextDouble();
            System.out.print("Chemistry: ");
            subjectMarks[i][1] = scanner.nextDouble();
            System.out.print("Maths: ");
            subjectMarks[i][2] = scanner.nextDouble();

            // check for negative marks
            if (subjectMarks[i][0] < 0 || subjectMarks[i][1] < 0 || subjectMarks[i][2] < 0) {
                System.out.println("Invalid marks. Please enter positive values.");
                i--; 
                continue;
            }

            // compute percentage 
            double total = subjectMarks[i][0] + subjectMarks[i][1] + subjectMarks[i][2];
            percentages[i] = total / 3.0;

            // determine grade based on the percentage
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

        // output results 
        System.out.println("Results");
        System.out.printf("%-10s %-8s %-8s %-8s %-12s %-6s\n", "Student", "Phys", "Chem", "Math", "Percent", "Grade");

        for (int i = 0; i < num; i++) {
           
            System.out.printf("%-10d %-8.1f %-8.1f %-8.1f %-12.2f %-6s\n", 
                (i + 1), subjectMarks[i][0], subjectMarks[i][1], subjectMarks[i][2], percentages[i], grades[i]);
        }

        scanner.close();
    }
}