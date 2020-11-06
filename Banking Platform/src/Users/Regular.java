package Users;

public class Regular extends User{// implements Worker
    /**
     * <p>
     * Constructor method to create a new User, all variables declared above must be initialised in order to create
     * a new User.
     * </p>
     *
     * @param name        Name of the User.
     * @param surname     Surname of the User.
     * @param addresses   Array of the user addresses, Must have at least 1.
     * @param DOB         Date of Birth of the user.
     * @param email       Email of the user.
     * @param phoneNumber Phone of the user.
     */
    public Regular(String name, String surname, String[] addresses, String DOB, String email, String phoneNumber) {
        super(name, surname, addresses, DOB, email, phoneNumber);
    }
}
