public class BankAccount {
    protected String accountid;
    protected double balance;

    protected double BalanceInquiry() {
        return balance;
    }
    
    BankAccount(String accountid , double balance){
        this.accountid=accountid;
        this.balance=balance;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountid() {
        return accountid;
    }
}
