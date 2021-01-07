package Workflow;

import Accounts.*;
import Users.*;

import java.util.ArrayList;

//Ok nvm

public class JobRequest {
    public static int AddJobRequest(ArrayList<Object> objList, String detail){
        Action.pendingJobs.add(new Job(objList, detail));
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
