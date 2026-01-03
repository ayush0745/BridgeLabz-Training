// Base Class
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

//Savings Account
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance); // Calls parent constructor
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

//Checking Account
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

//Fixed Deposit Account
class FixedDepositAccount extends BankAccount {
    int tenureMonths;

    FixedDepositAccount(String accountNumber, double balance, int tenureMonths) {
        super(accountNumber, balance);
        this.tenureMonths = tenureMonths;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit");
        System.out.println("Tenure: " + tenureMonths + " months");
    }
}

public class BankAccountTypes{
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SAV-001", 1200.50, 4.5);
        CheckingAccount ca = new CheckingAccount("CHK-999", 3000.00, 500.00);

        sa.displayInfo();
        sa.displayAccountType();
        
        System.out.println("---------------------------");

        ca.displayInfo();
        ca.displayAccountType();
    }
}