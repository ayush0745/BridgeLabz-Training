public class WalletToWalletTransfer implements TransferService {

    // Wallet to wallet transfer logic
    @Override
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        from.withdrawMoney(amount);
        to.addMoney(amount);
    }
}
