public class BankTransfer implements TransferService {

    // Bank transfer with extra charges
    @Override
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        double fee = 10;
        from.withdrawMoney(amount + fee);
        to.addMoney(amount);
    }
}
