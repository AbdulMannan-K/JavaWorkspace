public class SavingAccount extends  BankAccount{

    SavingAccount(String accountid, double balance) {
        super(accountid, balance);
    }

    void amountWithdrawn(double amount){
        if(super.getBalance()>10000)
            super.setBalance(super.getBalance()-amount);
        else
            System.out.println("Balance is less then 10000 so can't proceed");
    }

    void amountDeposit(double amount){
        super.setBalance(super.getBalance()+amount);
    }
}
