public class OnlinePay {
    public static void main(String[] args) {

        User u1 = new User(1, "Ayush");
        User u2 = new User(2, "Rahul");

        Wallet w1 = new Wallet(u1);
        Wallet w2 = new Wallet(u2);

        w1.addMoney(1000);

        TransferService walletTransfer = new WalletToWalletTransfer();
        TransferService bankTransfer = new BankTransfer();

        try {
            walletTransfer.transfer(w1, w2, 300);
            bankTransfer.transfer(w1, w2, 200);

            System.out.println("Wallet 1 Balance: ₹" + w1.balance);
            System.out.println("Wallet 2 Balance: ₹" + w2.balance);

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
