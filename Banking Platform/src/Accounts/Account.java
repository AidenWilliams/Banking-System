package Accounts;
import Users.User;
import Workflow.Status;

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
 * @see CurrentAccount
 * @see SavingsAccount
 */
public abstract class Account {
    private String[] beneficiaries;
    private final String IBAN;
    private String number;
    private String currency;
    private double availableBalance;
    private double balanceOnHold;
    private Status status;
    private ArrayList<Card> cards;
    private final ArrayList<Transaction> transactions;

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
    public Account(String[] beneficiaries, String number,
                   double availableBalance, String currency) {
        this.beneficiaries = beneficiaries;
        this.IBAN = "MT38" + getBIC() + number;
        this.number = number;
        this.availableBalance = availableBalance;
        this.balanceOnHold = 0f;
        this.currency = currency;
        this.status = Status.approved;
        this.transactions = new ArrayList<>();
    }

    /**
     * Copy constructor
     * @param account copied account
     */
    public Account(Account account) {
        this.beneficiaries = account.beneficiaries;
        this.IBAN = account.IBAN;
        this.number = account.number;
        this.availableBalance = account.availableBalance;
        this.balanceOnHold = 0f;
        this.currency = account.currency;
        this.status = account.status;
        this.cards = account.cards;
        this.transactions = account.transactions;
    }

    /**
     * @return The beneficiary of the account
     */
    public String[] getBeneficiaries() {
        return beneficiaries;
    }

    /**
     * @param beneficiaries Sets the beneficiary for the account
     */
    public void setBeneficiaries(String[] beneficiaries) {
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
//    ?move setters to users?
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

    /**
     * @return The account balance that is on hold
     */
    public double getBalanceOnHold() {
        return balanceOnHold;
    }

    /**
     * @param balanceOnHold The account balance that is on hold
     */
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
     */
    public Status isStatus() {
        return status;
    }

    /**
     * @param status The status of the account
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return Whether the account is joint or not
     */
    public boolean isJoint(){
        return beneficiaries.length != 0;
    }

    /**
     * Returns
     * @return all the cards for this account
     * @see Card
     */
    public ArrayList<Card>  getCards() {
        return cards;
    }

    /**
     * Adds a card
     * @param card card to be added to the account
     * @see Card
     */
    public void addCard(Card card) {
        this.cards.add(card);
    }

    /**
     * removes the card with number
     * @param number the card number
     */
    public void removeCard(String number) {
        this.cards.removeIf(c -> c.getNumber().equals(number));
    }

    /**
     * Adds a transaction to the account
     * @param transaction transaction to be added
     * @see Transaction
     */
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    /**
     * @return ArrayList of all the transactions of the account
     */
    public ArrayList<Transaction> getTransactions(){
        return this.transactions;
    }

    public Status getStatus() {
        return status;
    }
}
