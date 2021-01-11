package Users;

import java.util.ArrayList;

public interface Worker extends Basic, BasicWorker {
    //TODO: Add javadoc
    <T> int createUser(String id, String name, String surname, ArrayList<String> addresses,
                               String DOB, String email, String phoneNumber, Class<T> tclass);
    int deleteUser(String id);
    void createNewAccount(User[] beneficiaries, String accountNumber, double availableBalance, String currency);
    void createNewAccount(User[] beneficiaries, String accountNumber, String currency);
    void addCard(String accountNumber);
    void removeCard(String accountNumber, String cardNumber);
    void closeAccount(String accountNumber);
    void deleteAccount(String accountNumber);
    void transferToAccount(String accountFrom, String accountTo, double amount);
    void DoJob(int  id);
    //Make worker only open
    //No need to add extra to worker, possibly add more to role
}
