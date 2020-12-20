package Launcher;

import Accounts.*;
import Workflow.*;
import Users.*;

import java.util.ArrayList;
import java.util.Collections;

public class Launcher {

    public static void main (String[] args){
//        ArrayList<String> arrayList = new ArrayList<>();
//
//        arrayList.add("address1");
//        Administrator administrator = new Administrator("2","Aiden", "Williams", arrayList,
//                "20/09/2020", "aiden.williams.19@um.edu.mt", "77085421");

        // new User("c123", "cname", "csurname", "c1234", "c12345", "c1@2.com", "c12343")
        User[] users = {
                new User("123", "name", "surname",
                            new ArrayList<String>() {{  add("A");add("B");add("C");}},
                        "12345", "1@2.com", "12343")};

        Account account = new Account(users, "accountNumber", 1000.01, "currency");
        JobRequest.AddJobRequest(account,"CreateNewAccount");
    }
}
