package Workflow;

import Accounts.*;
import Users.*;

import java.io.File;

public class JobRequest {
    String details;

    static String GetLastRequestIdentifier(){
        return "1";
    }

    public static void AddJobRequest(Account account, String details){
        //TODO: See if these work also do the get last one and ++
        Job.writeToFile(new File("/Data/Requests/Details/" + GetLastRequestIdentifier()), details);
        Job.writeToFile(new File("/Data/Requests/Accounts/" + GetLastRequestIdentifier()), account);
    }
    public static void RemoveJobRequest(){

    }
}
