package Old.Users;

public interface Approver extends BasicWorker{
    //TODO: Add javadoc

    void approveJobRequest(int JobID);
    void removeJobRequest(int JobID);
}
