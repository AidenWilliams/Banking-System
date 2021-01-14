package Users;
import Workflow.Assigner;
import Workflow.BankSystem;
import java.util.ArrayList;

public class Administrator extends Employee implements Approver, Assigner{
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
    public Administrator(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }

    @Override
    public void assignJob(int JobID, Employee employee) {
        BankSystem.jobs.get(JobID).setAssignee(employee);
    }

    @Override
    public void assignInstruction(int JobID, Employee employee) {
        BankSystem.instructions.get(JobID).setAssignee(employee);
    }

    @Override
    public void approveJobRequest(int JobID, Employee employee) {
        BankSystem.jobs.get(JobID).markApproved();
        assignJob(JobID, employee);
    }

    @Override
    public void removeJobRequest(int JobID) {
        BankSystem.jobs.get(JobID).markRejected();
    }

    @Override
    String viewJobs() {
        StringBuilder output = new StringBuilder();
        output.append("Jobs\n");
        output.append("ID\tDetails\tStatus\tAssignee\n");
        for(int i = 0; i < BankSystem.jobs.size(); i++)
            output.append(i).append("\t").append(BankSystem.jobs.get(i).getDetails())
                    .append("\t").append(BankSystem.jobs.get(i).getStatus())
                    .append("\t").append(BankSystem.jobs.get(i).getAssignee()).append("\n");
        return output.toString();
    }
}
