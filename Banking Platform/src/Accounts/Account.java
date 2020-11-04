package Accounts;

import Users.User;

public class Account {
    private User beneficiary;
    private String IBAN;
    private String accountNumber;
    private String currency;
    private float availableBalance;
    private final String BIC = "AIDENBANK1";
    private boolean status;

    public Account(User beneficiary, String IBAN, String accountNumber,
                   float availableBalance, String currency, boolean status) {
        this.beneficiary = beneficiary;
        this.IBAN = IBAN;
        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;
        this.currency = currency;
        this.status = status;
    }

    public User getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(User beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(float availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getBIC() {
        return BIC;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
