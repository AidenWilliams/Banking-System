package Workflow;

import Users.Employee;

public interface Assigner {
    void assignJob(int JobID, Employee employee);
    void assignInstruction(int JobID, Employee employee);
}
