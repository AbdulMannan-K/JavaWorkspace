public class CurrentAccount extends BankAccount {

    CurrentAccount(String accountid, double balance) {
        super(accountid, balance);
    }

    void amountWithdrawn(double amount){
        if(super.getBalance()>5000)
            super.setBalance(super.getBalance()-amount);
        else
            System.out.println("Balance is less then 5000 so can't proceed");
    }

    void amountDeposit(double amount){
        super.setBalance(super.getBalance()+amount);
    }

}
