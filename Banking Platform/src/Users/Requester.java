package Users;

public interface Requester {
    void requestCreateNewAccount(Customer[] beneficiaries, String accountNumber, double availableBalance, String currency);
    void requestCreateNewAccount(Customer[] beneficiaries, String accountNumber, String currency);
    void requestCloseAccount(String accountNumber);
    void requestAddCard(String accountNumber);
    void requestCloseCard(String accountNumber, String cardNumber);
}
