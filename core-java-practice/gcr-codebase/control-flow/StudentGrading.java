import java.util.Scanner;

// Creating Class with name StudentGrading indicating the purpose is to 
// calculate the average score and assign a grade and remarks
public class StudentGrading {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner scanner = new Scanner(System.in);

        // Get 3 input values for subject marks
        System.out.print("Enter Physics marks: ");
        double physics = scanner.nextDouble();
        System.out.print("Enter Chemistry marks: ");
        double chemistry = scanner.nextDouble();
        System.out.print("Enter Maths marks: ");
        double maths = scanner.nextDouble();

        // Find the average percentage of the three subjects
        double average = (physics + chemistry + maths) / 3.0;

        String grade = "";
        String remarks = "";

        // Check the average against the grading scale to assign the correct grade and level
        if (average >= 80) {
            grade = "A";
            remarks = "(Level 4, above agency-normalized standards)";
        } 
        else if (average >= 70) {
            grade = "B";
            remarks = "(Level 3, at agency-normalized standards)";
        } 
        else if (average >= 60) {
            grade = "C";
            remarks = "(Level 2, below, but approaching agency-normalized standards)";
        } 
        else if (average >= 50) {
            grade = "D";
            remarks = "(Level 1, well below agency-normalized standards)";
        } 
        else if (average >= 40) {
            grade = "E";
            remarks = "(Level 1-, too below agency-normalized standards)";
        } 
        else {
            grade = "R";
            remarks = "(Remedial standards)";
        }

        // Display the calculated average and the final grade details
        System.out.printf("Average Mark: %.2f%%\n", average);
        System.out.println("Grade       : " + grade);
        System.out.println("Remarks     : " + remarks);

        // Closing the Scanner Stream
        scanner.close();
    }
}