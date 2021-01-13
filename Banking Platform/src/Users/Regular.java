package Users;

import Accounts.*;
import Workflow.Job;
import Workflow.BankSystem;
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
    public Regular(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }

    public void doJob(int JobID) {
        Job job = BankSystem.jobs.get(JobID);
        job.markInProgress();

        switch (job.getDescription()) {
            case "Create New Account":
                if (job.getDetails().size() == 5) {
                    Customer[] beneficiaries = filter(Customer[].class, job.getDetails()).get(0);
                    String accountNumber = filter(String.class, job.getDetails()).get(0);
                    Double availableBalance = filter(Double.class, job.getDetails()).get(0);
                    String currency = filter(String.class, job.getDetails()).get(1);
                    if(!isClassPresent(CurrentAccount.class, job.getDetails())){
                        if(isClassPresent(SavingsAccount.class, job.getDetails())){
                            SavingsAccount ac = new SavingsAccount(beneficiaries, accountNumber,
                                                            availableBalance, currency);
                            BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)).addAccount(ac);
                        }
                    }
                    if(!isClassPresent(SavingsAccount.class, job.getDetails())){
                        if(isClassPresent(CurrentAccount.class, job.getDetails())){
                            CurrentAccount ac = new CurrentAccount(beneficiaries, accountNumber,
                                    availableBalance, currency);
                            BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)).addAccount(ac);
                        }
                    }
                    //error
                } else if (job.getDetails().size() == 4) {
                    Customer[] beneficiaries = filter(Customer[].class, job.getDetails()).get(0);
                    String accountNumber = filter(String.class, job.getDetails()).get(0);
                    String currency = filter(String.class, job.getDetails()).get(1);

                    if(!isClassPresent(CurrentAccount.class, job.getDetails())){
                        if(isClassPresent(SavingsAccount.class, job.getDetails())){
                            SavingsAccount ac = new SavingsAccount(beneficiaries, accountNumber,
                                    0, currency);
                            BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)).addAccount(ac);
                        }
                    }
                    if(!isClassPresent(SavingsAccount.class, job.getDetails())){
                        if(isClassPresent(CurrentAccount.class, job.getDetails())){
                            CurrentAccount ac = new CurrentAccount(beneficiaries, accountNumber,
                                    0, currency);
                            BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)).addAccount(ac);
                        }
                    }
                    //error
                } else {
                    //error
                }
                break;
            case "Close Account": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)).getAccount(accountNumber).setStatus(false);
                break;
            }
            case "Add Card": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                if(!isClassPresent(DebitCard.class, job.getDetails())) {
                    if (isClassPresent(CreditCard.class, job.getDetails())) {
                        CreditCard cc = new CreditCard(BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)),
                                "12/12/2999", // so safe wow
                                accountNumber.substring(accountNumber.length() - 3),
                                accountNumber,
                                "",
                                false,
                                -1.0);
                        BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)).getAccount(accountNumber).addCard(cc);
                    }
                }
                break;
            }
            case "Remove Card": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                String cardNumber = filter(String.class, job.getDetails()).get(1);

                BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)).getAccount(accountNumber).removeCard(cardNumber);
                break;
            }
        }
        job.markComplete();
    }

    @Override
    public String viewJobs() {
        StringBuilder output = new StringBuilder();
        output.append("Jobs\n");
        output.append("ID\tDetails\tStatus\n");
        for(int i = 0; i < BankSystem.jobs.size(); i++)
            if(BankSystem.jobs.get(i).getAssignee() == this)
                output.append(i).append("\t").append(BankSystem.jobs.get(i).getDetails())
                                .append("\t").append(BankSystem.jobs.get(i).getStatus()).append("\n");
        return output.toString();
    }

    public String viewInstructions() {
        StringBuilder output = new StringBuilder();
        output.append("Jobs\n");
        output.append("ID\tDetails\n");
        for(int i = 0; i < BankSystem.instructions.size(); i++)
            if(BankSystem.instructions.get(i).getAssignee() == this)
                output.append(i).append("\t").append(BankSystem.jobs.get(i).getDetails()).append("\n");
        return output.toString();
    }

    public void doTransaction(String detail, String accountFrom, String accountTo, double amount){
        Account f = BankSystem.getAccount(accountFrom);
        Account t = BankSystem.getAccount(accountFrom);
        f.setBalanceOnHold(f.getBalanceOnHold() - amount);
        t.setAvailableBalance(t.getAvailableBalance() + amount);
        f.addTransaction(new Transaction(detail, accountFrom, accountTo, amount));
        t.addTransaction(new Transaction(detail, accountFrom, accountTo, amount));

        BankSystem.AmendAccount(accountFrom, f);
        BankSystem.AmendAccount(accountTo, t);
    }

    @Override
    public <T> void requestCreateNewAccount(Class<T> type, Customer[] beneficiaries, String accountNumber, double availableBalance, String currency) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(type);
        jobDetails.add(beneficiaries);
        jobDetails.add(accountNumber);
        jobDetails.add(availableBalance);
        jobDetails.add(currency);
        BankSystem.jobs.add(new Job(jobDetails, "Create New Account"));
    }

    @Override
    public <T> void requestCreateNewAccount(Class<T> type, Customer[] beneficiaries, String accountNumber, String currency) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(type);
        jobDetails.add(beneficiaries);
        jobDetails.add(accountNumber);
        jobDetails.add(currency);
        BankSystem.jobs.add(new Job(jobDetails, "Create New Account"));
    }

    @Override
    public void requestCloseAccount(String accountNumber) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(accountNumber);
        BankSystem.jobs.add(new Job(jobDetails, "Close Account"));
    }

    @Override
    public <T> void requestAddCard(Class<T> type, String accountNumber) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(type);
        jobDetails.add(accountNumber);
        BankSystem.jobs.add(new Job(jobDetails, "Add Card"));
    }

    @Override
    public void requestCloseCard(String accountNumber, String cardNumber) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(accountNumber);
        jobDetails.add(cardNumber);
        BankSystem.jobs.add(new Job(jobDetails, "Close Card"));
    }
}
