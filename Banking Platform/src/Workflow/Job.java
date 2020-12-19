package Workflow;

import java.io.*;

public class Job {
    static void AddAccount(){
        //Change those account details
    }
    static void AmendAccount(){
        //Change those account details
    }
    static void ViewAccount(){
        //Get detail from account
    }
    static void DeleteAccount(){
        //Remove the account from the file
    }
    static void AddUser(){
        //Write User to file
    }
    static void AmendUser(){
        //Change those user details
    }
    static void DeleteUser(){
        //Remove the account from the file
    }

    public static void writeToFile(File path, Object data)
    {
        try(ObjectOutputStream write= new ObjectOutputStream (new FileOutputStream(path)))
        {
            write.writeObject(data);
        }
        catch(NotSerializableException nse)
        {
            System.out.println("Not Serializable");
        }
        catch(IOException eio)
        {
            System.out.println("Exception");
        }
    }


    public static Object readFromFile(File path)
    {
        Object data = null;

        try(ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(path)))
        {
            data = inFile.readObject();
            return data;
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("Class not found");
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("File not found");
        }
        catch(IOException e)
        {
            System.out.println("Exception");
        }
        return data;
    }

}
