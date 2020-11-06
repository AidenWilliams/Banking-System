package Users;

/**
 * <h1>User Super Class</h1>
 *
 * <p>
 *     The user class holds the variables that are common throughout all types of Users in the system.
 *     <br> <br>
 *     Cases where User will be used:
 *     <br> <br>
 *     <h2>Employee</h2>
 *     <ul>
 *         <li>Administrator</li>
 *         <li>Regular</li>
 *     </ul>
 *     <br>
 *     <h2>Customer</h2>
 *     <ul>
 *         <li>Customer</li>
 *     </ul>
 * </p>
 *
 * @author aiden
 * @version 1.1
 */
public class User {
    private String id;
    private String name;
    private String surname;
    private String[] addresses;
    private String DOB;
    private String email;
    private String phoneNumber;

    /**
     * <p>
     *      Constructor method to create a new User, all variables declared above must be initialised in order to create
     *      a new User.
     * </p>
     * @param id Id of the User. Could be id card or passport number
     * @param name Name of the User.
     * @param surname Surname of the User.
     * @param addresses Array of the user addresses, Must have at least 1.
     * @param DOB Date of Birth of the user.
     * @param email Email of the user.
     * @param phoneNumber Phone of the user.
     */
    User(String id, String name, String surname, String[] addresses,
         String DOB, String email, String phoneNumber){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.addresses = addresses;
        this.DOB = DOB;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //TODO: Add javadoc
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String[] getAddresses() {
        return addresses;
    }

    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
