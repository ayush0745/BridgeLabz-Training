import java.util.Scanner;

public class RandomGuessingGame {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Number Guessing Game");
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("Provide feedback: 'high' if my guess is too high, 'low' if too low, or 'correct'.");

        playGame();
    }

 
    public static void playGame() {
        int low = 1;
        int high = 100;
        boolean guessedCorrectly = false;

        while (!guessedCorrectly) {
            
            int guess = generateRandomGuess(low, high);
            
            String feedback = receiveFeedback(guess);

            if (feedback.equals("correct")) {
                System.out.println("I knew it! Great game.");
                guessedCorrectly = true;
            } else if (feedback.equals("high")) {
                
                high = guess - 1;
            } else if (feedback.equals("low")) {
                
                low = guess + 1;
            } else {
                System.out.println("Please enter 'high', 'low', or 'correct'.");
            }

        
            if (low > high) {
                System.out.println("I think there's a mistake! No numbers are left in that range.");
                break;
            }
        }
    }

  
    public static int generateRandomGuess(int low, int high) {
       
        return (int) (Math.random() * (high - low + 1)) + low;
    }

 6
    public static String receiveFeedback(int guess) {
        System.out.print("My guess is " + guess + ". Is it (high/low/correct)? ");
        return scanner.next().toLowerCase();
    }
}