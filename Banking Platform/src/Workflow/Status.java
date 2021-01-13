package Workflow;

public class Status {
    private int status;

    public Status(){
        status = 0;
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
}
