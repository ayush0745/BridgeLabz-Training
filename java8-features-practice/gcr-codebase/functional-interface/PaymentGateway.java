public class PaymentGateway {

    // Interface with default refund method
    interface PaymentProcessor {

        void pay(double amount);

        // New feature added without breaking old implementations
        default void refund(double amount) {
            System.out.println("Refund of ₹" + amount + " processed (default)");
        }
    }

    // Existing provider: UPI
    static class UPIProcessor implements PaymentProcessor {
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using UPI");
        }
        // refund() inherited automatically
    }

    // Existing provider: Credit Card
    static class CreditCardProcessor implements PaymentProcessor {
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card");
        }
        // refund() inherited automatically
    }

    // New provider overriding refund behavior
    static class WalletProcessor implements PaymentProcessor {
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Wallet");
        }

        @Override
        public void refund(double amount) {
            System.out.println("Refund of ₹" + amount + " sent to Wallet");
        }
    }

    // Main method
    public static void main(String[] args) {

        PaymentProcessor upi = new UPIProcessor();
        PaymentProcessor card = new CreditCardProcessor();
        PaymentProcessor wallet = new WalletProcessor();

        upi.pay(1000);
        upi.refund(200);

        card.pay(500);
        card.refund(100);

        wallet.pay(300);
        wallet.refund(50);
    }
}
