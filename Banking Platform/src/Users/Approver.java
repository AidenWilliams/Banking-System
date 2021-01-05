package Users;

public interface Approver {
    //TODO: Add javadoc

    void approveJobRequest(int JobID);
    void removeJobRequest(int JobID);
}
