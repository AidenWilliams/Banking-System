package Workflow;

import java.util.ArrayList;

public class Job {
    ArrayList<Object> details = new ArrayList<>();
    ;
    String description;
    private int stage = 0;

    Job(ArrayList<Object> details, String description) {
        this.details = details;
        this.description = description;
    }

    Job(Object detail, String description) {
        this.details.add(detail);
        this.description = description;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getStage() {
        return stage;
    }

    public ArrayList<Object> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Object> details) {
        this.details = details;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
