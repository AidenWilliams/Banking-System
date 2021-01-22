package Users;

import Exceptions.InstructionNotFound;
import Exceptions.JobNotFound;
import Workflow.Assigner;
import Workflow.Job;

public interface Approver {
    //TODO: Add javadoc

    void approveJobRequest(int JobID, Employee employee) throws JobNotFound;
    void removeJobRequest(int JobID) throws JobNotFound ;
    String viewInstructions();
    void instructionToJob(int InstrctionID, Job job, Employee employee) throws InstructionNotFound,JobNotFound;
    void declineInstruction(int InstrctionID) throws InstructionNotFound ;
}