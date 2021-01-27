package Workflow;
/**
 *
 * <h1>Status Class</h1>
 *
 * <p>
 *     A status class that represents the status to whatever object it is attached to. This replaces a boolean variable
 *     giving a greater range of statuses. In the class there are some preset value as to what the int number could mean.
 * </p>
 */
public class Status {
    private int status;
    public static Status approved = new Status(1);
    public static Status complete = new Status(2);
    public static Status rejected = new Status(3);
    public static Status inProgress = new Status(4);

    public Status(){
        status = 0;
    }

    private Status(int i){
        status = i;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void markApproved(){
        status = 1;
    }

    public void markComplete(){
        status = 2;
    }

    public void markRejected(){
        status = 3;
    }

    public void markInProgress(){
        status = 4;
    }

    public boolean isApproved(){
        return status == 1;
    }

    public boolean isComplete(){
        return status == 2;
    }

    public boolean isRejected(){
        return status == 3;
    }

    public boolean isInProgress(){
        return status == 4;
    }

    public boolean is(Status other){
        return status == other.status;
    }
}
