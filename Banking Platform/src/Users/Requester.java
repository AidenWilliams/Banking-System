package Users;

import Accounts.Account;
import Accounts.Card;

public interface Requester {
    //Should be Debit and Credit Accounts
    void requestCreateNewAccount(Account type, Customer[] beneficiaries, String accountNumber, double availableBalance, String currency);
    void  requestCreateNewAccount(Account type, Customer[] beneficiaries, String accountNumber, String currency);
    //void requestCreateNewCreditAccount(Customer[] beneficiaries, String accountNumber, double availableBalance, String currency);
    //void requestCreateNewCreditAccount(Customer[] beneficiaries, String accountNumber, String currency);
    void requestCloseAccount(Card type, String accountNumber);
    void requestAddCard(String accountNumber);
    void requestCloseCard(String accountNumber, String cardNumber);
}
