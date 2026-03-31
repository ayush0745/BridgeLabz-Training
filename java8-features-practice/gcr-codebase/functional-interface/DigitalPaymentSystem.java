public class DigitalPaymentSystem {

    // Interface
    interface Payment {
        void pay(double amount);
    }

    // UPI payment
    static class UPI implements Payment {
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using UPI");
        }
    }

    // Credit Card payment
    static class CreditCard implements Payment {
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card");
        }
    }

    // Wallet payment
    static class Wallet implements Payment {
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Wallet");
        }
    }

    // Main method
    public static void main(String[] args) {

        Payment upi = new UPI();
        Payment card = new CreditCard();
        Payment wallet = new Wallet();

        upi.pay(500);
        card.pay(1200);
        wallet.pay(300);
    }
}
