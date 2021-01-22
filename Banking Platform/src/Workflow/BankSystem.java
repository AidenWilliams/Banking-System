package Workflow;

import Accounts.Account;
import Exceptions.*;
import Users.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class BankSystem {
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Instruction> instructions = new ArrayList<>();
    public static ArrayList<Job> jobs = new ArrayList<>();
    public static Status status = new Status();

    public static void start(){
        status.markInProgress();
    }

    public static void pause(){
        status.markApproved();
    }

    public static void stop(){
        status.markComplete();
    }

    public static Account getAccount(String number) throws AccountNotFound {
        Account account;
        for(Customer customer: customers){
            account = customer.getAccount(number);
            if(account.getNumber().equals(number))
                return account;
        }
        throw new AccountNotFound("No Account with account number:" + number + " found!");
    }

    public static void AmendAccount(String number, Account amendedAccount){
        String accountNumber;
        for(Customer customer: customers){
            try {
                accountNumber = customer.getAccount(number).getNumber();
            }catch (Exception m){
                System.out.println(m.toString());
                return;
            }
            if (accountNumber.equals(number))
                customer.setAccount(amendedAccount);
        }
    }

    public static void AssignAccountToCustomer(Account account, String id){
        for(Customer customer: customers)
            if(customer.getId().equals(id))
                customer.addAccount(account);
    }

    public static int[] OwnerOfAccount(String number) throws OwnerNotFound{
        int[] ret = new int[] {-1, -1};
        int cnt = 0;
        for(int i = 0; i < customers.size(); i++){
            try{
                customers.get(i).getAccount(number);
                ret[cnt++] =i ;
            }catch (Exception ignored){
                // We dont really mind if we dont find all the accounts
            }
        }
        if (Arrays.equals(ret, new int[]{-1, -1}))
            throw new OwnerNotFound("No User owner found for account number: " +number);
        return ret;
    }
}
