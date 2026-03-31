import java.util.Scanner;

public class StudentVoteChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();
        
        // Define an array of 10 integer elements
        int[] studentAges = new int[10];

        System.out.println("--- Student Voting Eligibility Checker ---");

        // take user input
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            studentAges[i] = sc.nextInt();
        }

        System.out.println("\n Results");
        // display results
        for (int i = 0; i < studentAges.length; i++) {
            boolean canVote = checker.canStudentVote(studentAges[i]);
            String status = canVote ? "CAN VOTE" : "CANNOT VOTE";
            System.out.println("Student " + (i + 1) + " (Age: " + studentAges[i] + "): " + status);
        }

        sc.close();
    }

   
    public boolean canStudentVote(int age) {
        //check for negative number
        if (age < 0) {
            return false;
        }
        
        // Check for age 18 or above
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }
}