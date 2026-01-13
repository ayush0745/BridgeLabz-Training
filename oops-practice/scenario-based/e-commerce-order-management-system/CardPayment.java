class CardPayment implements Payment {
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 50000000) {
            throw new PaymentFailedException("Card limit exceeded");
        }
        System.out.println("Payment of " + amount + " successful using Card");
    }
}
