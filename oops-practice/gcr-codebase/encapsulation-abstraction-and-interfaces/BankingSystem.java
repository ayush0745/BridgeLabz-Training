abstract class BankAccount {
    private String accountNumber; 
    private String holderName;
    protected double balance; 
    
    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    double getBalance() { return balance; }
    String getHolderName() { return holderName; }
    String getAccountNumber() { return accountNumber; }
    
    public void deposit(double money) {
        this.balance += money; 
        System.out.println("Deposited: " + money + " | New Balance: " + balance);
    }
    
    public void withdraw(double money) {
        if (balance >= money) {
            balance -= money; 
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println("You cannot withdraw: Insufficient funds");
        }
    }

    abstract void calculateInterest(); 
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; 

    public SavingsAccount(String accNum, String name, double bal) {
        super(accNum, name, bal);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest Added: $" + interest + " | New Balance: $" + balance);
    }

    @Override
    public void applyForLoan(double amount) {
        if(calculateLoanEligibility()) {
            System.out.println("Loan of $" + amount + " approved for " + getHolderName());
        } else {
            System.out.println("Loan denied for " + getHolderName());
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance > 5000; 
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accNum, String name, double bal) {
        super(accNum, name, bal);
    }

    @Override
    public void calculateInterest() {
        double fee = 10.0; 
        balance -= fee;
        System.out.println("Maintenance fee of $10 deducted. Balance: $" + balance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("SA101", "Alice", 6000.0),
            new CurrentAccount("CA202", "Bob's Biz", 1500.0)
        };

        for (BankAccount acc : accounts) {
            System.out.println("\n--- Processing Account: " + acc.getAccountNumber() + " ---");
            System.out.println("Holder: " + acc.getHolderName());
            acc.deposit(500);
            acc.calculateInterest(); 
            
            if (acc instanceof Loanable) {
                ((Loanable) acc).applyForLoan(2000);
            }
        }
    }
}