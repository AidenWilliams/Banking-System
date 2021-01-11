package Accounts;

import Users.User;
// In banking cards are their own account
public class Card extends Account{
    //TODO: Add javadoc
    final private User user;
    final private String validTo;
    final private String CVV;
    final private boolean virtual;
    private String PIN;
    private short status;
    private double limit;

    public Card(User user, String validTo, String cvv,
                String pin, boolean virtual, short status, double limit,
                Account account){
        super(account);
        this.user = user;
        this.setNumber(account.getNumber() + account.getCards().size());
        this.validTo = validTo;
        this.CVV = cvv;
        this.virtual = virtual;
        this.PIN = pin;
        this.status = status;
        this.limit = limit;
    }

    public String getName() {
        return user.getName();
    }

    public String getSurname() {
        return user.getSurname();
    }

    public String getValidTo() {
        return validTo;
    }

    public String getCVV() {
        return CVV;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
