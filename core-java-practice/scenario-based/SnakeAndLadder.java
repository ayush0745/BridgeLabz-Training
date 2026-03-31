import java.util.Random;

public class SnakeAndLadder {
    // Constants for game options
    public static final int NO_PLAY = 0;
    public static final int LADDER = 1;
    public static final int SNAKE = 2;
    public static final int WINNING_POSITION = 100;

    public static void main(String[] args) {
        int player1Position = 0; // UC 1 
        int player2Position = 0;
        int diceRollCount = 0;
        boolean isPlayer1Turn = true;
        Random random = new Random();

        System.out.println("Starting Snake and Ladder Game with 2 Players");

        // UC 4: Repeat till a player reaches 100 
        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            String currentPlayerName = isPlayer1Turn ? "Player 1" : "Player 2";
            int currentPosition = isPlayer1Turn ? player1Position : player2Position;

            // UC 2: Roll the die
            int dieRoll = random.nextInt(6) + 1;
            diceRollCount++;
            
            // UC 3: Check for options  
            int option = random.nextInt(3);
            boolean extraTurn = false;

            switch (option) {
                case NO_PLAY: // UC 3
                    break;
                case LADDER: // UC 3
                    // UC 5: Ensure exact winning position 
                    if (currentPosition + dieRoll <= WINNING_POSITION) {
                        currentPosition += dieRoll;
                    }
                    // UC 7: If player gets a Ladder, they play again 
                    extraTurn = true;
                    break;
                case SNAKE: // UC 3
                    currentPosition -= dieRoll;
                    // UC 4: If position < 0, restart from 0 
                    if (currentPosition < 0) {
                        currentPosition = 0;
                    }
                    break;
            }

            // UC 6: Report position after every die roll 
            if (isPlayer1Turn) {
                player1Position = currentPosition;
                System.out.println("Dice Roll #" + diceRollCount + " | " + currentPlayerName + " moved to: " + player1Position);
            } else {
                player2Position = currentPosition;
                System.out.println("Dice Roll #" + diceRollCount + " | " + currentPlayerName + " moved to: " + player2Position);
            }

            // UC 7: Switch turns unless a ladder was hit 
            if (!extraTurn) {
                isPlayer1Turn = !isPlayer1Turn;
            } else if (currentPosition < WINNING_POSITION) {
                System.out.println(currentPlayerName + " hit a Ladder! Rolling again...");
            }
        }

        // UC 7: Report the winner 
        System.out.println("------------------------------------");
        if (player1Position == WINNING_POSITION) {
            System.out.println("PLAYER 1 WINS!");
        } else {
            System.out.println("PLAYER 2 WINS!");
        }
        
        // UC 6: Report total dice rolls 
        System.out.println("Total Dice Rolls: " + diceRollCount);
    }
}