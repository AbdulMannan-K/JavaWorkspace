import java.io.*;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public abstract class Account {

    private double amount;
    private String AccountNumber;
    private short pin;


    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public short getPin() {
        return pin;
    }

    public void setPin(short pin) {
        this.pin = pin;
    }

    public double getAmount() {
        return amount;
    }

    public void setAccountNumber(int location, int accountType) {

        switch (location) {
            case 1 -> {
                if (accountType == 1)
                    do {
                        AccountNumber = ("1" + "1" + ((int) Math.floor(Math.random() * (99999 - 10000 + 1) + 10000)));
                    } while (!checkRepeadity(AccountNumber));
                else
                    do {
                        AccountNumber = ("2" + "1" + ((int) Math.floor(Math.random() * (99999 - 10000 + 1) + 10000)));
                    } while (!checkRepeadity(AccountNumber));

            }
            case 2 -> {
                if (accountType == 2)
                    do {
                        AccountNumber = ("2" + "2" + ((int) Math.floor(Math.random() * (99999 - 10000 + 1) + 10000)));
                    } while (!checkRepeadity(AccountNumber));
                else
                    do {
                        AccountNumber = ("1" + "2" + ((int) Math.floor(Math.random() * (99999 - 10000 + 1) + 10000)));
                    } while (!checkRepeadity(AccountNumber));
            }
            default -> throw new IllegalStateException("Unexpected value: " + location);
        }
    }

    public void setAccountNumber(String id) {
        this.AccountNumber = id;
    }

    void makeDeposit(int amount, int day, int month, int year, Customer customer) {
        setAmount(getAmount() + amount);
        try {
            FileWriter fileWriter = new FileWriter("DepositRecord.txt", true);
            Formatter fmt = new Formatter(fileWriter);
            fmt.format("%-25s%25s%25s%25s%25s%25d%25d%25d%25d%25d\n", "Deposit: ", customer.getName(), customer.getPhone(), customer.getAdress(), getAccountNumber(), (int)getAmount(), day, month, year, amount);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract void makeWithdrawal(int amount, int day, int month, int year, Customer customer);


    void checkBalance(Customer customer) {
        System.out.println("\nThe name of user is : " + customer.getName() + "\nAmount is : " + getAmount() + "\n");
    }

    void printStatement(Customer customer) {
            System.out.println("\nThe name of user : " + customer.getName() + "\nadress of user is : " + customer.getAdress() + "\nNumber of user is : " + customer.getPhone() );
            System.out.println("Account Id of user is : " + getAccountNumber() + "\nRemaining Balance : " + getAmount() + "\n");

    }

    void transferAmount(int amount, String id, int day, int month, int year, Customer customer) {
        if (amount <= getAmount())
            setAmount(getAmount() - amount);
        else
            System.out .println("Not enough amount");
        try {
            FileWriter fileWriter = new FileWriter("TransferRecord.txt", true);
            Formatter fmt = new Formatter(fileWriter);
            fmt.format("%-25s%25s%25s%25s%25s%25s%25d%25d%25d%25d%25d\n", "TransferMoney: ", customer.getName(), id, customer.getPhone(), customer.getAdress(), getAccountNumber(), (int)getAmount(), day, month, year, amount);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void gettransferedAmount(int amount, String id, int day, int month, int year, Customer customer) {
        setAmount(getAmount() + amount);
        try {
            FileWriter fileWriter = new FileWriter("TransferredRecord.txt", true);
            Formatter fmt = new Formatter(fileWriter);
            fmt.format("%-25s%25s%25s%25s%25s%25s%25d%25d%25d%25d%25d\n", "ReceivedMoney: ", customer.getName(), id, customer.getPhone(), customer.getAdress(), getAccountNumber(), (int)getAmount(), day, month, year, amount);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean checkRepeadity(String id) {
        try {
            File file = new File("AccountNumbers.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                if (id.equals(scan.nextLine()))
                    return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    void displayallDidactions(int type, Customer customer) {
        if(type==1)
            customer.savingAccount.calculateZakat();
        else
            System.out.println("The total tax deducted is : " + customer.checkingAccount.getAllTax());

    }

    void displayTransaction(int type) {
        try {
            FileReader fileReader = new FileReader("TransferRecord.txt");
            FileReader fileReader1 = new FileReader("DepositRecord.txt");
            FileReader fileReader2 = new FileReader("WithdrawRecord.txt");
            FileReader fileReader3 = new FileReader("TransferredRecord.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            switch (type) {
                case 1 -> {
                    String a = "", b = "", c = "", d = "", e = "", f = "", g = "", h = "", i = "", j = "", k = "";
                    while ((line = reader.readLine()) != null) {
                        StringTokenizer st = new StringTokenizer(line);
                        a = st.nextToken();
                        b = st.nextToken();
                        c = st.nextToken();
                        d = st.nextToken();
                        e = st.nextToken();
                        f = st.nextToken();
                        g = st.nextToken();
                        h = st.nextToken();
                        i = st.nextToken();
                        j = st.nextToken();
                        k = st.nextToken();
                        if (f.equals(getAccountNumber())) {
                            System.out.println();
                            System.out.println("Name : " + b + "\tReceived by : " + c + "\tPhone Number is : " + d);
                            System.out.println("Adress : " + e);
                            System.out.println("account number : " + f);
                            System.out.println("Date : " + h + "/" + i + "/" + j);
                            System.out.println("Amount sent : " + k);
                            System.out.println();
                        }
                    }

                }
                case 2 -> {
                    String a = "", b = "", c = "", d = "", e = "", f = "", g = "", h = "", i = "", j = "", k = "";
                    reader = new BufferedReader(fileReader1);
                    while ((line = reader.readLine()) != null) {
                        StringTokenizer st = new StringTokenizer(line);
                        a = st.nextToken();
                        b = st.nextToken();
                        c = st.nextToken();
                        d = st.nextToken();
                        e = st.nextToken();
                        f = st.nextToken();
                        g = st.nextToken();
                        h = st.nextToken();
                        i = st.nextToken();
                        j = st.nextToken();
                        if (e.equals(getAccountNumber())) {
                            System.out.println();
                            System.out.println("Name : " + b + "\tPhone Number : " + c + "\tPhone NumberAdress is : " + d);
                            System.out.println("Account id  : " + e);
                            System.out.println("Date : " + g + "/" + h + "/" + i);
                            System.out.println("Amount Deposited : " + j);
                            System.out.println();
                        }

                    }
                }
                case 3 -> {
                    String a = "", b = "", c = "", d = "", e = "", f = "", g = "", h = "", i = "", j = "", k = "";
                    reader = new BufferedReader(fileReader2);
                    while ((line = reader.readLine()) != null) {
                        StringTokenizer st = new StringTokenizer(line);
                        a = st.nextToken();
                        b = st.nextToken();
                        c = st.nextToken();
                        d = st.nextToken();
                        e = st.nextToken();
                        f = st.nextToken();
                        g = st.nextToken();
                        h = st.nextToken();
                        i = st.nextToken();
                        j = st.nextToken();
                        if (e.equals(getAccountNumber())) {
                            System.out.println();
                            System.out.println("Name : " + b + "\tPhone Number : " + c + "\tPhone NumberAdress is : " + d);
                            System.out.println("Account id  : " + e);
                            System.out.println("Date : " + g + "/" + h + "/" + i);
                            System.out.println("Amount Withdrawed : " + j);
                            System.out.println();
                        }

                    }
                }
                case 4 -> {
                    String a = "", b = "", c = "", d = "", e = "", f = "", g = "", h = "", i = "", j = "", k = "";
                    reader = new BufferedReader(fileReader3);
                    while ((line = reader.readLine()) != null) {
                        StringTokenizer st = new StringTokenizer(line);
                        a = st.nextToken();
                        b = st.nextToken();
                        c = st.nextToken();
                        d = st.nextToken();
                        e = st.nextToken();
                        f = st.nextToken();
                        g = st.nextToken();
                        h = st.nextToken();
                        i = st.nextToken();
                        j = st.nextToken();
                        k = st.nextToken();
                        if (f.equals(getAccountNumber())) {
                            System.out.println("Name : " + b + "\tSent by : " + c + "\tPhone Number is : " + d);
                            System.out.println("Adress : " + e);
                            System.out.println("account number : " + f);
                            System.out.println("Date : " + h + "/" + i + "/" + j);
                            System.out.println("Amount recieved : " + k);
                            System.out.println();
                        }
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Account(){
        setAmount(0);
    }

}
