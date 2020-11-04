package Users;

public class User {
    private String name;
    private String surname;
    private String[] addresses;
    private String DOB;
    private String email;
    private String phoneNumber;
    User(){

    }
    User(String name, String surname, String[] addresses,
         String DOB, String email, String phoneNumber)
    {
        this.name = name;
        this.surname = surname;
        this.addresses = addresses;
        this.DOB = DOB;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
