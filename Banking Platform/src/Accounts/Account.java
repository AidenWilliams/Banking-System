package Accounts;
import Users.User;

import java.util.ArrayList;

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
 * @version 1.1
 */
public class Account {
    private User[] beneficiaries;
    private final String IBAN;
    private String number;
    private String currency;
    private double availableBalance;
    private double balanceOnHold;
    private boolean status;
    private ArrayList<Card> cards;

    /**
     * <p>
     *     Constructor method to create a new account, all variables declared above must be initialised in order to create a
     *     new account.
     * </p>
     *
     * @param beneficiaries The beneficiaries of the account,for more information see also User
     * See <a href = https://en.wikipedia.org/wiki/Beneficiary>Beneficiary<a/>
     * @param number Account Number
     * @param availableBalance The available balance
     * @param currency The currency that the account is operating in
     * @see User
     */
    public Account(User[] beneficiaries, String number,
                   double availableBalance, String currency) {
        this.beneficiaries = beneficiaries;
        this.IBAN = "MT38" + getBIC() + number;
        this.number = number;
        this.availableBalance = availableBalance;
        this.balanceOnHold = 0f;
        this.currency = currency;
        this.status = true;
    }

    protected Account(Account account){
        this.beneficiaries = account.beneficiaries;
        this.IBAN = account.IBAN;
        this.number = account.number;
        this.availableBalance = account.availableBalance;
        this.balanceOnHold = account.balanceOnHold;
        this.currency = account.currency;
        this.status = account.status;
        this.cards = account.cards;
    }
    //TODO: Add javadoc to cards
    /**
     * @return The beneficiary of the account
     */
    public User[] getBeneficiaries() {
        return beneficiaries;
    }

    /**
     * @param beneficiaries Sets the beneficiary for the account
     */
    public void setBeneficiaries(User[] beneficiaries) {
        this.beneficiaries = beneficiaries;
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
    public String getNumber() {
        return number;
    }

    /**
     * @param number The unique internal account number, different from the IBAN
     */
    public void setNumber(String number) {
        this.number = number;
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
    public double getAvailableBalance() {
        return availableBalance;
    }

    /**
     * @param availableBalance The Account balance
     */
    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public double getBalanceOnHold() {
        return balanceOnHold;
    }

    public void setBalanceOnHold(double balanceOnHold) {
        this.balanceOnHold = balanceOnHold;
    }

    /**
     * @return Returns the BIC
     * @see <a href=https://en.wikipedia.org/wiki/ISO_9362>BIC</a>
     */
    public String getBIC() {
        return "AIDENBANK1";
    }

    /**
     * @return Status of the account
     * <ul>
     *      <li>True = Active</li>
     *      <Li>False = Not Active</Li>
     * </ul>
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

    public ArrayList<Card>  getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    //touch this
    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.removeIf(c -> c == card);
    }
}
