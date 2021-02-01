package Users;

import Workflow.BankSystem;
import Workflow.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Employee extends User {
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
    Employee(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }
    // Reasoning is that all employees can view their joblit and do the job hey want to
    public String viewInstructions(){
        StringBuilder output = new StringBuilder();
        output.append("Employee Instructions\n");
        output.append("ID\tDetails\n");
        for (int i = 0; i < BankSystem.instructions.size(); i++)
            output.append(i).append("\t").append(BankSystem.instructions.get(i).getDetail()).append("\n");
        return output.toString();
    }

    public String viewJobs() {
        StringBuilder output = new StringBuilder();
        output.append("Jobs\n");
        output.append("ID\tDetails\tStatus\n");
        int i = 0;
        for(Job job: BankSystem.jobs)
            output.append(i++).append("\t").append(job.getDescription())
                    .append("\t").append(job.getStatus()).append("\n");

        return output.toString();
    }
}
