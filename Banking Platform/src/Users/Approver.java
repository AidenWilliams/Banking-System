package Users;

public interface Approver {
    //TODO: Add javadoc

    void approveJobRequest(int JobID, Employee employee);
    void removeJobRequest(int JobID);
}