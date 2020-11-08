package Accounts;

public class CreditCard extends Card{
    private float creditLimit;
    private float interestRate;
    private int daysBeforePayment;


    public CreditCard(String name, String surname, String validTo, String cvv,
                      String pin, boolean virtual, short status, float limit,
                      float creditLimit, float interestRate, int daysBeforePayment,
                      Account account) {
        super(name, surname, validTo, cvv, pin, virtual, status, limit, account);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.daysBeforePayment = daysBeforePayment;
    }

    public float getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(float creditLimit) {
        this.creditLimit = creditLimit;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public int getDaysBeforePayment() {
        return daysBeforePayment;
    }

    public void setDaysBeforePayment(int daysBeforePayment) {
        this.daysBeforePayment = daysBeforePayment;
    }
}
