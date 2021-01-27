package Accounts;

/**
 * <h1>Debit Card Class</h1>
 *
 * <p>
 *     Debit card implementation where no extra attributes are needed
 * </p>
 * @see Card
 */
public class DebitCard extends Card{

    /**
     * <p>
     * Constructor method to create a debit card, all variables declared above must be initialised in order to create a
     * new card.
     * </p>
     *
     * @param linkedTo The Account that this card is linked to
     * @param name     Name on the card
     * @param surname  Surname on the card
     * @param validTo  The date till this car is valid to
     * @param cvv      last 3 digits on the card/or any 3 digit combination the bank chooses
     * @param pin      access pin for the card
     * @param virtual  cards can be virtual i.e not have a physical card
     * @param limit    spending limit
     * @see Account
     */
    public DebitCard(Account linkedTo, String name, String surname, String validTo, String cvv, String pin, boolean virtual, double limit) {
        super(linkedTo, name, surname, validTo, cvv, pin, virtual, limit);
    }

    /**
     * Copy constructor
     *
     * @param card Copied card
     */
    public DebitCard(Card card) {
        super(card);
    }
}
