package Users;

import Accounts.Account;
import Accounts.Card;

public interface Requester {
    //Should be Debit and Credit Accounts
    <T> void requestCreateNewAccount(Class<T> type, Customer[] beneficiaries, String accountNumber, double availableBalance, String currency);
    <T> void requestCreateNewAccount(Class<T> type, Customer[] beneficiaries, String accountNumber, String currency);
    void requestCloseAccount(String accountNumber);
    <T> void requestAddCard(Class<T> type, String accountNumber);
    void requestCloseCard(String accountNumber, String cardNumber);
}
