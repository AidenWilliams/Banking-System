package Launcher;

import Accounts.Account;
import Users.*;
import Workflow.Job;

import java.util.ArrayList;

public class Launcher {
    public static void main (String[] args){
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("address1");

        Job.startUp();

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

        Job.accounts.add(a);
        Job.accounts.add(b);

        Job.Transfer(a.getAccountNumber(), b.getAccountNumber(), 500);
        customer.viewBalance();
        System.out.println("Monkey");
    }
}
