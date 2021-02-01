import Accounts.*;
import Exceptions.AccountNotFound;
import Exceptions.InstructionNotFound;
import Exceptions.JobNotFound;
import Users.*;
import Workflow.*;
import java.util.ArrayList;

public class Main {

    public static void CreateEmployees(){
        BankSystem.start();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("address1");
        Administrator administrator = new Administrator("2","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "77085421");

        Regular regular = new Regular("1","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "77085421");

        System.out.println(administrator.getId());
        System.out.println(regular.getId());
    }

    public static void CreateCustomer(){
        BankSystem.start();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("address1");
        Administrator administrator = new Administrator("2","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "1");

        Regular regular = new Regular("1","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "2");

        RetailCustomer customer = new RetailCustomer("3","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "3");

        RetailCustomer customer2 = new RetailCustomer("4","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "4");

        regular.requestCreateNewCustomer(customer);
        regular.requestCreateNewCustomer(customer2);

        try {
            administrator.removeJobRequest(0);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        System.out.println(regular.viewJobs());
        try {
            regular.doJob(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Account Not Created Yet");
        System.out.println(BankSystem.customers.size());
        try {
            regular.doJob(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Job not yet Approved");
        System.out.println(BankSystem.customers.size());
        try {
            administrator.approveJobRequest(1, regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        System.out.println("Job Now Approved");
        try {
            regular.doJob(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Job Done");
        System.out.println(BankSystem.customers.size());
    }

    public static void CreateAccounts(){
        BankSystem.start();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("address1");
        Administrator administrator = new Administrator("2","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "1");

        Regular regular = new Regular("1","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "2");

        RetailCustomer customer = new RetailCustomer("3","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "3");

        RetailCustomer customer2 = new RetailCustomer("4","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "4");

        regular.requestCreateNewCustomer(customer);
        regular.requestCreateNewCustomer(customer2);
        try {
            administrator.approveJobRequest(0,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            administrator.approveJobRequest(1,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            regular.doJob(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            regular.doJob(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        regular.requestCreateNewAccount(SavingsAccount.class, new String[]{customer.getId()}, "12345",1000, "EUR");
        regular.requestCreateNewAccount(SavingsAccount.class, new String[]{customer2.getId()}, "12346",500, "EUR");
        try {
            administrator.approveJobRequest(2,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            administrator.approveJobRequest(3,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            regular.doJob(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            regular.doJob(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(regular.viewJobs());
        try {
            System.out.println(BankSystem.getAccount("12345").getAvailableBalance());
        } catch (AccountNotFound accountNotFound) {
            accountNotFound.printStackTrace();
        }
        try {
            System.out.println(BankSystem.getAccount("12346").getAvailableBalance());
        } catch (AccountNotFound accountNotFound) {
            accountNotFound.printStackTrace();
        }
    }

    public static void Transact(){
        BankSystem.start();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("address1");
        Administrator administrator = new Administrator("2","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "1");

        Regular regular = new Regular("1","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "2");

        RetailCustomer customer = new RetailCustomer("3","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "3");

        RetailCustomer customer2 = new RetailCustomer("4","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "4");

        regular.requestCreateNewCustomer(customer);
        regular.requestCreateNewCustomer(customer2);
        try {
            administrator.approveJobRequest(0,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            administrator.approveJobRequest(1,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            regular.doJob(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            regular.doJob(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        regular.requestCreateNewAccount(SavingsAccount.class, new String[]{customer.getId()}, "12345",1000, "EUR");
        regular.requestCreateNewAccount(SavingsAccount.class, new String[]{customer.getId()}, "12346",200, "EUR");
        regular.requestCreateNewAccount(SavingsAccount.class, new String[]{customer2.getId()}, "12347",500000, "EUR");
        try {
            administrator.approveJobRequest(2,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            administrator.approveJobRequest(3,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            administrator.approveJobRequest(4,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            regular.doJob(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            regular.doJob(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            regular.doJob(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            regular.doJob(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // All accounts and customers created
        // Do transactions
        System.out.println("Before Transaction Available/On Hold");
        try {
            System.out.println(BankSystem.getAccount("12345").getAvailableBalance());
            System.out.println(BankSystem.getAccount("12345").getBalanceOnHold());
        } catch (AccountNotFound accountNotFound) {
            accountNotFound.printStackTrace();
        }
        try {
            System.out.println(BankSystem.getAccount("12346").getAvailableBalance());
            System.out.println(BankSystem.getAccount("12346").getBalanceOnHold());
        } catch (AccountNotFound accountNotFound) {
            accountNotFound.printStackTrace();
        }
        customer.requestTransferToAccount("Test", "12345", "12346", 600);
        System.out.println("After Transaction Available/On Hold");
        try {
            System.out.println(BankSystem.getAccount("12345").getAvailableBalance());
            System.out.println(BankSystem.getAccount("12345").getBalanceOnHold());
        } catch (AccountNotFound accountNotFound) {
            accountNotFound.printStackTrace();
        }
        try {
            System.out.println(BankSystem.getAccount("12346").getAvailableBalance());
            System.out.println(BankSystem.getAccount("12346").getBalanceOnHold());
        } catch (AccountNotFound accountNotFound) {
            accountNotFound.printStackTrace();
        }

        System.out.println("Before Large Transaction Available/On Hold");
        try {
            System.out.println(BankSystem.getAccount("12347").getAvailableBalance());
            System.out.println(BankSystem.getAccount("12347").getBalanceOnHold());
        } catch (AccountNotFound accountNotFound) {
            accountNotFound.printStackTrace();
        }
        customer2.requestTransferToAccount("Test", "12347", "12346", 10000);
        System.out.println("After Large Transaction Available/On Hold");
        try {
            System.out.println(BankSystem.getAccount("12347").getAvailableBalance());
            System.out.println(BankSystem.getAccount("12347").getBalanceOnHold());
        } catch (AccountNotFound accountNotFound) {
            accountNotFound.printStackTrace();
        }
        try {
            System.out.println(BankSystem.getAccount("12346").getAvailableBalance());
            System.out.println(BankSystem.getAccount("12346").getBalanceOnHold());
        } catch (AccountNotFound accountNotFound) {
            accountNotFound.printStackTrace();
        }
        try {
            administrator.approveJobRequest(5, regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            regular.doJob(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("After Job Completion Large Transaction Available/On Hold");
        try {
            System.out.println(BankSystem.getAccount("12347").getAvailableBalance());
            System.out.println(BankSystem.getAccount("12347").getBalanceOnHold());
            System.out.println(BankSystem.getAccount("12346").getAvailableBalance());
            System.out.println(BankSystem.getAccount("12346").getBalanceOnHold());
        } catch (AccountNotFound accountNotFound) {
            accountNotFound.printStackTrace();
        }
    }

    public static void Instruct(){
        BankSystem.start();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("address1");
        Administrator administrator = new Administrator("2","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "1");

        Regular regular = new Regular("1","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "2");

        RetailCustomer customer = new RetailCustomer("3","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "3");

        regular.requestCreateNewCustomer(customer);
        try {
            administrator.approveJobRequest(0,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            regular.doJob(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        regular.requestCreateNewAccount(SavingsAccount.class, new String[]{customer.getId()}, "12345",1000, "EUR");
        try {
            administrator.approveJobRequest(1,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            regular.doJob(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        customer.addInstruction("Close Account 12345");
        try {
            regular.instructionToJob(0, new Job("12345","Close Account"), regular);
        } catch (InstructionNotFound instructionNotFound) {
            instructionNotFound.printStackTrace();
        }
        try {
            administrator.approveJobRequest(2,regular);
        } catch (JobNotFound jobNotFound) {
            jobNotFound.printStackTrace();
        }
        try {
            regular.doJob(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(BankSystem.getAccount("12345").getStatus().isApproved());
        } catch (AccountNotFound accountNotFound) {
            accountNotFound.printStackTrace();
        }
    }

    public static void main(String[] args){
        if(args[0].equals("CreateEmployees")) CreateEmployees();
        if(args[0].equals("CreateCustomer")) CreateCustomer();
        if(args[0].equals("CreateAccounts")) CreateAccounts();
        if(args[0].equals("Transact")) Transact();
        if(args[0].equals("Instruction")) Instruct();
    }
}
