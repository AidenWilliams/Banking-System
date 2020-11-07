package Accounts;

public class DebitCard extends Card{
    private Account account;
    private float availableBalance;
    private float balanceOnHold;
    public DebitCard(String name, String surname, String number, String validTo, String cvv,
                     String pin, boolean virtual, short status, float limit) {
        super(name, surname, number, validTo, cvv, pin, virtual, status, limit);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public float getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(float availableBalance) {
        this.availableBalance = availableBalance;
        account.setAvailableBalance(availableBalance);
    }

    public float getBalanceOnHold() {
        return balanceOnHold;
    }

    public void setBalanceOnHold(float balanceOnHold) {
        this.balanceOnHold = balanceOnHold;
        account.setBalanceOnHold(balanceOnHold);
    }
}
