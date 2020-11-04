package Users;

public class User {
    private String name;
    private String surname;
    private String correspondenceAddress;
    private String[] otherAddresses;
    private String DOB;
    private String email;
    private String phoneNumber;
    User(){

    }
    User(String name, String surname, String correspondenceAddress, String[] otherAddresses,
         String DOB, String email, String phoneNumber)
    {
        this.name = name;
        this.surname = surname;
        this.correspondenceAddress = correspondenceAddress;
        this.otherAddresses = otherAddresses;
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

    public String getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(String correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    public String[] getOtherAddresses() {
        return otherAddresses;
    }

    public void setOtherAddresses(String[] otherAddresses) {
        this.otherAddresses = otherAddresses;
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
