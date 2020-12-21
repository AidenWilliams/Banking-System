package Accounts;

import Users.User;

public class SavingsAccount extends Account{
    /**
     * <p>
     * Constructor method to create a new account, all variables declared above must be initialised in order to create a
     * new account.
     * </p>
     *
     * @param beneficiaries    The beneficiaries of the account,for more information see also User
     *                         See <a href = https://en.wikipedia.org/wiki/Beneficiary>Beneficiary<a/>
     * @param IBAN             IBAN number for the account
     *                         See <a href = https://en.wikipedia.org/wiki/International_Bank_Account_Number>IBAN</a>
     * @param accountNumber    Account Number
     * @param availableBalance The available balance
     * @param currency         The currency that the account is operating in
     * @see User
     */
    public SavingsAccount(User[] beneficiaries, String IBAN, String accountNumber, float availableBalance, String currency) {
        super(beneficiaries, IBAN, accountNumber, availableBalance, currency);
    }
}
