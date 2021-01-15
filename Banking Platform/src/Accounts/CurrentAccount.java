package Accounts;

import java.util.ArrayList;

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

    public CurrentAccount(Account account){
        super(account);
    }

    public void UseChequeBook(Transaction transaction){
        chequeBook.add(transaction);
    }
    public String viewChequeBook(){return "";}
}
