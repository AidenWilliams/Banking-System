package Users;
import Accounts.Account;

public interface Basic {
    //TODO: Add javadoc

    /**
     *
     * @param beneficiaries
     * @param accountNumber
     * @param availableBalance
     * @param currency
     * @return
     */
    int createNewAccount(User[] beneficiaries, String accountNumber, double availableBalance, String currency);
    int createNewAccount(User[] beneficiaries, String accountNumber, String currency);
    int addCard(String accountNumber);
    int removeCard(String accountNumber);
    int closeAccount(String accountNumber);
    int deleteAccount(String accountNumber);
    int transferToAccount(String accountFrom, String accountTo, double amount);
    void viewBalance();
    void viewBalance(String account);
    void viewTransactions(User user);
    void viewTransactions(User user, String accountNumber);
}