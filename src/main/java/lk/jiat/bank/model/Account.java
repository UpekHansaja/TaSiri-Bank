package lk.jiat.bank.model;

public class Account {

    private String accountNo;
    private String accountHolder;
    private double accountBalance;

    public Account(String accountNo, String accountHolder, double accountBalance) {
        this.accountNo = accountNo;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
