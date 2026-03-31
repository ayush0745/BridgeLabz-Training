import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many games would you like to play? ");
        int totalGames = sc.nextInt();

        // 2D array to store results
        String[][] gameHistory = new String[totalGames][3];
        int userWins = 0;
        int compWins = 0;

        for (int i = 0; i < totalGames; i++) {
            
            System.out.print("Enter (Rock, Paper, or Scissors): ");
            String userChoice = sc.next();
            
            String compChoice = getComputerChoice();
            String winner = findWinner(userChoice, compChoice);

            // Store data
            gameHistory[i][0] = userChoice;
            gameHistory[i][1] = compChoice;
            gameHistory[i][2] = winner;

            if (winner.equalsIgnoreCase("User")) userWins++;
            else if (winner.equalsIgnoreCase("Computer")) compWins++;
        }

        // Generate Stats and Display
        String[][] stats = calculateStats(userWins, compWins, totalGames);
        displayResults(gameHistory, stats);
    }

    
    public static String getComputerChoice() {
        int rand = (int) (Math.random() * 3); // Generates 0, 1, or 2
        if (rand == 0) return "Rock";
        if (rand == 1) return "Paper";
        return "Scissors";
    }

    //  Logic to find the winner
    public static String findWinner(String user, String comp) {
        if (user.equalsIgnoreCase(comp)) return "Tie";
        
        // Winning conditions for User
        if ((user.equalsIgnoreCase("Rock") && comp.equalsIgnoreCase("Scissors")) ||
            (user.equalsIgnoreCase("Paper") && comp.equalsIgnoreCase("Rock")) ||
            (user.equalsIgnoreCase("Scissors") && comp.equalsIgnoreCase("Paper"))) {
            return "User";
        }
        return "Computer";
    }

    // Calculate stats and return as 2D String array
    public static String[][] calculateStats(int uWin, int cWin, int total) {
        String[][] stats = new String[2][2]; 
        
        double uPct = ((double) uWin / total) * 100;
        double cPct = ((double) cWin / total) * 100;

        stats[0][0] = String.valueOf(uWin);
        stats[0][1] = String.valueOf(uPct) + "%";
        
        stats[1][0] = String.valueOf(cWin);
        stats[1][1] = String.valueOf(cPct) + "%";

        return stats;
    }

    // Display tabular results
    public static void displayResults(String[][] history, String[][] stats) {
       
        for (int i = 0; i < history.length; i++) {
            System.out.println((i + 1) + "  " + history[i][0] + "  " + history[i][1] + "  " + history[i][2]);
        }

        
        System.out.println("Player\t\tWins\tPercentage");
     
        System.out.println("User\t\t" + stats[0][0] + "\t" + stats[0][1]);
        System.out.println("Computer\t" + stats[1][0] + "\t" + stats[1][1]);
    }
}