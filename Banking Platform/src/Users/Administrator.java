package Users;

import java.util.ArrayList;

public class Administrator extends Employee implements Approver{
    /**
     * <p>
     * Constructor method to create a new User, all variables declared above must be initialised in order to create
     * a new User.
     * </p>
     *
     * @param id          Id of the User. Could be id card or passport number
     * @param name        Name of the User.
     * @param surname     Surname of the User.
     * @param addresses   Array of the user addresses, Must have at least 1.
     * @param DOB         Date of Birth of the user.
     * @param email       Email of the user.
     * @param phoneNumber Phone of the user.
     */
    Administrator(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }

    @Override
    public void approveJobRequest(int JobID) {

    }

    @Override
    public void removeJobRequest(int JobID) {

    }

    @Override
    void doJob(int JobID) {

    }

    @Override
    String viewJobs() {
        return null;
    }
}
