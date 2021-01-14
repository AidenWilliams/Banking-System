package Workflow;

import Accounts.Account;
import Users.Customer;

import java.util.ArrayList;

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

    public static Account getAccount(String number){
        for(Customer customer: customers){
            if(customer.getAccount(number).getNumber().equals(number)){
                return customer.getAccount(number);
            }
        }
        return null;
    }

    public static void AmendAccount(String number, Account amendedAccount){
        for(Customer customer: customers) {
            if (customer.getAccount(number).getNumber().equals(number)) {
                customer.setAccount(amendedAccount);
            }
        }
    }

    public static void AssignAccountToCustomer(Account account, Customer customer){

    }

    public static int OwnerOfAccount(String number){
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getAccount(number) != null)
                return i;
        }
        return -1;
    }
}
