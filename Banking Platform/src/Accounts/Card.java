package Accounts;

import Old.Accounts.Account;
import Users.Customer;
import Old.Users.User;
import Workflow.Status;

// In banking cards are their own account
public abstract class Card {
    //TODO: Add javadoc
    final private Customer user;
    final private String validTo;
    final private String number;
    final private String CVV;
    final private boolean virtual;
    private String PIN;
    private Status status;
    private double limit;

    public Card(Customer user, String validTo, String cvv, String accountNumber,
                String pin, boolean virtual, double limit){
        this.user = user;
        //get old style of creating this
        this.number = accountNumber;
        this.validTo = validTo;
        this.CVV = cvv;
        this.virtual = virtual;
        this.PIN = pin;
        this.status = new Status();
        this.status.markApproved();
        this.limit = limit;
    }

    public Card(Card card){
        this.user = card.user;
        //get old style of creating this
        this.number = card.number;
        this.validTo = card.validTo;
        this.CVV = card.CVV;
        this.virtual = card.virtual;
        this.PIN = card.PIN;
        this.status = new Status();
        this.status.markApproved();
        this.limit = card.limit;
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

    public String getNumber() {
        return number;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
