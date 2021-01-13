package Old.Accounts;

import Old.Users.User;

//The default Card is a debit card
public class DebitCard extends Card{

    public DebitCard(User user, String validTo, String cvv, String pin, boolean virtual, short status, double limit, Account account) {
        super(user, validTo, cvv, pin, virtual, status, limit, account);
    }
}