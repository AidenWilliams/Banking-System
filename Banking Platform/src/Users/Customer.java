package Users;
import Accounts.Account;
import Workflow.Instruction;

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
    private ArrayList<Account> accounts;
    Customer(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email,
             String phoneNumber, ArrayList<Account> accounts) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
        this.accounts = (accounts);
    }

    abstract String viewBalance();
    abstract String viewBalance(String accountNumber);
    abstract String viewTransactions();
    abstract String viewTransactions(String accountNumber);
    abstract void addInstruction(String instruction);
    abstract void removeInstruction(int id);
    abstract String viewInstruction(Instruction instruction);
    abstract String viewInstructions();
    abstract void requestTransferToAccount(String detail, String accountFrom, String accountTo, double amount);
    public Account getAccount(String accountNumber){
        for (Account account : accounts)
            if(account.getNumber().equals(accountNumber))
                return account;
        return null;
    }
    public void setAccount(Account account) {
        for (Account a : accounts)
            if(account.getNumber().equals(a.getNumber()))
                a = account;
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }
}
