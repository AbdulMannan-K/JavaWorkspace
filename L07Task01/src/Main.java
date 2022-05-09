public class Main {

    public static void main(String[] args){

        CurrentAccount currentAccount = new CurrentAccount("Mannan", 30000);
        currentAccount.amountWithdrawn(10000);
        System.out.println(currentAccount.BalanceInquiry());
        currentAccount.amountDeposit(10000);
        System.out.println(currentAccount.BalanceInquiry());

        SavingAccount savingAccount = new SavingAccount("Hannan" , 50000);
        savingAccount.amountDeposit(10000);
        System.out.println(savingAccount.BalanceInquiry());
        savingAccount.amountWithdrawn(10000);
        System.out.println(savingAccount.BalanceInquiry());


    }

}
