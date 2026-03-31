class BankAccount {
    // Access modifiers
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    // Constructor
    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public methods to access and modify private balance
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

// Subclass 
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, String accountHolder,
                   double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);  
        System.out.println("Account Holder: " + accountHolder);   
        System.out.println("Balance: " + getBalance());          
        System.out.println("Interest Rate: " + interestRate);
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(
                "ACC12345", "Ayush", 10000.0, 4.5);

        sa.displayAccountDetails();

        sa.deposit(2000);
        sa.withdraw(1500);

        System.out.println("Updated Balance: " + sa.getBalance());
    }
}
