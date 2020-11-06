package Users;

public class Regular extends User implements Worker{

    public Regular(String name, String surname, String[] addresses,
                         String DOB, String email, String phoneNumber) {
        super(name, surname, addresses, DOB, email, phoneNumber);
    }


    @Override
    public void openAccount() {

    }

    @Override
    public void closeAccount() {

    }

    @Override
    public void addCard() {

    }

    @Override
    public void removeCard() {

    }

    @Override
    public void createNewAccount() {

    }

    @Override
    public void moveToAccount() {

    }

    @Override
    public void viewBalance() {

    }
}
