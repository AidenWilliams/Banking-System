package Users;

import Accounts.Account;

import java.util.ArrayList;

public class Administrator extends User implements Worker{
    /**
     * <p>
     * Constructor method to create a new User, all variables declared above must be initialised in order to create
     * a new User.
     * </p>
     *
     * @param id          Id of the User. Could be id card or passport number
     * @param name        Name of the User.
     * @param surname     Surname of the User.
     * @param addresses   Array of the user addresses, Must have at least 1.
     * @param DOB         Date of Birth of the user.
     * @param email       Email of the user.
     * @param phoneNumber Phone of the user.
     */
    //TODO: Add javadoc
    public Administrator(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }

    @Override
    public User createUser(String name, String surname, String[] addresses, String DOB, String email, String phoneNumber) {
        return null;
    }

    @Override
    public User deleteUser(String id) {
        return null;
    }

    @Override
    public void viewJobs() {

    }

    @Override
    public Account createNewAccount(User[] beneficiaries, String accountNumber, double availableBalance, String currency) {
        return null;
    }

    @Override
    public Account createNewAccount(User[] beneficiaries, String accountNumber, String currency) {
        return null;
    }

    @Override
    public void closeAccount(User user) {

    }

    @Override
    public void deleteAccount(String accountNumber) {

    }

    @Override
    public void transferToAccount(User user, String accountFrom, String accountTo, double amount) {

    }

    @Override
    public void viewBalance(User user) {

    }

    @Override
    public void viewBalance(String account) {

    }

    @Override
    public void viewTransactions(User user) {

    }

    @Override
    public void viewTransactions(User user, String accountNumber) {

    }

    @Override
    public void addCard(User user, String accountNumber) {

    }

    @Override
    public void removeCard(User user, String accountNumber) {

    }

    //TODO: Add implementation of interfaces

}
