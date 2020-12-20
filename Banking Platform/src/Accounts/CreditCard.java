package Accounts;

public class CreditCard extends Card{
    private double creditLimit;
    private double interestRate;
    private int daysBeforePayment;


    public CreditCard(String name, String surname, String validTo, String cvv,
                      String pin, boolean virtual, short status, double limit,
                      double creditLimit, double interestRate, int daysBeforePayment,
                      Account account) {
        super(name, surname, validTo, cvv, pin, virtual, status, limit, account);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.daysBeforePayment = daysBeforePayment;
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
