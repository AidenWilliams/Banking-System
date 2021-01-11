package Users;

import Accounts.Account;
import Accounts.Card;
import Accounts.CreditCard;
import Accounts.DebitCard;
import Workflow.Action;
import Workflow.Job;
import Workflow.JobRequest;
import Workflow.Limits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Regular(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }

    static <T> List<T> filter(Class<T> clazz, List<?> items) {
        return items.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    @Override
    public void DoJob(int JobID){
        Job job = Action.approvedJobs.get(JobID);

        Action.completedJobs.add(job);
        Action.approvedJobs.remove(JobID);

        switch (job.getDescription()) {
            case "CreateNewAccount":
                if (job.getDetails().size() == 4) {
                    User[] beneficiaries = filter(User[].class, job.getDetails()).get(0);
                    String accountNumber = filter(String.class, job.getDetails()).get(0);
                    Double availableBalance = filter(Double.class, job.getDetails()).get(0);
                    String currency = filter(String.class, job.getDetails()).get(1);
                    createNewAccount(beneficiaries, accountNumber, availableBalance, currency);
                } else if (job.getDetails().size() == 3) {
                    User[] beneficiaries = filter(User[].class, job.getDetails()).get(0);
                    String accountNumber = filter(String.class, job.getDetails()).get(0);
                    String currency = filter(String.class, job.getDetails()).get(1);
                    createNewAccount(beneficiaries, accountNumber, currency);
                } else {
                    //error
                }
                break;
            case "CloseAccount": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                closeAccount(accountNumber);
                break;
            }
            case "DeleteAccount": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                deleteAccount(accountNumber);
                break;
            }
            case "Transfer": {
                User[] beneficiaries = filter(User[].class, job.getDetails()).get(0);
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                String currency = filter(String.class, job.getDetails()).get(1);
                createNewAccount(beneficiaries, accountNumber, currency);
                break;
            }
            case "AddCard": {//fix
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                //addCard(accountNumber);
                break;
            }
            case "RemoveCard": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                String cardNumber = filter(String.class, job.getDetails()).get(1);
                removeCard(accountNumber, cardNumber);
                break;
            }
            case "CreateNewUser": {
                String id = filter(String.class, job.getDetails()).get(0);
                String name = filter(String.class, job.getDetails()).get(1);
                String surname = filter(String.class, job.getDetails()).get(2);
                //Check if this works
                ArrayList<String> addresses = filter(ArrayList.class, job.getDetails()).get(0);
                String DOB = filter(String.class, job.getDetails()).get(3);
                String email = filter(String.class, job.getDetails()).get(4);
                String phoneNumber = filter(String.class, job.getDetails()).get(5);
                createUser(id, name, surname, addresses, DOB, email, phoneNumber);
                break;
            }
            case "CreateNewCustomer": {
                String id = filter(String.class, job.getDetails()).get(0);
                String name = filter(String.class, job.getDetails()).get(1);
                String surname = filter(String.class, job.getDetails()).get(2);
                //Check if this works
                ArrayList<String> addresses = filter(ArrayList.class, job.getDetails()).get(0);
                String DOB = filter(String.class, job.getDetails()).get(3);
                String email = filter(String.class, job.getDetails()).get(4);
                String phoneNumber = filter(String.class, job.getDetails()).get(5);
                createCustomer(id, name, surname, addresses, DOB, email, phoneNumber);
                break;
            }
            case "CreateNewRegular": {
                String id = filter(String.class, job.getDetails()).get(0);
                String name = filter(String.class, job.getDetails()).get(1);
                String surname = filter(String.class, job.getDetails()).get(2);
                //Check if this works
                ArrayList<String> addresses = filter(ArrayList.class, job.getDetails()).get(0);
                String DOB = filter(String.class, job.getDetails()).get(3);
                String email = filter(String.class, job.getDetails()).get(4);
                String phoneNumber = filter(String.class, job.getDetails()).get(5);
                createRegular(id, name, surname, addresses, DOB, email, phoneNumber);
                break;
            }
            case "CreateNewAdmin": {
                String id = filter(String.class, job.getDetails()).get(0);
                String name = filter(String.class, job.getDetails()).get(1);
                String surname = filter(String.class, job.getDetails()).get(2);
                //Check if this works
                ArrayList<String> addresses = filter(ArrayList.class, job.getDetails()).get(0);
                String DOB = filter(String.class, job.getDetails()).get(3);
                String email = filter(String.class, job.getDetails()).get(4);
                String phoneNumber = filter(String.class, job.getDetails()).get(5);
                createAdmin(id, name, surname, addresses, DOB, email, phoneNumber);
                break;
            }
        }
    }

    @Override
    public <T> int createUser(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber, Class<T> tclass) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(id);
        jobDetails.add(name);
        jobDetails.add(surname);
        jobDetails.add(addresses);
        jobDetails.add(DOB);
        jobDetails.add(email);
        jobDetails.add(phoneNumber);
        if(tclass.isInstance(User.class)){
            return JobRequest.AddJobRequest(jobDetails, "CreateNewUser");
        }if(tclass.isInstance(Customer.class)){
            return JobRequest.AddJobRequest(jobDetails, "CreateNewCustomer");
        }else if(tclass.isInstance(Regular.class)){
            return JobRequest.AddJobRequest(jobDetails, "CreateNewRegular");
        }else if(tclass.isInstance(Administrator.class)){
            return JobRequest.AddJobRequest(jobDetails, "CreateNewAdmin");
        }
        return -1;
    }
    // make into interface as a super worker
    void createUser(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber){
        Action.users.add(new User(id, name, surname, addresses, DOB, email, phoneNumber));
    }

    void createCustomer(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber){
        Action.users.add(new Customer(id, name, surname, addresses, DOB, email, phoneNumber));
    }

    void createRegular(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber){
        Action.regulars.add(new Regular(id, name, surname, addresses, DOB, email, phoneNumber));
    }

    void createAdmin(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber){
        Action.administrators.add(new Administrator(id, name, surname, addresses, DOB, email, phoneNumber));
    }

    @Override
    public int deleteUser(String id) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(id);
        return JobRequest.AddJobRequest(jobDetails, "CreateNewUser");
    }

    @Override
    public void viewJobs() {
        int counter = 0;
        for(Job approvedJob: Action.approvedJobs){
            System.out.println(counter++ + ":   " + approvedJob.getDetails());
        }
    }

    //add id to job request?

    @Override
    public void createNewAccount(User[] beneficiaries, String accountNumber, double availableBalance, String currency) {
        Action.accounts.add(new Account(beneficiaries, accountNumber, availableBalance, currency));
    }

    @Override
    public void createNewAccount(User[] beneficiaries, String accountNumber, String currency) {
        Action.accounts.add(new Account(beneficiaries, accountNumber, 0, currency));
    }

    @Override
    public void closeAccount(String accountNumber) {
        Account account = Action.getAccount(accountNumber);
        assert account != null;
        Action.closedAccounts.add(account);
        Action.accounts.remove(account);
    }

    @Override
    public void deleteAccount(String accountNumber) {
        Action.closedAccounts.remove(Action.getAccount(accountNumber));
    }

    @Override
    public void transferToAccount(String accountFrom, String accountTo, double amount) {
        Action.Transfer(accountFrom, accountTo, 500);
    }

    @Override
    public void addCard(User user, String validTo, String cvv, boolean virtual, short status, double limit,
                        Account account, double creditLimit, double interestRate) {
        account.addCard(new CreditCard(user, validTo, cvv, "", virtual, status, limit, account,
                                        creditLimit, interestRate, Limits.CREDIT_COUNTDOWN));
        Action.AmendAccount(account.getNumber(), account);
    }

    @Override
    public void addCard(User user, String validTo, String cvv, boolean virtual, short status, double limit,
                        Account account) {
        account.addCard(new DebitCard(user, validTo, cvv, "", virtual, status, limit, account));
        Action.AmendAccount(account.getNumber(), account);
    }

    @Override
    public void removeCard(String accountNumber, String cardNumber) {
        Account account = Action.getAccount(accountNumber);
        assert account != null;
        ArrayList<Card> cards = account.getCards();
        Card card = null;
        for (Card c : cards){
            if(c.getNumber().equals(cardNumber)){
                card = c;
            }
        }
        account.removeCard(card);
        Action.AmendAccount(accountNumber, account);
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
