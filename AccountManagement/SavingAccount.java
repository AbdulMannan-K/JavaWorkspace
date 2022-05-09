import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class SavingAccount extends Account{

    boolean isZakat = false;

    void calculateZakat(){
        if(getAmount()>=20000)
            System.out.println("\nZakat is : " + (getAmount()*2.5)/100 + "\n");
    }

    public boolean isZakat() {
        return isZakat;
    }

    public void setZakat(boolean zakat) {
        isZakat = zakat;
    }

    void deductZakat(){
        if(getAmount()>=20000){
            setAmount(getAmount()-((getAmount()*2.5)/100));
            System.out.println("\nZakat has been deducted\n");
            isZakat=true;
        }else
            System.out.println("\nZakat can't be deducted because amount is less than 20000");

        writeZakat();
    }

    @Override
    void makeWithdrawal(int amount , int day, int month , int year, Customer customer) {
        if(getAmount()<amount)
            System.out.println("\nYour account have not that much money!\n");
        else{
            setAmount(getAmount()-amount);
            System.out.println("\nThe " + amount + " is withdrawed from your account. Remaining Balance is : " + getAmount() + "\n");
        }
        try{
            FileWriter fileWriter = new FileWriter("WithdrawRecord.txt" , true);
            Formatter fmt = new Formatter(fileWriter);
            fmt.format("%-25s%25s%25s%25s%25s%25d%25d%25d%25d%25d\n" , "Withdraw: " , customer.getName() , customer.getPhone() , customer.getAdress() , getAccountNumber(), (int)getAmount() , day,month,year,amount );
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    void writeZakat(){
        try{
            FileWriter fileWriter = new FileWriter("ZakatRecord.txt");
            Formatter fmt = new Formatter(fileWriter);
            fmt.format("%-25s%25b\n" , getAccountNumber(), isZakat);
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    SavingAccount(short pin){
        super.setPin(pin);
    }
}
