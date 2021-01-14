import Accounts.*;
import Users.*;
import Workflow.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("address1");

        Administrator administrator = new Administrator("2","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "77085421");

        Regular regular = new Regular("1","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "77085421");

        RetailCustomer customer = new RetailCustomer("3","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "77085421");

        RetailCustomer customer2 = new RetailCustomer("4","Aiden", "Williams", arrayList,
                "20/09/2020", "aiden.williams.19@um.edu.mt", "77085421");
        regular.requestCreateNewCustomer(customer);
        regular.requestCreateNewCustomer(customer2);

        //Do request create customer
        regular.requestCreateNewAccount(SavingsAccount.class, new Customer[]{customer}, "12345",1000, "EUR");
        regular.requestCreateNewAccount(SavingsAccount.class, new Customer[]{customer2}, "12345",1000, "EUR");
        administrator.approveJobRequest(0, regular);
        administrator.approveJobRequest(1, regular);
        System.out.println(regular.viewJobs());
        regular.doJob(1);
        System.out.println(regular.viewJobs());
        regular.doJob(0);
        System.out.println(regular.viewJobs());
    }
}
