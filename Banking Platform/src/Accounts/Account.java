package Accounts;

import Users.User;

/**
 *
 * <h1> Account Super Class </h1>
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
    private String IBAN;
    private String accountNumber;
    private String currency;
    private float availableBalance;
    private final String BIC = "AIDENBANK1";
    private boolean status;


    /**
     * <p>
     *     Constructor method to create a new account, all variables declared above must be initialised in order to create a
     *     new account.
     * </p>
     *
     * @param beneficiaries
     *  <p>
     *      The beneficiaries of the account more information see also User
     *      If there are two beneficiaries then the account is considered a joint account
     *  </p>
     *  @see User
     * @param IBAN
     * <p>IBAN number for the account</p>
     * @param accountNumber
     * <p>Account Number</p>
     * @param availableBalance
     * <p>The available balance</p>
     * @param currency
     * <p>The currency that the account is operating in</p>
     * @param status
     * <p>
     *     Status of the account
     *     <ul>
     *         <li>True = Active</li>
     *         <Li>False = Not Active</Li>
     *     </ul>
     * </p>
     *
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

    // Zid Java docs al kollox
    public void setBeneficiary(User[] beneficiary) {
        this.beneficiaries = beneficiary;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(float availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getBIC() {
        return BIC;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isJoint(){
        return beneficiaries.length != 0;
    }
}
