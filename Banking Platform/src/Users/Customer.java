package Users;
import java.util.ArrayList;

public abstract class Customer extends User {
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
    //Account
    String account;
    Customer(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email,
             String phoneNumber, String account) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
        this.account = account;
    }

    //do getter/setter for account

    abstract String viewBalance();
    abstract String viewTransactions();
    abstract String  viewTransactions(String accountNumber);
}
