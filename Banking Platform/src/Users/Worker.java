package Users;

public interface Worker extends Basic{
    /*
    @Override
    void createNewAccount(User[] beneficiaries, String accountNumber, float availableBalance, String currency);
    void createNewAccount(User[] beneficiaries, String accountNumber, String currency);
    void closeAccount(User user);
    void deleteAccount(String accountNumber);
    void transferToAccount(User user, String accountFrom, String accountTo, float amount);
    void viewBalance(User user);
    void viewBalance(String account);
    void viewTransactions(User user);
    void viewTransactions(User user, String accountNumber);
    void addCard(User user, String accountNumber);
    void removeCard(User user, String accountNumber);
     */
    User createUser(String name, String surname, String[] addresses, String DOB, String email, String phoneNumber);
    User deleteUser(String name, String surname, String[] addresses, String DOB, String email, String phoneNumber);
}
