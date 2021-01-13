package Accounts;

import Users.Customer;

public class CreditCard extends Card{
    private double creditLimit;
    private double interestRate;
    private int daysBeforePayment;

    public CreditCard(Customer user, String validTo, String cvv, String accountNumber, String pin, boolean virtual, double limit) {
        super(user, validTo, cvv, accountNumber, pin, virtual, limit);
    }

    public CreditCard(Card card) {
        super(card);
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getDaysBeforePayment() {
        return daysBeforePayment;
    }

    public void setDaysBeforePayment(int daysBeforePayment) {
        this.daysBeforePayment = daysBeforePayment;
    }
}
