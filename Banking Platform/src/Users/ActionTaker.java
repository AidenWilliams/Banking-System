package Users;

import Exceptions.InstructionNotFound;
import Exceptions.JobNotFound;
import Workflow.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ActionTaker extends Employee{

    /**
     * <p>
     * Constructor method to create a new User, all variables declared above must be initialised in order to create
     * a new User.
     * </p>
     *
     * @param id          Id of the User. Could be id card or passport number
     * @param name        Name of the User.
     * @param surname     Surname of the User.
     * @param addresses   Array of the user addresses, Must have at least 1.
     * @param DOB         Date of Birth of the user.
     * @param email       Email of the user.
     * @param phoneNumber Phone of the user.
     */
    ActionTaker(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }

    /**
     * @param JobID The job that will be completed.
     * @throws Exception During the job process, exceptions may be thrown
     */
    abstract void doJob(int JobID) throws Exception;

    /**
     * @param InstructionID Instruction that will be converted
     * @param job The new job
     * @param employee The new assignee
     * @throws InstructionNotFound throwable exception
     */
    abstract void instructionToJob(int InstructionID, Job job, Employee employee) throws InstructionNotFound;

    /**
     * @param clazz class object that is going to be filtered from items
     * @param items the list of items being filtered
     * @param <T> Generic Type
     * @return A filtered list of clazz instances
     */
    static <T> List<T> filter(Class<T> clazz, List<?> items){
        return items.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    /**
     * @param clazz class object that is going to be checked from items
     * @param items the list of items being checked
     * @param <T> Generic Type
     * @return Whether an instance of clazz is present or not.
     */
    static <T> Boolean isClassPresent(Class<T> clazz, List<?> items) {
        for (Object item: items) {
            if(item.equals(clazz)){
                return true;
            }
        }
        return false;
    }
}
