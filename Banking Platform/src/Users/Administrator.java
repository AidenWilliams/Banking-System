package Users;

public class Administrator extends User{
    public Administrator(){
        super();
    }
    public Administrator(String name, String surname, String correspondenceAddress, String[] otherAddresses,
                  String DOB, String email, String phoneNumber) {
        super(name, surname, correspondenceAddress, otherAddresses, DOB, email, phoneNumber);
    }

}
