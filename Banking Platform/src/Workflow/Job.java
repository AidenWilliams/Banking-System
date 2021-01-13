package Workflow;

import Users.Employee;

import java.util.ArrayList;

public class Job extends Status{
    ArrayList<Object> details = new ArrayList<>();

    String description;
    private Employee assignee;

    public Job(ArrayList<Object> details, String description) {
        this.details = details;
        this.description = description;
    }

    public Job(Object detail, String description) {
        this.details.add(detail);
        this.description = description;
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

    public Employee getAssignee() {
        return assignee;
    }

    public void setAssignee(Employee assignee) {
        this.assignee = assignee;
    }
}
