package Old.Workflow;

import Old.Accounts.Account;
import Old.Users.Administrator;
import Old.Users.Customer;
import Old.Users.Regular;
import Old.Users.User;

import java.util.ArrayList;

public class Action {
    //Make not public
    public static ArrayList<Job> pendingJobs = new ArrayList<>();
    public static ArrayList<Job> approvedJobs = new ArrayList<>();
    public static ArrayList<Job> completedJobs = new ArrayList<>();
    public static ArrayList<Job> removedJobs = new ArrayList<>();
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<Account> closedAccounts = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Regular> regulars = new ArrayList<>();
    public static ArrayList<Administrator> administrators = new ArrayList<>();


    static void AddAccount(){
        //Change those account details
    }

    static void AmendAccount(Account oldAccount, Account amendedAccount){
        //Change those account details
        accounts.set(accounts.indexOf(oldAccount), amendedAccount);
    }
    static void ViewAccount(){
        //Get detail from account
    }
    static void DeleteAccount(){
        //Remove the account from the file
    }
    static void AddUser(){
        //Write User to file
    }
    static void AmendUser(){
        //Change those user details
    }
    static void DeleteUser(){
        //Remove the account from the file
    }
    static void getJobTypes(){
        //get jobs
    }
    static void getJobsOfType(){
        //blabla
    }

    public static void AmendAccount(String accountNumber, Account amendedAccount){
        //Change those account details
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getNumber().equals(accountNumber)){
                accounts.set(i, amendedAccount);
            }
        }
    }
    public static Account getAccount(String accountNumber){
        for (Account account : Action.accounts )
            if(account.getNumber().equals(accountNumber))
                return account;
        return null;
    }
    public static void Transfer(String accountFrom, String accountTo, double amount){
        Account f = getAccount(accountFrom), t = getAccount(accountTo);
        f.setBalanceOnHold(f.getBalanceOnHold() - amount);
        t.setAvailableBalance(t.getAvailableBalance() + amount);
        AmendAccount(accountFrom, f);
        AmendAccount(accountTo, t);
    }
}
