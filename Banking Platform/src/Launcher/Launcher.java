package Launcher;

import Accounts.Account;
import Users.*;
import Workflow.Job;

import java.util.ArrayList;
import java.util.Collections;

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
    }
}
