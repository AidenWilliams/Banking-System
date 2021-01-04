package Workflow;

import Accounts.*;
import Users.*;

import java.util.ArrayList;

//Ok nvm

public class JobRequest {
    public static int AddJobRequest(Object obj, String detail){
        Job.detail.add(detail);
        Job.item.add(obj);
        return Job.detail.size();
    }
    public static int AddJobRequest(Object obj1,Object obj2, String detail){
        Job.detail.add(detail);
        Job.detail.add(detail);
        Job.item.add(obj1);
        Job.item.add(obj2);
        return Job.detail.size();
    }
    public static int AddJobRequest(Object obj1,Object obj2, Object obj3, String detail){
        Job.detail.add(detail);
        Job.detail.add(detail);
        Job.detail.add(detail);
        Job.item.add(obj1);
        Job.item.add(obj2);
        Job.item.add(obj3);
        return Job.detail.size();
    }

    public static ArrayList<Account> getAccounts(User user){
        ArrayList<Account> searchResult = null;
        User[] ben;

        for (Account account : Job.accounts ){
            ben = account.getBeneficiaries();
            for (User b: ben)
                if(b == user)
                    searchResult.add(account);
        }
    return searchResult;
    }

    public static void RemoveJobRequest(int id){

    }
}
