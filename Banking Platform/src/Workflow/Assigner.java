package Workflow;

import Exceptions.JobNotFound;
import Users.Employee;

public interface Assigner {
    void assignJob(int JobID, Employee employee) throws JobNotFound;
}
