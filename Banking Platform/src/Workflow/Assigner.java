package Workflow;

import Users.Employee;

public interface Assigner {
    void assignJob(int jobID, Employee assignedTo);
    void assignInstruction(int jobID, Employee assignedTo);
}
