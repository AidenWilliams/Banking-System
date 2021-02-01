package Workflow;

import Users.Customer;
import Users.Employee;

/**
 *
 * <h1>Job Class</h1>
 *
 * <p>
 *     A class that represents an instruction created by a customer sent to the employees of the bank.
 *     The purpose of this class is to act as an intermediary data storage before it is converted into a job, as it is not
 *     expected for customers to know the complex job system of the bank.
 * </p>
 */
public class Instruction extends Status {
    private final String detail;
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
