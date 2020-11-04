package Users;

public class Administrator extends User{
    public Administrator(){
        super();
    }
    public Administrator(String name, String surname, String[] addresses,
                  String DOB, String email, String phoneNumber) {
        super(name, surname, addresses, DOB, email, phoneNumber);
    }
}
