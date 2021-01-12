package Users;

import java.util.ArrayList;

public class Regular extends Employee implements Requester{
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
    Regular(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }

    @Override
    void doJob(int JobID) {

    }

    @Override
    String viewJobs() {
        return null;
    }

    @Override
    public void requestCreateNewAccount(Customer[] beneficiaries, String accountNumber, double availableBalance, String currency) {

    }

    @Override
    public void requestCreateNewAccount(Customer[] beneficiaries, String accountNumber, String currency) {

    }

    @Override
    public void requestCloseAccount(String accountNumber) {

    }

    @Override
    public void requestAddCard(String accountNumber) {

    }

    @Override
    public void requestCloseCard(String accountNumber, String cardNumber) {

    }
}
