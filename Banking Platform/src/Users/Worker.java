package Users;

public interface Worker extends Basic{
    //TODO: Add javadoc
    User createUser(String name, String surname, String[] addresses, String DOB, String email, String phoneNumber);
    User deleteUser(String id);
    void viewBalance(User user);
    void viewJobs();
    //TODO: Add more functions to Worker
    //No need to add extra to worker, possibly add more to role
}
