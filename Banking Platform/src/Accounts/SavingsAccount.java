package Accounts;
/**
 *
 * <h1>Savings Account Class</h1>
 *
 * <p>
 *     This banking system current account implementation. This class has no special attributes
 * @see Account
 */
public class SavingsAccount extends Account{
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
    public SavingsAccount(String[] beneficiaries, String number, double availableBalance, String currency) {
        super(beneficiaries, number, availableBalance, currency);
    }
    /**
     * Copy constructor
     * @param account copied account
     */
    public SavingsAccount(Account account){
        super(account);
    }
}
