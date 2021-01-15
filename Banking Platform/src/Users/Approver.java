package Users;

import Workflow.Assigner;
import Workflow.Job;

public interface Approver {
    //TODO: Add javadoc

    void approveJobRequest(int JobID, Employee employee);
    void removeJobRequest(int JobID);
    String viewInstructions();
    void instructionToJob(int InstrctionID, Job job, Employee employee);
    void declineInstruction(int InstrctionID);
}