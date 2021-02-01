package Users;

import Accounts.*;
import Exceptions.InstructionNotFound;
import Exceptions.JobNotFound;
import Workflow.Instruction;
import Workflow.Job;
import Workflow.BankSystem;
import Workflow.Status;

import java.util.ArrayList;

public class Regular extends ActionTaker implements Requester{
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

    @Override
    public void instructionToJob(int InstructionID, Job job, Employee employee) throws InstructionNotFound {
        Instruction i;
        try {
            i =  BankSystem.instructions.get(InstructionID);
        }catch (Exception ignored){
            throw new InstructionNotFound("Instruction with instruction id " + InstructionID +" was not found!");
        }
        i.markApproved();
        i.setAssignee(employee);

        ArrayList<Object> list = job.getDetails();
        list.add(BankSystem.instructions.get(InstructionID));
        job.setDetails(list);
        BankSystem.jobs.add(job);
    }

    public void doJob(int JobID) throws Exception{
        if(!BankSystem.status.isInProgress()) return;

        Job job = BankSystem.jobs.get(JobID);
        if(!job.isApproved()) return;
        job.markInProgress();

        switch (job.getDescription()) {
            case "Create New Customer": {
                if(filter(RetailCustomer.class, job.getDetails()).size() == 1){
                    BankSystem.customers.add(filter(RetailCustomer.class, job.getDetails()).get(0));
                }
                break;
            }
            case "Create New Account":
                if (job.getDetails().size() == 5) {
                    String[] beneficiaries = filter(String[].class, job.getDetails()).get(0);
                    String accountNumber = filter(String.class, job.getDetails()).get(0);
                    Double availableBalance = filter(Double.class, job.getDetails()).get(0);
                    String currency = filter(String.class, job.getDetails()).get(1);
                    if(!isClassPresent(CurrentAccount.class, job.getDetails())){
                        if(isClassPresent(SavingsAccount.class, job.getDetails())){
                            SavingsAccount sc = new SavingsAccount(beneficiaries, accountNumber,
                                                            availableBalance, currency);
                            for(String customer: beneficiaries){
                                BankSystem.AssignAccountToCustomer(sc, customer);
                            }
                        }
                    }
                    if(!isClassPresent(SavingsAccount.class, job.getDetails())){
                        if(isClassPresent(CurrentAccount.class, job.getDetails())){
                            CurrentAccount ac = new CurrentAccount(beneficiaries, accountNumber,
                                    availableBalance, currency);
                            for(String customer: beneficiaries){
                                BankSystem.AssignAccountToCustomer(ac, customer);
                            }
                        }
                    }
                    //error
                } else if (job.getDetails().size() == 4) {
                    String[] beneficiaries = filter(String[].class, job.getDetails()).get(0);
                    String accountNumber = filter(String.class, job.getDetails()).get(0);
                    String currency = filter(String.class, job.getDetails()).get(1);

                    if(!isClassPresent(CurrentAccount.class, job.getDetails())){
                        if(isClassPresent(SavingsAccount.class, job.getDetails())){
                            SavingsAccount sc = new SavingsAccount(beneficiaries, accountNumber,
                                    0, currency);
                            for(String customer: beneficiaries){
                                BankSystem.AssignAccountToCustomer(sc, customer);
                            }
                        }
                    }
                    if(!isClassPresent(SavingsAccount.class, job.getDetails())){
                        if(isClassPresent(CurrentAccount.class, job.getDetails())){
                            CurrentAccount ac = new CurrentAccount(beneficiaries, accountNumber,
                                    0, currency);
                            for(String customer: beneficiaries){
                                BankSystem.AssignAccountToCustomer(ac, customer);
                            }
                        }
                    }
                    //error
                } else {
                    //error
                }
                break;
            case "Close Account": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                for(int i: BankSystem.OwnerOfAccount(accountNumber))
                    if(i != -1)
                        BankSystem.customers.get(i).getAccount(accountNumber).setStatus(Status.complete);
                break;
            }
            case "Add Card": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                if(!isClassPresent(DebitCard.class, job.getDetails())) {
                    if (isClassPresent(CreditCard.class, job.getDetails())) {
                        CreditCard cc = new CreditCard(BankSystem.getAccount(accountNumber),
                                BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)[0]).getName(),
                                BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)[0]).getSurname(),
                                "12/12/2999", // so safe wow
                                accountNumber.substring(accountNumber.length() - 3),
                                "",
                                false,
                                -1.0,
                                1000,
                                0.025);
                        for(int i: BankSystem.OwnerOfAccount(accountNumber))
                            BankSystem.customers.get(i).getAccount(accountNumber).addCard(cc);
                    }
                }

                if(!isClassPresent(CreditCard.class, job.getDetails())) {
                    if (isClassPresent(DebitCard.class, job.getDetails())) {
                        DebitCard dc = new DebitCard(BankSystem.getAccount(accountNumber),
                                BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)[0]).getName(),
                                BankSystem.customers.get(BankSystem.OwnerOfAccount(accountNumber)[0]).getSurname(),
                                "12/12/2999", // so safe wow
                                accountNumber.substring(accountNumber.length() - 3),
                                "",
                                false,
                                -1.0);
                        for(int i: BankSystem.OwnerOfAccount(accountNumber))
                            BankSystem.customers.get(i).getAccount(accountNumber).addCard(dc);
                    }
                }
                break;
            }
            case "Remove Card": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                String cardNumber = filter(String.class, job.getDetails()).get(1);

                for(int i: BankSystem.OwnerOfAccount(accountNumber))
                    BankSystem.customers.get(i).getAccount(accountNumber).removeCard(cardNumber);
                break;
            }
            case "Transfer": {
                String detail = filter(String.class, job.getDetails()).get(0);
                String accountFrom = filter(String.class, job.getDetails()).get(1);
                String accountTo = filter(String.class, job.getDetails()).get(2);
                Double amount = filter(Double.class, job.getDetails()).get(0);

                doTransaction(detail, accountFrom, accountTo, amount);
            }
        }
        job.markComplete();
    }
    public void doTransaction(String detail, String accountFrom, String accountTo, double amount){
        Account f,t;
        try{
            f = BankSystem.getAccount(accountFrom);
        }catch(Exception m){
            System.out.println(m.toString());
            System.out.println("From Account not found!");
            return;
        }
        try{
            t = BankSystem.getAccount(accountTo);
        }catch(Exception m){
            System.out.println(m.toString());
            System.out.println("To Account not found!");
            return;
        }
        f.setBalanceOnHold(f.getBalanceOnHold() - amount);
        t.setAvailableBalance(t.getAvailableBalance() + amount);
        f.addTransaction(new Transaction(detail, accountFrom, accountTo, amount));
        t.addTransaction(new Transaction(detail, accountFrom, accountTo, amount));

        BankSystem.AmendAccount(accountFrom, f);
        BankSystem.AmendAccount(accountTo, t);
    }

    @Override
    public void requestCreateNewCustomer(Customer customer) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(customer);
        BankSystem.jobs.add(new Job(jobDetails, "Create New Customer"));
    }

    @Override
    public <T> void requestCreateNewAccount(Class<T> type, String[] beneficiaries, String accountNumber, double availableBalance, String currency) {
        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(type);
        jobDetails.add(beneficiaries);
        jobDetails.add(accountNumber);
        jobDetails.add(availableBalance);
        jobDetails.add(currency);
        BankSystem.jobs.add(new Job(jobDetails, "Create New Account"));
    }

    @Override
    public <T> void requestCreateNewAccount(Class<T> type, String[] beneficiaries, String accountNumber, String currency) {
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
