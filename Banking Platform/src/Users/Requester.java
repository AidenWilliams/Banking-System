package Users;

public interface Requester {
    //Should be Debit and Credit Accounts
    void requestCreateNewDebitAccount(Customer[] beneficiaries, String accountNumber, double availableBalance, String currency);
    void requestCreateNewDebitAccount(Customer[] beneficiaries, String accountNumber, String currency);
    void requestCreateNewCreditAccount(Customer[] beneficiaries, String accountNumber, double availableBalance, String currency);
    void requestCreateNewCreditAccount(Customer[] beneficiaries, String accountNumber, String currency);
    void requestCloseAccount(String accountNumber);
    void requestAddCard(String accountNumber);
    void requestCloseCard(String accountNumber, String cardNumber);
}
