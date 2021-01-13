package Accounts;

import Users.Customer;

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
     * @see User
     */
    public SavingsAccount(Customer[] beneficiaries, String number, double availableBalance, String currency) {
        super(beneficiaries, number, availableBalance, currency);
    }

    public SavingsAccount(Account account){
        super(account);
    }
}
