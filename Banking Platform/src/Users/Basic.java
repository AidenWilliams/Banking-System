package Users;

public interface Basic {
    void viewBalance();
    void viewBalance(String account);
    void viewTransactions(User user);
    void viewTransactions(User user, String accountNumber);
}
