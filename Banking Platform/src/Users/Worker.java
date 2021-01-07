package Users;

import java.util.ArrayList;

public interface Worker extends Basic{
    //TODO: Add javadoc
    <T> int createUser(String id, String name, String surname, ArrayList<String> addresses,
                               String DOB, String email, String phoneNumber, Class<T> tclass);
    int deleteUser(String id);
    void viewBalance(User user);
    void viewJobs();
    //TODO: Add more functions to Worker
    //No need to add extra to worker, possibly add more to role
}
