package Users;

import Accounts.Account;
import Workflow.Action;
import Workflow.Job;
import Workflow.JobRequest;
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

    public void DoJob(int JobID){
        Job job = Action.approvedJobs.get(JobID);

        /*public static Map<Integer, String> jobTypes = new HashMap<>()
    {{
        jobTypes.put(1, "CreateNewAccount");
        jobTypes.put(2, "CloseAccount");
        jobTypes.put(3, "DeleteAccount");
        jobTypes.put(4, "Transfer");
        jobTypes.put(5, "AddCard");
        jobTypes.put(6, "RemoveCard");
    }};

         */
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
            case "AddCard": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                addCard(accountNumber);
                break;
            }
            case "RemoveCard": {
                String accountNumber = filter(String.class, job.getDetails()).get(0);
                removeCard(accountNumber);
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
                //createUser();
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
                //CreateNewCustomer();
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
                //CreateNewRegular();
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
                //CreateNewAdmin();
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

    User createUser(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber){
        return null;
    }

    Customer createCustomer(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber){
        return null;
    }

    Regular createRegular(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber){
        return null;
    }

    Administrator createAdmin(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber){
        return null;
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
