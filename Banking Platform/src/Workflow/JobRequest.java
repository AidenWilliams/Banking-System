package Workflow;

import Accounts.*;
import Users.*;

import java.util.ArrayList;

//Ok nvm

public class JobRequest {


    public static int AddJobRequest(Object obj, String detail){
        Action.pendingJobs.add(new Job(obj, detail));
        Action.pendingJobs.get(Action.pendingJobs.size() - 1).setStage(1);
        return Action.pendingJobs.size();
    }
    public static int AddJobRequest(Object obj1, Object obj2, String detail){
        ArrayList<Object> details = new ArrayList<>();
        details.add(obj1);
        details.add(obj2);
        Action.pendingJobs.add(new Job(details, detail));
        Action.pendingJobs.get(Action.pendingJobs.size() - 1).setStage(1);
        return Action.pendingJobs.size();
    }
    public static int AddJobRequest(Object obj1,Object obj2, Object obj3, String detail){
        ArrayList<Object> details = new ArrayList<>();
        details.add(obj1);
        details.add(obj2);
        details.add(obj3);
        Action.pendingJobs.add(new Job(details, detail));
        Action.pendingJobs.get(Action.pendingJobs.size() - 1).setStage(1);
        return Action.pendingJobs.size();
    }

    public static ArrayList<Account> getUserAccounts(User user){
        ArrayList<Account> searchResult = new ArrayList<>();
        User[] ben;

        for (Account account: Action.accounts ){
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
