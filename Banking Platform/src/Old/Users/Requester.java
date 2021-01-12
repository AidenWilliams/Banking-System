package Old.Users;

public interface Requester extends Basic{
    //TODO: Add javadoc

    /**
     *
     * @param beneficiaries
     * @param accountNumber
     * @param availableBalance
     * @param currency
     * @return
     */
    //make customer only raise requests
    int requestCreateNewAccount(User[] beneficiaries, String accountNumber, double availableBalance, String currency);
    int requestCreateNewAccount(User[] beneficiaries, String accountNumber, String currency);
    int requestAddCard(String accountNumber);
    int requestRemoveCard(String accountNumber, String cardNumber);
    int requestCloseAccount(String accountNumber);
    int requestDeleteAccount(String accountNumber);
    int requestTransferToAccount(String accountFrom, String accountTo, double amount);
}