package Users;
import Exceptions.InstructionNotFound;
import Exceptions.JobNotFound;
import Workflow.*;

import java.util.ArrayList;

public class Administrator extends Employee implements Approver, Assigner {
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
    public void assignJob(int JobID, Employee employee) throws JobNotFound {
        Job j;
        try {
            j = BankSystem.jobs.get(JobID);
        }catch (Exception ignored){
            throw new JobNotFound("Job with job id " + JobID +" was not found!");
        }
        j.setAssignee(employee);
    }

    @Override
    public void approveJobRequest(int JobID, Employee employee) throws JobNotFound {
        Job j;
        try {
            j = BankSystem.jobs.get(JobID);
        }catch (Exception ignored){
            throw new JobNotFound("Job with job id " + JobID +" was not found!");
        }
        j.markApproved();
        assignJob(JobID, employee);
    }

    @Override
    public void declineInstruction(int InstrctionID) throws InstructionNotFound {
        Instruction i;
        try {
            i =  BankSystem.instructions.get(InstrctionID);
        }catch (Exception ignored){
            throw new InstructionNotFound("Instruction with instruction id " + InstrctionID +" was not found!");
        }
        i.markRejected();
    }

    @Override
    public void removeJobRequest(int JobID) throws JobNotFound {
        Job j;
        try {
            j = BankSystem.jobs.get(JobID);
        }catch (Exception ignored){
            throw new JobNotFound("Job with job id " + JobID +" was not found!");
        }
        j.markRejected();
    }
}
