package Users;

import Accounts.Account;
import Workflow.Action;
import Workflow.Job;
import Workflow.JobRequest;
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
    public Regular(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
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

        if(job.getDescription().equals("CreateNewAccount")){
            if(job.getDetails().size() == 4){
                createNewAccount(
                        //TODO: I dont think this works by casting, might need to restructure jobs into a more oop fashion
                        (User[]) job.getDetails().get(0),
                        (String) job.getDetails().get(1),
                        (Double) job.getDetails().get(2),
                        (String) job.getDetails().get(3)
                );
            }else{
                createNewAccount(
                        (User[]) job.getDetails().get(0),
                        (String) job.getDetails().get(1),
                        (String) job.getDetails().get(2)
                );
            }
        }else
        if(job.getDescription().equals("CloseAccount")){

        }else
        if(job.getDescription().equals("DeleteAccount")){

        }else
        if(job.getDescription().equals("Transfer")){

        }else
        if(job.getDescription().equals("AddCard")){

        }else
        if(job.getDescription().equals("RemoveCard")){

        }
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
