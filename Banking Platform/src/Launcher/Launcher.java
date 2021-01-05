package Launcher;

import Accounts.Account;
import Users.*;
import Workflow.*;

import java.util.ArrayList;



public class Launcher {
    public static void main (String[] args){
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("address1");

        Administrator administrator = new Administrator("2","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "77085421");

        Customer customer = new Customer("3","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "77085421");


        customer.createNewAccount(new User[] {customer}, "m", 1000,"EUR");
        customer.createNewAccount(new User[] {customer}, "n", 1000,"EUR");

        Account a = new Account(new User[] {customer}, "m", 1000,"EUR");
        Account b = new Account(new User[] {customer}, "n", 1000,"EUR");


        a.setBalanceOnHold(500);
        a.setAvailableBalance(500);

        Action.accounts.add(a);
        Action.accounts.add(b);

        Action.Transfer(a.getAccountNumber(), b.getAccountNumber(), 500);
        customer.viewBalance();

        administrator.approveJobRequest(0);
        administrator.approveJobRequest(0);
        System.out.println("Monkey");
    }
}
