import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bank {
     static ArrayList<Customer> customers = new ArrayList<>();

    void read(){
        try{
            FileReader fileReader = new FileReader("AccountRecord.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while((line=reader.readLine())!=null){
                StringTokenizer st = new StringTokenizer(line);
                String name =st.nextToken();
                String address = st.nextToken();
                String phone = st.nextToken();
                String acc1 = st.nextToken();
                String acc2 = st.nextToken();
                String pin1 = st.nextToken();
                String pin2 = st.nextToken();
                customers.add(new Customer(name,address,phone));
                for (Customer customer : customers){
                    if(customer.getName().equals(name)){
                        if(!acc1.equals("N") && !acc2.equals("N")){
                            customer.setSaving(true);
                            customer.setChecking(true);
                            customer.setAccountNumber(3,Short.parseShort(pin1),Short.parseShort(pin2));
                            customer.savingAccount.setAccountNumber(acc1);
                            customer.checkingAccount.setAccountNumber(acc2);
                            customer.savingAccount.setAmount(Integer.parseInt(st.nextToken()));
                            customer.checkingAccount.setAmount(Integer.parseInt(st.nextToken()));
                        }else if(!acc1.equals("N")) {
                            customer.setSaving(true);
                            customer.setAccountNumber(1,Short.parseShort(pin1),Short.parseShort(pin2));
                            customer.savingAccount.setAccountNumber(acc1);
                            customer.savingAccount.setAmount(Integer.parseInt(st.nextToken()));
                            st.nextToken();
                        }else if(!acc2.equals("N")){
                            customer.setChecking(true);
                            customer.setAccountNumber(2,Short.parseShort(pin1),Short.parseShort(pin2));
                            customer.checkingAccount.setAccountNumber(acc2);
                            st.nextToken();
                            customer.checkingAccount.setAmount(Integer.parseInt(st.nextToken()));
                        }
                    }
                }
                File file= new File("ZakatRecord.txt");
                Scanner scan = new Scanner(file);
                String id ;
                if(scan.hasNext()){
                    id = scan.next();
                    for(Customer customer : customers) {
                        if(customer.isSaving())
                            if (customer.savingAccount.getAccountNumber().equals(id)) {
                                customer.savingAccount.setZakat(scan.nextBoolean());
                                if(scan.hasNext())
                                    id = scan.next();
                            }
                    }
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    void showMenu(){
        Scanner scan = new Scanner(System.in);
        int choice;
        do {

            System.out.println("Enter what you want to do : \n1- Open a New Account\n2- Close an Account\n3- Login to Account\n4- Admin Things\n0- Exit");
             choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    int choice1;
                    do{
                        System.out.print("Are you already a customer of Bank : \n1- Yes\n2- No");
                        choice1 = scan.nextInt();
                    }while (choice1!=1 && choice1!=2);
                    switch (choice1){
                        case 1 -> {
                            System.out.print("Enter Name(without space) : ");
                            String name = scan.next();
                            for(Customer customer : customers)
                                if(customer.getName().equals(name))
                                    if (customer.isSaving() && customer.isChecking())
                                        System.out.println("\nYou already have both saving and checking account in bank you can't make more!\n");
                                    else if (customer.isSaving()) {
                                        System.out.print("\nYou have a saving account in Bank Already\nIf you want to make checking account also press 1\n");
                                        choice1 = scan.nextInt();
                                        if (choice1 == 1) {
                                            short pin;
                                            do {
                                                System.out.print("\nEnter 4 digit pin for your checking account: ");
                                                pin = scan.nextShort();
                                                if (pin < 999 || pin > 9999)
                                                    System.out.println("4 digit pin is required, not more , nor less");
                                            } while (pin < 999 || pin > 9999);
                                            customer.setChecking(true);
                                            openAccount(pin, 2, customer);
                                        }
                                    }
                                    else if(customer.isChecking()){
                                        System.out.print("\nYou have a Checking account in Bank Already\nIf you want to make saving account also press 1\n");
                                        choice1 = scan.nextInt();
                                        if(choice1==1){
                                            short pin;
                                            do {
                                                System.out.print("\nEnter 4 digit pin for your checking account: ");
                                                pin = scan.nextShort();
                                                if (pin < 999 || pin > 9999)
                                                    System.out.println("4 digit pin is required, not more , nor less");
                                            } while (pin < 999 || pin > 9999);
                                            customer.setSaving(true);
                                            openAccount(pin,1,customer);
                                        }
                                    }
                        }
                        case 2 -> {
                            String name;int i=0;
                            do {
                                i=0;
                                System.out.print("Enter Name : ");
                                name = scan.next();
                                for (Customer customer : customers) {
                                    if (name.equals(customer.getName())) {
                                        System.out.println("Enter name again, this one already exists");
                                        i = 1;
                                        break;
                                    }
                                }
                            }while (i==1);
                            System.out.print("Enter adress(without space) : ");
                            String adress = scan.next();
                            System.out.print("Enter phone : ");
                            String phone = scan.next();
                            short pin;
                            do {
                                System.out.print("Enter your new 4 digit pin : ");
                                pin = scan.nextShort();
                                if(pin<999||pin>9999)
                                    System.out.println("Pin should be 4 digits!");
                            }while (pin<999||pin>9999);
                            openAccount(name, adress, phone, pin);
                        }
                    }
                    write();
                }
                case 2 -> {
                    int option;
                    do {
                        System.out.print("Do you want to clear your bank account instance or you want to clear all your data:\n1- clear Instance\n2- clear all data");
                        option = scan.nextInt();
                        if(option!=1&&option!=2)
                            System.out.println("\nTheir are only 2 options so please enter 1 or 2\n");
                    }while (option!=1&&option!=2);
                    switch (option) {
                        case 1 -> {
                            int option1;
                            do {
                                System.out.print("Enter your account type that you want to remove :\n1- Saving\n2- Checking :");
                                option1 = scan.nextInt();
                                if(option1!=1&&option1!=2)
                                    System.out.println("\nTheir are only 2 options so please enter 1 or 2\n");
                            }while (option1!=1&&option1!=2);
                            System.out.print("Enter your account number : ");
                            String id = scan.next();
                            System.out.print("Enter your pin : ");
                            short pin = scan.nextShort();
                            closeAccount(id,pin,option1);
                        }
                        case 2 -> {
                            System.out.print("Enter your account number : ");
                            String id = scan.next();
                            System.out.print("Enter your pin : ");
                            short pin = scan.nextShort();
                            closeAccount(id,pin);
                        }
                    }
                    write();
                }
                case 3 -> {
                    int check;
                    do {
                        System.out.print("Enter your account type :\n1- Saving\n2- Checking : ");
                        check = scan.nextInt();
                        if(check!=1&&check!=2)
                            System.out.println("\nTheir are only 2 options so please enter 1 or 2\n");
                    }while (check!=1&&check!=2);
                    System.out.print("Enter your account number : ");
                    String id = scan.next();
                    System.out.print("Enter your pin : " );
                    short pin = scan.nextShort();
                    loginAccount(check,id, pin);
                    write();
                }
                case 4 -> {
                    System.out.print("\n Enter Password : ");
                    adminThings(scan.next());
                }
                case 0 -> {
                    write();
                    System.exit(0);
                }
            }
        }while (choice!=0);
    }

    void openAccount(String name, String adress, String phone, short pin){
        boolean isHere=true;
        Scanner scan = new Scanner(System.in);
        customers.add(new Customer(name,adress,phone));
        int location;
        do {
            System.out.print("Enter Your Location : \n1- Pakistan\n2- Abroad : ");
            location = scan.nextInt();
            if(location!=1&&location!=2)
                System.out.println("\nTheir are only 2 options so please enter 1 or 2\n");
        }while (location!=1&&location!=2);
        int choice;
        do{
            System.out.print("Enter Your account type which you want : \n1- Saving\n2- Checking : ");
            choice = scan.nextInt();
            if(choice!=1&&choice!=2)
                System.out.println("\nTheir are only 2 options so please enter 1 or 2\n");
        }while (choice!=1&&choice!=2);
        for (Customer customer : customers) {
            isHere=true;
            if (customer.getName().equals(name)) {
                if (choice == 1)
                    customer.setSaving(true);
                else
                    customer.setChecking(true);
                customer.setAccount(location, choice, pin);
                if (choice == 1)
                    System.out.println("You account created sucesfully for name " + customer.getName() + " your account id is : " + customer.savingAccount.getAccountNumber());
                else
                    System.out.println("You account created sucesfully for name " + customer.getName() + " your account id is : " + customer.checkingAccount.getAccountNumber());
            } else
                isHere = false;
        }

        if(!isHere)
            System.out.println("Account not present!");
        write();
    }
    void openAccount(short pin,int type,Customer customer){
        Scanner scan = new Scanner(System.in);
        int location;
        do {
            System.out.print("Enter Your Location : \n1- Pakistan\n2- Abroad : ");
            location = scan.nextInt();
        }while (location!=1&&location!=2);
                if(type==1){
                    customer.setAccount(location,1,pin);
                    System.out.println("\nYour saving account account created sucesfully for name " +  customer.getName() + " your account id is : " + customer.savingAccount.getAccountNumber() + "\n");
                }
                else if(type==2){
                    customer.setAccount(location,2,pin);
                    System.out.println("\nYour checking account created sucesfully for name " +  customer.getName() + " your account id is : " + customer.checkingAccount.getAccountNumber() + "\n");
                }
        write();
    }

    void closeAccount(String id,short pin){
        for(int i=0 ; i < customers.size() ; i++) {

            if (customers.get(i).isSaving()) {
                if (customers.get(i).savingAccount.getAccountNumber().equals(id) && customers.get(i).savingAccount.getPin() == pin) {
                    customers.remove(i);
                    System.out.println("Saving Account removed succesfully");
                    break;
                }
            }
            if (customers.get(i).isChecking()) {
                if (customers.get(i).checkingAccount.getAccountNumber().equals(id) && customers.get(i).checkingAccount.getPin() == pin) {
                    customers.remove(i);
                    System.out.println("Checking Account removed succesfully");
                    break;
                }
            }
        }
        write();
    }
    void closeAccount(String id,short pin, int type){
        for (Customer customer : customers) {

            if (type == 1) {
                if (customer.savingAccount.getAccountNumber().equals(id) && customer.savingAccount.getPin() == pin) {
                    customer.savingAccount.setPin((short) 0);
                    customer.savingAccount.setAccountNumber("N");
                    customer.setSaving(false);
                    customer.savingAccount = null;
                    System.out.println("Account removed successfully");
                    break;
                }
            }
            else if (type == 2) {
                if (customer.checkingAccount.getAccountNumber().equals(id) && customer.checkingAccount.getPin() == pin) {
                    customer.checkingAccount.setPin((short) 0);
                    customer.checkingAccount.setAccountNumber("N");
                    customer.setChecking(false);
                    customer.checkingAccount = null;
                    System.out.println("Account removed successfully");
                    break;
                }
            }
        }
        write();
    }

    void loginAccount(int type , String id, short pin){
        boolean isHere= true;
        for( int i=0 ;i< customers.size() ; i++) {
            switch (type){
                case 1 -> {
                    if(customers.get(i).isSaving())
                        if (customers.get(i).savingAccount.getAccountNumber().equals(id) && customers.get(i).savingAccount.getPin() == pin) {
                            isHere=true;
                            System.out.println("\nLogin Successful, proceeding to options ... \n");
                            showLogin(i,type,id);
                        }else if(customers.get(i).savingAccount.getAccountNumber().equals(id) && customers.get(i).savingAccount.getPin()!=pin){
                            System.out.println("\nPin is not correct! Try again later\n");
                        }else
                            isHere=false;
                }
                case 2 -> {
                    if(customers.get(i).isChecking())
                        if (customers.get(i).checkingAccount.getAccountNumber().equals(id) && customers.get(i).checkingAccount.getPin() == pin) {
                            isHere=true;
                            System.out.println("Login Successful, proceeding to options ... \n");
                            showLogin(i,type,id);
                        }else if(customers.get(i).checkingAccount.getAccountNumber().equals(id) && customers.get(i).checkingAccount.getPin()!=pin){
                            System.out.println("\nPin is not correct! Try again later\n");
                        }else
                            isHere=false;
                }
            }
        }
        if(!isHere)
            System.out.println("\nAccount not found!\n");
    }

    void showLogin(int i,int type,String id){
        Scanner scan = new Scanner(System.in);
        int choice;

        do{
            if(type==1){
                System.out.println("Enter what you want to do :\n1- Deposit amount\n2- Withdraw amount\n3- Check Balance\n4- Account Info\n5- Transfer Amount");
                System.out.println("6- Display all Deduction\n7- Transaction History\n8- Zakat Options\n0- Logout");
                choice = scan.nextInt();
            }else{
                System.out.println("Enter what you want to do :\n1- Deposit amount\n2- Withdraw amount\n3- Check Balance\n4- Account Info\n5- Transfer Amount");
                System.out.println("6- Display all Deduction\n7- Transaction History\n8- Interest Rate\n0- Logout");
                choice = scan.nextInt();
            }


            switch (choice){
                case 1 -> {
                    System.out.print("Enter how much amount you want to deposit : ");
                    int amount = scan.nextInt();
                    int day;
                    do {
                        System.out.print("Enter the day : ");
                         day = scan.nextInt();
                         if(day<1||day>31)
                             System.out.println("\nDay must be from 1 to 31\n");
                    }while(day<1||day>30);
                    int month;
                    do {
                        System.out.print("Enter the month : ");
                        month = scan.nextInt();
                        if(month<1||month>12)
                            System.out.println("\nMonth must be from 1 to 12\n");
                    }while (month<1||month>12);
                    System.out.print("Enter the year : ");
                    int year = scan.nextInt();
                    switch (type){
                        case 1 -> customers.get(i).savingAccount.makeDeposit(amount,day,month,year,customers.get(i));
                        case 2 -> customers.get(i).checkingAccount.makeDeposit(amount,day,month,year,customers.get(i));
                    }
                }
                case 2 -> {
                    System.out.print("Enter how much amount you want to Withdraw : ");
                    int amount = scan.nextInt();
                    int day;
                    do {
                        System.out.print("Enter the day : ");
                        day = scan.nextInt();
                        if(day<1||day>31)
                            System.out.println("\nDay must be from 1 to 31\n");
                    }while(day<1||day>30);
                    int month;
                    do {
                        System.out.print("Enter the month : ");
                        month = scan.nextInt();
                        if(month<1||month>12)
                            System.out.println("\nMonth must be from 1 to 12\n");
                    }while (month<1||month>12);
                    System.out.print("Enter the year : ");
                    int year = scan.nextInt();
                    switch (type){
                        case 1 -> customers.get(i).savingAccount.makeWithdrawal(amount,day,month,year,customers.get(i));
                        case 2 -> customers.get(i).checkingAccount.makeWithdrawal(amount,day,month,year,customers.get(i));
                    }
                }
                case 3 -> {
                    switch (type){
                        case 1 -> customers.get(i).savingAccount.checkBalance(customers.get(i));
                        case 2 -> customers.get(i).checkingAccount.checkBalance(customers.get(i));
                    }
                }
                case 4 -> {
                    switch (type){
                        case 1 -> customers.get(i).savingAccount.printStatement(customers.get(i));
                        case 2 -> customers.get(i).checkingAccount.printStatement(customers.get(i));
                    }
                }
                case 5 ->{
                    System.out.print("Enter how much amount you want to Transfer : ");
                    int amount = scan.nextInt();
                    switch (type){
                        case 1 -> {
                            if(customers.get(i).savingAccount.getAmount()<amount){
                                System.out.println("\nThis much amount is not present in account\nProceeding to Main menu\n");
                                showMenu();
                            }
                        }
                        case 2 -> {
                            if(customers.get(i).checkingAccount.getAmount()<amount){
                                System.out.println("\nThis much amount is not present in account\nProceeding to Main menu\n");
                                showMenu();
                            }
                        }
                    }
                    System.out.print("Enter the id to which you want to Transfer : ");
                    String id2 = scan.next();
                    int id1= Integer.parseInt(id2);
                    id1 = firstDigit(id1);
                    int day,month,year;
                    do {
                        System.out.print("Enter the day : ");
                        day = scan.nextInt();
                        if(day<1||day>31)
                            System.out.println("\nDay must be from 1 to 31\n");
                    }while(day<1||day>30);
                    do {
                        System.out.print("Enter the month : ");
                        month = scan.nextInt();
                        if(month<1||month>12)
                            System.out.println("\nMonth must be from 1 to 12\n");
                    }while (month<1||month>12);
                    System.out.print("Enter the year : ");
                     year = scan.nextInt();
                    boolean isfound =true;
                    for(Customer customer : customers){
                        if(customer.isSaving())
                            if(id1==1){
                                if(customer.savingAccount.getAccountNumber().equals(id2)) {
                                    isfound=true;
                                    if (type == 1)
                                        customer.savingAccount.gettransferedAmount(amount, customers.get(i).savingAccount.getAccountNumber(), day, month, year, customer);
                                    else if (type == 2)
                                        customer.savingAccount.gettransferedAmount(amount, customers.get(i).checkingAccount.getAccountNumber(), day, month, year, customer);
                                    System.out.println("\n");

                                    break;

                                }else
                                    isfound=false;
                            }
                        if(customer.isChecking())
                            if(id1 ==2){
                                if(customer.checkingAccount.getAccountNumber().equals(id2)) {
                                    isfound=true;
                                    if (type == 1)
                                        customer.checkingAccount.gettransferedAmount(amount, customers.get(i).savingAccount.getAccountNumber(), day, month, year, customer);
                                    else if (type == 2)
                                        customer.checkingAccount.gettransferedAmount(amount, customers.get(i).checkingAccount.getAccountNumber(), day, month, year, customer);

                                    System.out.println("\n");
                                    break;
                                }else
                                    isfound=false;
                            }
                    }
                    if(!isfound)
                        System.out.println("\nAccount to which money has to transfer is not found!\n");

                    switch (type){
                        case 1 -> customers.get(i).savingAccount.transferAmount(amount,id2,day,month,year,customers.get(i));
                        case 2 -> customers.get(i).checkingAccount.transferAmount(amount,id2,day,month,year,customers.get(i));
                    }
                }
                case 6 -> {
                    boolean isfound = false;
                    int id1= Integer.parseInt(id);
                    id1 = firstDigit(id1);
                    if(id1==1){
                        if(id.equals(customers.get(i).savingAccount.getAccountNumber()))
                            customers.get(i).savingAccount.displayallDidactions(1,customers.get(i));
                        else
                            System.out.println("Account not found!");
                    }
                    else if(id1 == 2){
                        if(id.equals(customers.get(i).checkingAccount.getAccountNumber()))
                            customers.get(i).checkingAccount.displayallDidactions(2,customers.get(i));
                        else
                            System.out.println("Account not found!");
                    }
                }
                case 7 -> {
                    int id1= Integer.parseInt(id);
                    id1 = firstDigit(id1);
                    int option;
                    do {
                        System.out.println("Enter which history you want to see : \n1- Transaction History \n2- Deposit History \n3- Withdraw History\n4- Recieved amount History : ");
                        option = scan.nextInt();
                        if(option!=1&&option!=2&&option!=3&&option!=4)
                            System.out.println("\nEnter options from 1 to 4\n");
                    }while (option!=1&&option!=2&&option!=3&&option!=4);
                    if(id1==1)
                        customers.get(i).savingAccount.displayTransaction(option);
                    else
                        customers.get(i).checkingAccount.displayTransaction(option);

                }
                case 8 -> {
                    if(type==1){
                        int option;
                        do {
                            System.out.print("Enter Options: \n1- Show Zakat\n2- Deduct Zakat");
                            option=scan.nextInt();
                            if(option!=1&&option!=2)
                                System.out.println("\nSelect from 1 or 2. Not other than that!");
                        }while (option!=1&&option!=2);
                        switch (option){
                            case 1-> {
                                customers.get(i).savingAccount.calculateZakat();
                            }
                            case 2 -> {
                                if(customers.get(i).savingAccount.isZakat)
                                    System.out.println("\nZakat has already been deducted!\n");
                                else{
                                    customers.get(i).savingAccount.deductZakat();
                                }

                            }
                        }
                    }else{
                        int option;
                        do {
                            System.out.print("Enter Options: \n1- Show Interest Rate\n2- Change InterestRate\n3- Make Interest Rate in account : ");
                            option=scan.nextInt();
                            if(option!=1&&option!=2&&option!=3)
                                System.out.println("\nSlect from 1 to 3. Not other than that!");
                        }while (option!=1&&option!=2&&option!=3);
                        switch (option){
                            case 1-> {
                                System.out.println("\nInterest Rate is : " + customers.get(i).checkingAccount.getInterestRate() + "%\n");
                            }
                            case 2 -> {
                                System.out.print("Enter new Interest Rate in percent : ");
                                int rate = scan.nextInt();
                                customers.get(i).checkingAccount.setInterestRate(rate);
                            }
                            case 3 -> {
                                if(customers.get(i).checkingAccount.isInterest())
                                    System.out.println("\ninterest has already been added!\n");
                                else{
                                    customers.get(i).checkingAccount.makeInterest();
                                }
                            }
                        }
                    }

                }
            }
        }while (choice!=0);

    }

    public void adminThings(String pass){
        write();
        Scanner scan = new Scanner(System.in);
        if(Admin.getPassword().equals(pass)){
            int option;
            do{
                System.out.print("What do you want :\n1- See zakat deduction Record\n2- Change Interest Rate : \n3- Change Password\n4- See all acounts detail: ");
                option = scan.nextInt();
                if(option!=1&&option!=2&&option!=3&&option!=4)
                    System.out.println("\nSelect from 1 to 4. Not other than that!");
            }while (option!=1&&option!=2&&option!=3&&option!=4);
            if(option==1){
                for(Customer customer : customers){
                    if(customer.isSaving()){
                        customer.savingAccount.writeZakat();
                        System.out.println("Account number : " + customer.savingAccount.getAccountNumber() + " has given zakat : " + customer.savingAccount.isZakat);
                    }
                }
            }else if(option==2){
                System.out.print("Enter new Interest Rate : ");
                Admin.setInterest(scan.nextInt());
            }else if(option==3){
                System.out.print("Emter new Password : ");
                String passw = scan.next();
                try {
                    FileWriter fileWriter = new FileWriter("pass.txt");
                    fileWriter.write(passw);
                    fileWriter.flush();
                    fileWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                Admin.setPassword();
            }else {
                for(Customer customer : customers){
                    if(customer.isSaving())
                        customer.savingAccount.printStatement(customer);
                    if(customer.isChecking())
                        customer.checkingAccount.printStatement(customer);
                }
            }
        }else {
            System.out.println("\nWrong Password\n");
        }
    }

    public void write(){
        try{
            FileWriter fileWriter = new FileWriter("AccountRecord.txt" );
            FileWriter fileWriter1 = new FileWriter("AccountNumbers.txt");
            Formatter fmt = new Formatter(fileWriter);
            for (Customer customer : customers)
                if(customer.isSaving() && customer.isChecking())
                    fmt.format("%-25s%25s%25s%25s%25s%25d%25d%25d%25d\n", customer.getName(), customer.getAdress(), customer.getPhone() , customer.savingAccount.getAccountNumber(), customer.checkingAccount.getAccountNumber() ,customer.savingAccount.getPin() , customer.checkingAccount.getPin() ,(int)customer.savingAccount.getAmount() , (int)customer.checkingAccount.getAmount());
                else if(customer.isSaving())
                    fmt.format("%-25s%25s%25s%25s%25s%25d%25d%25d%25d\n", customer.getName(), customer.getAdress(), customer.getPhone(), customer.savingAccount.getAccountNumber(), "N" , customer.savingAccount.getPin() , 0, (int)customer.savingAccount.getAmount(),0 );
                else if(customer.isChecking())
                    fmt.format("%-25s%25s%25s%25s%25s%25d%25d%25d%25d\n", customer.getName(), customer.getAdress(), customer.getPhone(), "N" ,customer.checkingAccount.getAccountNumber(),0 ,  customer.checkingAccount.getPin(), 0 , (int)customer.checkingAccount.getAmount() );

            for(Customer customer : customers) {
                if (customer.isSaving() && customer.isChecking())
                    fileWriter1.write(customer.savingAccount.getAccountNumber() + "\n" + customer.checkingAccount.getAccountNumber() + "\n");
                else if (customer.isSaving())
                    fileWriter1.write(customer.savingAccount.getAccountNumber() + "\n");
                else
                    fileWriter1.write(customer.checkingAccount.getAccountNumber() + "\n");
                break;
            }

            fileWriter1.flush();
            fileWriter1.close();
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    int firstDigit(int x) {
        while (x > 9) {
            x /= 10;
        }
        return x;
    }


}
