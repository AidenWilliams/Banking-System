package Workflow;

import Accounts.Account;
import Users.Customer;
import Users.Employee;

public class Instruction {
    private String detail;
    //TODO: map for this
    private String status;
    private Customer from;
    private Employee assignedTo;

    public Instruction(String detail, Customer from) {
        this.detail = detail;
        this.status = "pending";
        this.from = from;
    }


    public String getDetail() {
        return detail;
    }

    public String getStatus() {
        return status;
    }

    public Customer getFrom() {
        return from;
    }

    public Employee getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Employee assignedTo) {
        this.assignedTo = assignedTo;
    }
}
