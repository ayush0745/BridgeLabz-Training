import java.util.Scanner;

public class ElectionBoothManager {

    // Declare candidates as static so the recordVote method can access them
    static int cand1 = 0;
    static int cand2 = 0;
    static int cand3 = 0;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int exitCode = 57;
        int input = 0;
        
    
        System.out.println("(Enter " + exitCode + " at any time to close voting and see results)");

        // Loop until exit code is entered
        while (true) {
            System.out.print("\nEnter your age (or " + exitCode + " to exit): ");
            input = scanner.nextInt();
            
            // Check for exit code immediately
            if (input == exitCode) {
                break;
            }
            
            if (input >= 18) {
                System.out.println("Enter 1 for Cand1, 2 for Cand2, 3 for Cand3:");
                int voteChoice = scanner.nextInt();
                
                if (voteChoice >= 1 && voteChoice <= 3) {
                    recordVote(voteChoice);
                    System.out.println("Vote recorded successfully!");
                } else {
                    System.out.println("Invalid candidate.");
                }
            } else {
                System.out.println("You are not eligible to vote.");
            }
        }
        
        // Display Results
        System.out.println("\n Final Results ");
        System.out.println("Cand1: " + cand1 + " | Cand2: " + cand2 + " | Cand3: " + cand3);

        if (cand1 > cand2 && cand1 > cand3) {
            System.out.println("Winner: Candidate 1");
        } else if (cand2 > cand1 && cand2 > cand3) {
            System.out.println("Winner: Candidate 2");
        } else if (cand3 > cand1 && cand3 > cand2) {
            System.out.println("Winner: Candidate 3");
        } else {
            System.out.println("It's a tie!");
        }
        
        scanner.close();
    }
    
    public static void recordVote(int vote) {
        if (vote == 1) cand1++;
        else if (vote == 2) cand2++;
        else if (vote == 3) cand3++;
    }
}