package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Employee extends User {
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
    Employee(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email, String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }
    // Reasoning is that all employees can view their joblit and do the job hey want to
    abstract String viewJobs();
    static <T> List<T> filter(Class<T> clazz, List<?> items) {
        return items.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    static <T> Boolean isClassPresent(Class<T> clazz, List<?> items) {
        for (Object item: items) {
            if(item.equals(clazz)){
                return true;
            }
        }
        return false;
    }
}
