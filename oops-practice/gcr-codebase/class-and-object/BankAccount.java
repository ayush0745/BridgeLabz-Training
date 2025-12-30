import java.util.Scanner;

class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Method to withdraw money 
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Method to display current balance
    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {
       
        BankAccount myAccount = new BankAccount("State of Chennai", "CH001", 700.0);

        System.out.println("\t\t" + myAccount.accountHolder);
        
        // Initial balance
        myAccount.displayBalance();

        //Deposit
        myAccount.deposit(200.0);
        myAccount.displayBalance();

        //Withdrawal
        myAccount.withdraw(100.0);
        myAccount.displayBalance();

        // Attempting to withdraw more than the current balance 
        myAccount.withdraw(1000.0);
    }
}