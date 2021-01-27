package Workflow;
import Users.Employee;

import java.util.ArrayList;
/**
 *
 * <h1>Job Class</h1>
 *
 * <p>
 *     A class that represents a job in the banking system. Each job is represented by a list of objects representing the
 *     job items and a string description, representing the job. Jobs can also be assigned an employee.
 * </p>
 */
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
