import java.util.*;

public class Wallet {
    User user;
    double balance = 0;
    List<Transaction> transactions = new ArrayList<>();

    // Create wallet for user
    public Wallet(User user) {
        this.user = user;
    }

    // Add money to wallet
    public void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("CREDIT", amount));
    }

    // Withdraw money from wallet
    public void withdrawMoney(double amount)
            throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactions.add(new Transaction("DEBIT", amount));
    }
}
