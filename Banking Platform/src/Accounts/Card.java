package Accounts;

import Users.User;
// In banking cards are their own account
public class Card extends Account{
    //TODO: Add javadoc
    final private String name;
    final private String surname;
    final private String number;
    final private String validTo;
    final private String CVV;
    final private boolean virtual;
    private String PIN;
    private short status;
    private float limit;

    public Card(String name, String surname, String validTo, String cvv,
                String pin, boolean virtual, short status, float limit,
                Account account){
        super(account);
        this.name = name;
        this.surname = surname;
        this.number = account.getAccountNumber();
        this.validTo = validTo;
        this.CVV = cvv;
        this.virtual = virtual;
        this.PIN = pin;
        this.status = status;
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
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

    public float getLimit() {
        return limit;
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }
}
