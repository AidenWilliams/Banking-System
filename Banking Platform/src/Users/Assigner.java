package Users;

import Exceptions.JobNotFound;

public interface Assigner {
    void assignJob(int JobID, Employee employee) throws JobNotFound;
}
