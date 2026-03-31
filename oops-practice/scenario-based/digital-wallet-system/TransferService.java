public interface TransferService {

    // Transfer funds
    void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException;
}
