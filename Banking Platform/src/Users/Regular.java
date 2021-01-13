package Users;

import Accounts.Account;
import Accounts.Transaction;
import Workflow.Job;
import Workflow.Launcher;

import java.util.ArrayList;

public class Regular extends Employee implements Requester{
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
    Regular(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }

    @Override
    void doJob(int JobID) {
        Job job = Launcher.jobs.get(JobID);
        job.markInProgress();

        switch (job.getDescription()) {
            case "Create New Debit Account":
                if (job.getDetails().size() == 4) {
                    Customer[] beneficiaries = filter(Customer[].class, job.getDetails()).get(0);
                    String accountNumber = filter(String.class, job.getDetails()).get(0);
                    Double availableBalance = filter(Double.class, job.getDetails()).get(0);
                    String currency = filter(String.class, job.getDetails()).get(1);
                    //createNewAccount(beneficiaries, accountNumber, availableBalance, currency);
                } else if (job.getDetails().size() == 3) {
                    Customer[] beneficiaries = filter(Customer[].class, job.getDetails()).get(0);
                    String accountNumber = filter(String.class, job.getDetails()).get(0);
                    String currency = filter(String.class, job.getDetails()).get(1);
                    //createNewAccount(beneficiaries, accountNumber, currency);
                } else {
                    //error
                }
                break;
            case "Create New Credit Account":
                if (job.getDetails().size() == 4) {
                    Customer[] beneficiaries = filter(Customer[].class, job.getDetails()).get(0);
                    String accountNumber = filter(String.class, job.getDetails()).get(0);
                    Double availableBalance = filter(Double.class, job.getDetails()).get(0);
                    String currency = filter(String.class, job.getDetails()).get(1);
                    //createNewAccount(beneficiaries, accountNumber, availableBalance, currency);
                } else if (job.getDetails().size() == 3) {
                    Customer[] beneficiaries = filter(Customer[].class, job.getDetails()).get(0);
                    String accountNumber = filter(String.class, job.getDetails()).get(0);
                    String currency = filter(String.class, job.getDetails()).get(1);
                    //createNewAccount(beneficiaries, accountNumber, currency);
                } else {
                    //error
                }
                break;
            case "Close Account": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                break;
            }
            case "Add Card": {//fix
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                //addCard(accountNumber);
                break;
            }
            case "Remove Card": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                String cardNumber = filter(String.class, job.getDetails()).get(1);
                //removeCard(accountNumber, cardNumber);
                break;
            }
        }

        job.markComplete();
    }

    @Override
    String viewJobs() {
        StringBuilder output = new StringBuilder();
        output.append("Jobs\n");
        output.append("ID\tDetails\tStatus\n");
        for(int i = 0; i < Launcher.jobs.size(); i++)
            if(Launcher.jobs.get(i).getAssignee() == this)
                output.append(i).append("\t").append(Launcher.jobs.get(i).getDetails())
                                .append("\t").append(Launcher.jobs.get(i).getStatus()).append("\n");
        return output.toString();
    }

    String viewInstructions() {
        StringBuilder output = new StringBuilder();
        output.append("Jobs\n");
        output.append("ID\tDetails\n");
        for(int i = 0; i < Launcher.instructions.size(); i++)
            if(Launcher.instructions.get(i).getAssignee() == this)
                output.append(i).append("\t").append(Launcher.jobs.get(i).getDetails()).append("\n");
        return output.toString();
    }

    public void doTransaction(String detail, String accountFrom, String accountTo, double amount){
        Account f = Launcher.getAccount(accountFrom);
        Account t = Launcher.getAccount(accountFrom);
        f.setBalanceOnHold(f.getBalanceOnHold() - amount);
        t.setAvailableBalance(t.getAvailableBalance() + amount);
        f.addTransaction(new Transaction(detail, accountFrom, accountTo, amount));
        t.addTransaction(new Transaction(detail, accountFrom, accountTo, amount));

        Launcher.AmendAccount(accountFrom, f);
        Launcher.AmendAccount(accountTo, t);
    }

    @Override
    public void requestCreateNewDebitAccount(Customer[] beneficiaries, String accountNumber, double availableBalance, String currency) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(beneficiaries);
        jobDetails.add(accountNumber);
        jobDetails.add(availableBalance);
        jobDetails.add(currency);
        Launcher.jobs.add(new Job(jobDetails, "Create New Current Account"));
    }

    @Override
    public void requestCreateNewDebitAccount(Customer[] beneficiaries, String accountNumber, String currency) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(beneficiaries);
        jobDetails.add(accountNumber);
        jobDetails.add(currency);
        Launcher.jobs.add(new Job(jobDetails, "Create New Current Account"));
    }

    @Override
    public void requestCreateNewCreditAccount(Customer[] beneficiaries, String accountNumber, double availableBalance, String currency) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(beneficiaries);
        jobDetails.add(accountNumber);
        jobDetails.add(availableBalance);
        jobDetails.add(currency);
        Launcher.jobs.add(new Job(jobDetails, "Create New Savings Account"));
    }

    @Override
    public void requestCreateNewCreditAccount(Customer[] beneficiaries, String accountNumber, String currency) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(beneficiaries);
        jobDetails.add(accountNumber);
        jobDetails.add(currency);
        Launcher.jobs.add(new Job(jobDetails, "Create New Savings Account"));
    }

    @Override
    public void requestCloseAccount(String accountNumber) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(accountNumber);
        Launcher.jobs.add(new Job(jobDetails, "Close Account"));
    }

    @Override
    public void requestAddCard(String accountNumber) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(accountNumber);
        Launcher.jobs.add(new Job(jobDetails, "Add Card"));
    }

    @Override
    public void requestCloseCard(String accountNumber, String cardNumber) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(accountNumber);
        jobDetails.add(cardNumber);
        Launcher.jobs.add(new Job(jobDetails, "Close Card"));
    }
}
