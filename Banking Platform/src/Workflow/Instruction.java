package Workflow;

import Users.Customer;
import Users.Employee;

public class Instruction extends Status{
    private final String detail;
    //TODO: map for this
    private final Customer from;
    private Employee assignee;

    public Instruction(String detail, Customer from) {
        this.detail = detail;
        this.from = from;
    }


    public String getDetail() {
        return detail;
    }

    public Customer getFrom() {
        return from;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public void setAssignee(Employee assignee) {
        this.assignee = assignee;
    }

}
