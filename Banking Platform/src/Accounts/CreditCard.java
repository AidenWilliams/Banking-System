package Accounts;

/**
 * <h1>Credit Card Class</h1>
 *
 * <p>
 *     This banking systems implementation of a credit card including special attributes that are unique to credit cards
 * </p>
 * @see Card
 */
public class CreditCard extends Card{
    private double creditLimit;
    private double interestRate;
    private int daysBeforePayment;

    /**
     * <p>
     *     Constructor method to create a new credit card, all variables declared above must be initialised in order to create a
     *     new card.
     * </p>
     * @param linkedTo The Account that this card is linked to
     * @param name Name on the card
     * @param surname Surname on the card
     * @param validTo The date till this car is valid to
     * @param cvv last 3 digits on the card/or any 3 digit combination the bank chooses
     * @param pin access pin for the card
     * @param virtual cards can be virtual i.e not have a physical card
     * @param limit spending limit
     * @param creditLimit the limit the customer can borrow by using this card
     * @param interestRate the interest rate at which credit interest is calculated
     * @see Account
     */
    public CreditCard(Account linkedTo, String name, String surname, String validTo, String cvv, String pin,
                      boolean virtual, double limit, double creditLimit, double interestRate) {
        super(linkedTo, name, surname, validTo, cvv, pin, virtual, limit);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    /**
     * Copy constructor
     * @param card Copied card
     */
    public CreditCard(Card card) {
        super(card);
    }

    /**
     * @return the limit the customer can borrow by using this card
     */
    public double getCreditLimit() {
        return creditLimit;
    }

    /**
     * @param creditLimit the limit the customer can borrow by using this card
     */
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * @return the interest rate at which credit interest is calculated
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interest rate at which credit interest is calculated
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the day limit before interest starts being calculated
     */
    public int getDaysBeforePayment() {
        return daysBeforePayment;
    }

    /**
     * @param daysBeforePayment the day limit before interest starts being calculated
     */
    public void setDaysBeforePayment(int daysBeforePayment) {
        this.daysBeforePayment = daysBeforePayment;
    }
}
