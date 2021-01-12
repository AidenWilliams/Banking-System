package Accounts;

public class Transaction {
    String detail;
    String from;
    String to;
    double amount;

    public Transaction(String detail, String from, String to, double amount) {
        this.detail = detail;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getDetail() {
        return detail;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }
}
