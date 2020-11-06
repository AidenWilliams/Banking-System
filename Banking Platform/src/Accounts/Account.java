package Accounts;
import Users.User;

/**
 *
 * <h1>Account Super Class</h1>
 *
 * <p>
 *     The account class holds variables that are common to all types of accounts in the banking system.
 *     It is important to note that in this solution a user account on the system is <U>NOT</U> considered
 *     an Account but is considered a User
 *
 *     Cases where Account will be used
 * </p>
 * <ul>
 *     <li>Current Account</li>
 *     <li>Savings Account</li>
 * </ul>
 *
 * @author aiden
 * @version 1.0
 */
public class Account {
    private User[] beneficiaries;
    private final String IBAN;
    private String accountNumber;
    private String currency;
    private float availableBalance;
    private boolean status;

    /**
     * <p>
     *     Constructor method to create a new account, all variables declared above must be initialised in order to create a
     *     new account.
     * </p>
     *
     * @param beneficiaries The beneficiaries of the account,for more information see also User
     * See <a href = https://en.wikipedia.org/wiki/Beneficiary>Beneficiary<a/>
     * @param IBAN IBAN number for the account
     * See <a href = https://en.wikipedia.org/wiki/International_Bank_Account_Number>IBAN</a>
     * @param accountNumber Account Number
     * @param availableBalance The available balance
     * @param currency The currency that the account is operating in
     * @param status Status of the account
     *     <ul>
     *         <li>True = Active</li>
     *         <Li>False = Not Active</Li>
     *     </ul>
     * @see User
     */
    public Account(User[] beneficiaries, String IBAN, String accountNumber,
                   float availableBalance, String currency, boolean status) {
        this.beneficiaries = beneficiaries;
        this.IBAN = IBAN;
        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;
        this.currency = currency;
        this.status = status;
    }

    /**
     * @return The beneficiary of the account
     */
    public User[] getBeneficiary() {
        return beneficiaries;
    }

    /**
     * @param beneficiary Sets the beneficiary for the account
     */
    public void setBeneficiary(User[] beneficiary) {
        this.beneficiaries = beneficiary;
    }

    /**
     * @return Account IBAN
     */
    public String getIBAN() {
        return IBAN;
    }

    /**
     * @return The unique internal account number, different from the IBAN
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber The unique internal account number, different from the IBAN
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return The currency in which this account is opened on
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency in which this account is opened on
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return The Account balance
     */
    public float getAvailableBalance() {
        return availableBalance;
    }

    /**
     * @param availableBalance The Account balance
     */
    public void setAvailableBalance(float availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * @return Returns the BIC
     * @see <a href=https://en.wikipedia.org/wiki/ISO_9362>BIC</a>
     */
    public String getBIC() {
        return "AIDENBANK1";
    }

    /**
     * @return Status of the account, as described in the constructor
     * @see Account
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status The status of the account
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return Whether the account is joint or not
     */
    public boolean isJoint(){
        return beneficiaries.length != 0;
    }
}
