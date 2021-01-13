package Old.Users;

public interface Basic {
    String viewBalance();
    String viewBalance(String account);
    void viewTransactions(User user);
    void viewTransactions(User user, String accountNumber);
}
