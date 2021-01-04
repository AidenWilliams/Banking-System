package Users;

import Accounts.Account;

import java.util.ArrayList;

public class Regular extends User implements Worker{
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
    Regular(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
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
    public int createNewAccount(User[] beneficiaries, String accountNumber, double availableBalance, String currency) {
        return 1;
    }

    @Override
    public int createNewAccount(User[] beneficiaries, String accountNumber, String currency) {
        return 1;
    }

    @Override
    public int closeAccount(String accountNumber) {
        return 1;

    }

    @Override
    public int deleteAccount(String accountNumber) {
        return 1;

    }

    @Override
    public int transferToAccount(String accountFrom, String accountTo, double amount) {
        return 1;

    }

    @Override
    public int addCard(String accountNumber) {
        return 1;

    }

    @Override
    public int removeCard(String accountNumber) {
        return 1;
    }

    @Override
    public void viewBalance() {

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

    //TODO: Add implementation of interfaces
}
