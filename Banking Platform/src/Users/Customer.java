package Users;

import Accounts.Account;
import Workflow.JobApproval;
import Workflow.JobRequest;
import Workflow.Limits;

import java.util.ArrayList;

public class Customer extends User implements Requester {
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
    public int requestCreateNewAccount(User[] beneficiaries, String accountNumber, double availableBalance, String currency) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(beneficiaries);
        jobDetails.add(accountNumber);
        jobDetails.add(availableBalance);
        jobDetails.add(currency);

        return JobRequest.AddJobRequest(jobDetails,"CreateNewAccount");
    }

    @Override
    public int requestCreateNewAccount(User[] beneficiaries, String accountNumber, String currency) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(beneficiaries);
        jobDetails.add(accountNumber);
        jobDetails.add(currency);
        return JobRequest.AddJobRequest(jobDetails, "CreateNewAccount");
    }

    @Override
    public int requestCloseAccount(String accountNumber) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(accountNumber);
        return JobRequest.AddJobRequest(jobDetails,"CloseAccount");
    }

    @Override
    public int requestDeleteAccount(String accountNumber) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(accountNumber);
        return JobRequest.AddJobRequest(jobDetails,"DeleteAccount");
    }

    @Override
    public int requestTransferToAccount(String accountFrom, String accountTo, double amount) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(accountFrom);
        jobDetails.add(accountTo);
        jobDetails.add(amount);
        JobRequest.putBalanceOnHold(accountFrom, amount);
        if(amount <= Limits.MAX_EASY_TRANSFER){
            JobApproval.ApproveJob(JobRequest.AddJobRequest(jobDetails, "Transfer"));
            return -1;
        }else{
            return JobRequest.AddJobRequest(jobDetails, "Transfer");
        }
    }

    @Override
    public int requestAddCard(String accountNumber) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(accountNumber);
        return JobRequest.AddJobRequest(jobDetails,"AddCard");
    }

    @Override
    public int requestRemoveCard(String accountNumber, String cardNumber) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(accountNumber);
        jobDetails.add(cardNumber);
        return JobRequest.AddJobRequest(jobDetails,"RemoveCard");
    }

    @Override
    public void viewBalance() {
        ArrayList<Account> accounts = JobRequest.getUserAccounts(this);
        for(Account account: accounts){
            System.out.println("Account Number");
            System.out.println(account.getNumber());
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
            if(account.getNumber().equals(accountNumber)){
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
