class BankAccount {

    // Fields / Properties
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw method 
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    // Check balance method
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

// Main class to test BankAccount
public class BankAccountManager {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC12345", 5000);

        account.checkBalance();
        account.deposit(2000);
        account.withdraw(3000);
        account.withdraw(5000); // overdraft attempt
        account.checkBalance();
    }
}
