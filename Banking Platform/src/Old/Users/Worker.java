package Old.Users;

import Old.Accounts.Account;

import java.util.ArrayList;

public interface Worker extends Basic, BasicWorker {
    //TODO: Add javadoc
    <T> int createUser(String id, String name, String surname, ArrayList<String> addresses,
                               String DOB, String email, String phoneNumber, Class<T> tclass);
    int deleteUser(String id);
    void createNewAccount(User[] beneficiaries, String accountNumber, double availableBalance, String currency);
    void createNewAccount(User[] beneficiaries, String accountNumber, String currency);
    void addCard(User user, String validTo, String cvv, boolean virtual, short status, double limit,
                 Account account, double creditLimit, double interestRate);
    void addCard(User user, String validTo, String cvv, boolean virtual, short status, double limit,
                 Account account);
    // maybe add this to superuser
    //void setPin();
    void removeCard(String accountNumber, String cardNumber);
    void closeAccount(String accountNumber);
    void deleteAccount(String accountNumber);
    void transferToAccount(String accountFrom, String accountTo, double amount);
    void DoJob(int  id);
    //Make worker only open
    //No need to add extra to worker, possibly add more to role
}
