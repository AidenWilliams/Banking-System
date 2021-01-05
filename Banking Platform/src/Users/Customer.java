package Users;

import Accounts.Account;
import Workflow.JobRequest;
import Workflow.Limits;

import java.util.ArrayList;

public class Customer extends User implements Basic{
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
    public Customer(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }

    @Override
    public int createNewAccount(User[] beneficiaries, String accountNumber, double availableBalance, String currency) {
        Account account = new Account(beneficiaries, accountNumber, availableBalance, currency);
        return JobRequest.AddJobRequest(account,"CreateNewAccount");
    }

    @Override
    public int createNewAccount(User[] beneficiaries, String accountNumber, String currency) {
        Account account = new Account(beneficiaries, accountNumber, 0, currency);
        return JobRequest.AddJobRequest(account,"CreateNewAccount");
    }

    @Override
    public int closeAccount(String accountNumber) {
        return JobRequest.AddJobRequest(accountNumber,"CloseAccount");
    }

    @Override
    public int deleteAccount(String accountNumber) {
        return JobRequest.AddJobRequest(accountNumber,"DeleteAccount");
    }

    @Override
    public int transferToAccount(String accountFrom, String accountTo, double amount) {
        return JobRequest.AddJobRequest(accountFrom,  accountTo,  amount, "Transfer");
    }

    @Override
    public int addCard(String accountNumber) {
        return JobRequest.AddJobRequest(accountNumber,"AddCard");
    }

    @Override
    public int removeCard(String accountNumber) {
        return JobRequest.AddJobRequest(accountNumber,"RemoveCard");
    }

    @Override
    public void viewBalance() {
        ArrayList<Account> accounts = JobRequest.getUserAccounts(this);
        for(Account account: accounts){
            System.out.println("Account Number");
            System.out.println(account.getAccountNumber());
            System.out.println("Available Balance");
            System.out.println(account.getAvailableBalance());
            System.out.println("Balance On Hold");
            System.out.println(account.getBalanceOnHold());
        }
    }

    @Override
    public void viewBalance(String accountNumber) {
        ArrayList<Account> accounts = JobRequest.getUserAccounts(this);
        for(Account account: accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                System.out.println("Available Balance");
                System.out.println(account.getAvailableBalance());
                System.out.println("Balance On Hold");
                System.out.println(account.getBalanceOnHold());
                return;
            }
        }
    }

    @Override
    public void viewTransactions(User user) {

    }

    @Override
    public void viewTransactions(User user, String accountNumber) {

    }

    //TODO: Do Transactions
}
