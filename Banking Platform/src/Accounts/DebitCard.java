package Accounts;

import Users.Customer;

public class DebitCard extends Card{
    public DebitCard(Customer user, String validTo, String cvv, String accountNumber, String pin, boolean virtual, double limit) {
        super(user, validTo, cvv, accountNumber, pin, virtual, limit);
    }

    public DebitCard(Card card) {
        super(card);
    }
}
