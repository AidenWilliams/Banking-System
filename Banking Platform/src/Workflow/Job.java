package Workflow;

import Accounts.Account;

import java.io.*;
import java.util.ArrayList;

public class Job {
    static ArrayList<String> detail;
    static ArrayList<Object> item;
    static ArrayList<Account> accounts;

    public static void startUp(){
        detail = null;
        item = null;
        accounts = null;
    }

    static void AddAccount(){
        //Change those account details
    }
    static void AmendAccount(String accountNumber, Account amendedAccount){
        //Change those account details
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getAccountNumber().equals(accountNumber)){
                accounts.set(i, amendedAccount);
            }
        }
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

    public static Account getAccount(String accountNumber){
        for (Account account : Job.accounts )
            if( account.getAccountNumber().equals(accountNumber))
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
