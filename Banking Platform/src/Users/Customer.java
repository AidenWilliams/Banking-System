package Users;
import Accounts.Account;
import Exceptions.AccountNotFound;
import Users.User;
import Workflow.Instruction;

import java.util.ArrayList;

public abstract class Customer extends User {
    protected ArrayList<Account> accounts;

    Customer(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email,
             String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
        accounts = new ArrayList<>();
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

    public Account getAccount(String accountNumber) throws AccountNotFound {
        for (Account account : accounts)
            if(account.getNumber().equals(accountNumber))
                return account;
        throw new AccountNotFound("No Account with account number:" + accountNumber + " found!");
    }
    public void setAccount(Account account) {
        for(int i = 0; i < accounts.size(); i++)
            if(accounts.get(i).getNumber().equals(account.getNumber()))
                accounts.set(i, account);
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }
}
