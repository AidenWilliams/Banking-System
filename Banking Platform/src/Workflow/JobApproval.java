package Workflow;

public class JobApproval {
    public static void ApproveJob(int JobID) {
        Action.approvedJobs.add(Action.pendingJobs.get(JobID));
        Action.pendingJobs.remove(JobID);
    }
    public static void DeclineJob(int JobID) {
        Action.removedJobs.add(Action.pendingJobs.get(JobID));
        Action.pendingJobs.remove(JobID);
    }
}
