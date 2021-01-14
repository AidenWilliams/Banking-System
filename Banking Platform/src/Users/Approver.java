package Users;

import Workflow.Assigner;

public interface Approver {
    //TODO: Add javadoc

    void approveJobRequest(int JobID, Employee employee);
    void removeJobRequest(int JobID);
}