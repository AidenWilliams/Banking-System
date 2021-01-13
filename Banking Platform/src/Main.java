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


        regular.requestCreateNewAccount(new CurrentAccount(), new Customer[]{customer}, "12345", "EUR");
        /*
            public RetailCustomer(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email,
                   String phoneNumber, ArrayList<Account> accounts) {
        */
    }
}
