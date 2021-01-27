package Accounts;

/**
 * <h1>Transaction Class</h1>
 *
 * <p>
 *     A transaction represents a transaction in the bank and could be used for logging and accounting purposes.
 *     Once a transaction is created it cannot be changed.
 * </p>
 */
public class Transaction {
    private final String detail;
    private final String from;
    private final String to;
    private final double amount;

    /**
     * @param detail Special details of the transaction, e.g. reason why the money is being transacted
     * @param from reason why the money is being transacted
     * @param to Account number that is receiving the money
     * @param amount Cash that is being transacted
     */
    public Transaction(String detail, String from, String to, double amount) {
        this.detail = detail;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    /**
     * @return reason why the money is being transacted
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @return reason why the money is being transacted
     */
    public String getFrom() {
        return from;
    }

    /**
     * @return Account number that is receiving the money
     */
    public String getTo() {
        return to;
    }

    /**
     * @return Cash that is being transacted
     */
    public double getAmount() {
        return amount;
    }
}
