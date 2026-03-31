import java.util.Scanner;

public class DeckOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Initialize
        String[] deck = initializeDeck(suits, ranks);
        int n = deck.length;

        // 2. Shuffle the deck
        deck = shuffleDeck(deck, n);

        System.out.print("Enter number of players: ");
        int x = sc.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = sc.nextInt();

        String[][] players = distributeCards(deck, x, cardsPerPlayer);

        //  Print results
        if (players != null) {
            printPlayers(players);
        } else {
            System.out.println("Error: Not enough cards to distribute to " + x + " players.");
        }
        
        sc.close();
    }

    // Method to Initialize the deck
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    
    public static String[] shuffleDeck(String[] deck, int n) {
        for (int i = 0; i < n; i++) {
           
            int randomCardNumber = i + (int) (Math.random() * (n - i));

           
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }


    public static String[][] distributeCards(String[] deck, int x, int nPerPlayer) {
       
        if (x * nPerPlayer > deck.length) {
            return null;
        }

        String[][] players = new String[x][nPerPlayer];
        int deckIndex = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < nPerPlayer; j++) {
                players[i][j] = deck[deckIndex++];
            }
        }
        return players;
    }

    
    public static void printPlayers(String[][] players) {
        System.out.println(" Player Card Distribution");
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (int j = 0; j < players[i].length; j++) {
                System.out.print("[" + players[i][j] + "] ");
            }
            System.out.println();
        }
    }
}