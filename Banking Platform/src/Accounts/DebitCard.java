package Accounts;
//The default Card is a debit card
public class DebitCard extends Card{
    public DebitCard(String name, String surname, String validTo, String cvv,
                     String pin, boolean virtual, short status, float limit,
                     Account account) {
        super(name, surname, validTo, cvv, pin, virtual, status, limit, account);
    }
}
