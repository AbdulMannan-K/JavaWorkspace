import java.io.*;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CheckingAccount extends Account{
    private int repeatidity=0;
    private int tax;
    private int allTax;
    private int interestRate;
    private boolean Interest;

    @Override
    void makeWithdrawal(int amount , int day, int month , int year , Customer customer) {
        if(!checkmonthRepedity(month,year))
            setTax(10);
        if(getAmount()<(amount+5000))
            System.out.println("\nYour account have not that much money!\n");
        else
            setAmount(getAmount()-amount);
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

    void makeInterest(){
        setAmount((getAmount())+ (getAmount())*((float)getInterestRate()/100));
        System.out.println("\nInterest has been added\n");
        setInterest(true);
    }

    public void setInterest(boolean interest) {
        Interest = interest;
    }

    public boolean isInterest() {
        return Interest;
    }

    @Override
    void makeDeposit(int amount, int day, int month, int year, Customer customer) {
        if(!checkmonthRepedity(month,year))
            setTax(10);
        super.makeDeposit(amount, day, month, year, customer);
    }

    @Override
    void transferAmount(int amount, String id, int day, int month, int year, Customer customer) {
        if(!checkmonthRepedity(month,year))
            setTax(10);
        super.transferAmount(amount, id, day, month, year, customer);
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getTax() {
        return tax;
    }

    public void setAllTax() {
        this.allTax = getAllTax()+getTax();
    }

    public int getAllTax() {
        return allTax;
    }

    public void setTax(int tax) {
        this.tax = tax;
        setAllTax();
        super.setAmount(super.getAmount()-10);
    }

    boolean checkmonthRepedity(int month, int year){
        try {
            repeatidity=0;
            FileReader fileReader = new FileReader("TransferRecord.txt");
            FileReader fileReader1 = new FileReader("DepositRecord.txt");
            FileReader fileReader2 = new FileReader("WithdrawRecord.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);

                int m,y;
                        st.nextToken();
                        st.nextToken();
                        st.nextToken();
                        st.nextToken();
                        st.nextToken();
                        String a = st.nextToken();
                        st.nextToken();
                        st.nextToken();
                        m = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        st.nextToken();
                        if (a.equals(getAccountNumber()))
                            if (month == m && year == y) {
                                repeatidity++;

                            }
                if (repeatidity > 2)
                    return false;
                    }
            reader = new BufferedReader(fileReader1);

            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);

                st.nextToken();st.nextToken();st.nextToken();st.nextToken();String a= st.nextToken();st.nextToken();st.nextToken();
                    int month1=Integer.parseInt(st.nextToken()); int year1 = Integer.parseInt(st.nextToken());st.nextToken();
                    if(a.equals(getAccountNumber()))
                        if (month == month1 && year == year1){
                            repeatidity++;
                        }
                if(repeatidity>2)
                    return false;

            }
            reader = new BufferedReader(fileReader2);

            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);

                st.nextToken();st.nextToken();st.nextToken();st.nextToken();String a= st.nextToken();st.nextToken();st.nextToken();
                    int month1=Integer.parseInt(st.nextToken()); int year1 = Integer.parseInt(st.nextToken());st.nextToken();
                    if(a.equals(getAccountNumber()))
                        if (month == month1 && year == year1){
                            repeatidity++;

                        }
                if(repeatidity>2)
                    return false;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    CheckingAccount(short pin){
        super.setPin(pin);
        setAmount(getAmount()+10);
        setTax(0);
        setInterestRate(Admin.getInterest());
        this.repeatidity=0;
        setInterest(false);
    }
}
