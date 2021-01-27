package Accounts;

import java.util.ArrayList;
/**
 *
 * <h1>Current Account Class</h1>
 *
 * <p>
 *     This banking system current account implementation. It has the special attribute of a chequebook. Which in this
 *     implementation is a list of transactions.
 * @see Account
 */
public class CurrentAccount extends Account{
    private ArrayList<Transaction> chequeBook = new ArrayList<>();

    /**
     * <p>
     * Constructor method to create a new account, all variables declared above must be initialised in order to create a
     * new account.
     * </p>
     *
     * @param beneficiaries    The beneficiaries of the account,for more information see also User
     *                         See <a href = https://en.wikipedia.org/wiki/Beneficiary>Beneficiary<a/>
     * @param number           Account Number
     * @param availableBalance The available balance
     * @param currency         The currency that the account is operating in
     */
    public CurrentAccount(String[] beneficiaries, String number, double availableBalance, String currency) {
        super(beneficiaries, number, availableBalance, currency);
    }
    /**
     * Copy constructor
     * @param account copied account
     */
    public CurrentAccount(Account account){
        super(account);
    }

    /**
     * @param transaction Transaction to be added to the cheque book
     */
    public void UseChequeBook(Transaction transaction){
        chequeBook.add(transaction);
    }
}
