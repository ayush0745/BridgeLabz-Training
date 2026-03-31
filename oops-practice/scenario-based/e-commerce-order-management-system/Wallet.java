class Wallet implements Payment {
    double walletBalance = 10000;

    public void pay(double amount) throws PaymentFailedException {
        if (amount > walletBalance) {
            throw new PaymentFailedException("Insufficient wallet balance");
        }
        walletBalance -= amount;
        System.out.println("Payment of " + amount + " successful using Wallet");
    }
}
