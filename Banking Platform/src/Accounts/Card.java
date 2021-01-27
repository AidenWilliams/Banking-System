package Accounts;

import Workflow.Status;

/**
 * <h1>Super Card Class</h1>
 *
 * <p>
 *     The account class holds variables that are common to all types of cards in the banking system.
 *     Cases where Account will be used
 * </p>
 * <ul>
 *     <li>Debit Card</li>
 *     <li>Credit Card</li>
 * </ul>
 *
 * @see DebitCard
 * @see CreditCard
 */
public abstract class Card{
    private final Account linkedTo;
    private final String name;
    private final String surname;
    private final String validTo;
    private final String CVV;
    private final boolean virtual;
    private String PIN;
    private Status status;
    private double limit;

    /**
     * <p>
     *     Constructor method to create a new card, all variables declared above must be initialised in order to create a
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
     * @see Account
     */
    public Card(Account linkedTo, String name, String surname, String validTo, String cvv,
                String pin, boolean virtual, double limit){
        this.linkedTo = linkedTo;
        this.name = name;
        this.surname = surname;
        this.validTo = validTo;
        this.CVV = cvv;
        this.virtual = virtual;
        this.PIN = pin;
        this.status = Status.approved;
        this.limit = limit;
    }

    /**
     * Copy constructor
     * @param card Copied card
     */
    public Card(Card card){
        this.linkedTo = card.linkedTo;
        this.name = card.name;
        this.surname = card.surname;
        this.validTo = card.validTo;
        this.CVV = card.CVV;
        this.virtual = card.virtual;
        this.PIN = card.PIN;
        this.status = card.status;
        this.limit = card.limit;
    }

    /**
     * @return the name on the card
     */
    public String getName() {
        return name;
    }

    /**
     * @return the surname on the card
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return till which date the card is valid to
     */
    public String getValidTo() {
        return validTo;
    }

    /**
     * @return last 3 digits on the card/or any 3 digit combination the bank chooses
     */
    public String getCVV() {
        return CVV;
    }

    /**
     * @return whether a card is virtual or not
     */
    public boolean isVirtual() {
        return virtual;
    }

    /**
     * @return The access pin
     */
    public String getPIN() {
        return PIN;
    }

    /**
     * @param PIN Allows the access pin to be changed
     */
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    /**
     * @return the card number wich is equal to the account's number it is linked to
     */
    public String getNumber() {
        return linkedTo.getNumber();
    }

    /**
     * @return the status of the card
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status of the card
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return spending limit
     */
    public double getLimit() {
        return limit;
    }

    /**
     * @param limit spending limit
     */
    public void setLimit(double limit) {
        this.limit = limit;
    }
}
