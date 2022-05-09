import java.io.*;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Library {
    Scanner scan = new Scanner(System.in);
    public Book[] books = new Book[100];

    Library(){ // constructor to intialize Book Type array
        for(int i=0 ; i < 100 ; i++)
            books[i] = new Book();
    }

    void connectArray(){ // Function to connect the file Record.txt to Book Array so it can store previous record
        try{
            FileReader file = new FileReader("Record.txt");
            BufferedReader read = new BufferedReader(file);
            String line;int j=0;
            while((line=read.readLine())!=null){
                StringTokenizer st = new StringTokenizer(line);
                books[j].setBookName(st.nextToken());
                books[j].setAuthorName(st.nextToken());
                books[j].student.setStudentId(st.nextToken());
                books[j].setDay(Integer.parseInt(st.nextToken()));
                books[j].setMonth(Integer.parseInt(st.nextToken()));
                books[j].setYear(Integer.parseInt(st.nextToken()));
                books[j].setReturnDay(Integer.parseInt(st.nextToken()));
                books[j].setReturnMonth(Integer.parseInt(st.nextToken()));
                books[j].setReturnYear(Integer.parseInt(st.nextToken()));
                books[j].student.setPenalty(Integer.parseInt(st.nextToken()));
                j++;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }


    }

    void showMenu(){
        connectArray(); // calling this function at start
        Admin.setPassword("Ma32"); // default password can change it later
        Menus.mainMenu();
        System.out.print("Enter Option : ");
        String check = scan.next();
        do {
            int option;
            switch (check) {
                case "#" -> {
                    System.out.print("Enter password : ");
                    String pass = scan.next();
                    do {
                        if (!Admin.getPassword().equals(pass)){
                            System.out.print("Wrong Password, please enter again : ");
                            pass = scan.next();
                        }
                    }while (!Admin.getPassword().equals(pass));
                    do {
                        Menus.adminMenu();
                        System.out.print("Enter The Option : ");
                        option = scan.nextInt();
                        do {
                            if (option < 0 || option > 9) {
                                System.out.println("Enter again : ");
                                option = scan.nextInt();
                            }
                        } while (option < 0 || option > 9);
                        switch (option) {
                            case 1 -> {
                                System.out.print("Enter name of Book : ");
                                String nameBook = scan.next();
                                System.out.print("Enter name of Author : ");
                                addBook(nameBook,scan.next());
                            }
                            case 2 -> {
                                System.out.print("Enter name of Book : ");
                                String nameBook = scan.next();
                                System.out.print("Enter new name of Book : ");
                                ModifyRecord(nameBook,scan.next());
                            }
                            case 3 -> {
                                System.out.print("Enter name of Book : ");
                                DeleteBook(scan.next());
                            }
                            case 4 -> {
                                System.out.print("Enter name of Book : ");
                                String book = scan.next();
                                System.out.print("Enter Student Id : ");
                                String name = scan.next();
                                int date=2;
                                do{
                                    if(date < 1 || date > 31){
                                        System.out.println("Please Enter form 1 to 31!");
                                    }
                                    System.out.print("Enter Day : ");
                                    date = scan.nextInt();
                                }while (date < 1 || date > 31);
                                int month=2;
                                do{
                                    if(month < 1 || month > 12){
                                        System.out.println("Please Enter form 1 to 12!");
                                    }
                                    System.out.print("Enter Month : ");
                                    month = scan.nextInt();
                                }while (month < 1 || month > 12);
                                System.out.print("Enter Year : ");
                                issueBook(book , name , date , month , scan.nextInt() );
                            }
                            case 5 -> viewBooks();
                            case 6 -> viewRecord();
                            case 7 -> {
                                System.out.print("Change Password : ");
                                changePass(scan.next());
                            }
                            case 8 -> {
                                int month=2;
                                do{
                                    if(month < 1 || month > 12)
                                        System.out.println("Please Enter form 1 to 12!");

                                    System.out.print("Enter month you want record of : ");
                                    month = scan.nextInt();
                                    MonthRecord(month);
                                }while (month < 1 || month > 12);
                            }
                            case 9 -> showMenu();
                        }
                    }while(option!=9);
                    showMenu();
                }
                case "$" -> {
                    Menus.userMenu();
                    System.out.print("Enter Option : ");
                    option = scan.nextInt();
                    switch (option){
                        case 1 -> {
                            System.out.print("Enter name of Book : ");
                            SearchBook(scan.next());
                        }
                        case 2 -> {
                            System.out.print("Enter name of Book : ");
                            String book = scan.next();
                            System.out.print("Enter Student Id : ");
                            String name = scan.next();
                            int date=2;
                            do{
                                if(date < 1 || date > 31){
                                    System.out.println("Please Enter form 1 to 31!");
                                }
                                System.out.print("Enter Day : ");
                                date = scan.nextInt();
                            }while (date < 1 || date > 31);
                            int month=2;
                            do{
                                if(month < 1 || month > 12){
                                    System.out.println("Please Enter form 1 to 31!");
                                }
                                System.out.print("Enter Month : ");
                                month = scan.nextInt();
                            }while (month < 1 || month > 12);
                            System.out.print("Enter Year : ");
                            issueBook(book , name , date , month , scan.nextInt() );
                        }
                        case 3 -> {
                            System.out.print("Enter name of Book : ");
                            String book = scan.next();
                            System.out.print("Enter your Id : ");
                            readBook(book,scan.next());
                        }
                        case 4 -> {
                            System.out.print("Enter name of Book : ");
                            String book = scan.next();
                            System.out.print("Enter Student Id : ");
                            String name = scan.next();
                            int date=2;
                            do{
                                if(date < 1 || date > 31){
                                    System.out.println("Please Enter form 1 to 31!");
                                }
                                System.out.print("Enter Day : ");
                                date = scan.nextInt();
                            }while (date < 1 || date > 31);
                            int month=2;
                            do{
                                if(month < 1 || month > 12){
                                    System.out.println("Please Enter form 1 to 31!");
                                }
                                System.out.print("Enter Month : ");
                                month = scan.nextInt();
                            }while (month < 1 || month > 12);
                            System.out.print("Enter Year : ");
                            returnBook(book,name , date , month , scan.nextInt());
                        }
                        case 5 -> showMenu();
                    }
                    showMenu();
                }
                case "<" -> {
                    System.out.println("Exiting Program!");
                    System.exit(0);
                }
            }
        } while (!check.equals("#") && !check.equals("$"));
    }

    void addBook(String bookName, String authorName ){ // adds the book
        boolean isfull = false;
        for(int i=0 ; i < 100 ; i++){
            isfull=false;
            if(books[i].getBookName().equals("NoRecord")){
                books[i].setBookName(bookName);
                books[i].setAuthorName(authorName);
                for(int j=0 ; j < 100 ; j++)
                    if(books[i].getBookName().equals(books[j].getBookName()))
                        books[i].setBookCopies(books[i].getBookCopies()+1);
                break;
            }else{
               isfull = true;
            }
        }
        if(isfull)
            System.out.println("Library is Full. No space available!");

        WriteBook();
        WriteIssueRecord();

    }

    void ModifyRecord(String bookName , String bookName1){ // modify record by changing book name
        boolean isHere=true;

        for(int i=0 ; i< 100 ; i++){
            isHere=true;
            if(books[i].getBookName().equals(bookName))
                books[i].setBookName(bookName1);
            else
                isHere=false;
        }
        if(!isHere)
            System.out.println("Book is not Present!");

        WriteBook();
        WriteIssueRecord();

    }

    void DeleteBook(String bookName){ // deletes the book and its record
        boolean isHere = true;
        for(int i=0 ; i < 100 ; i++){
            isHere=true;
            if(books[i].getBookName().equals(bookName)){
                if(!books[i].getIssued()) {
                    books[i].setBookName("NoRecord");
                    books[i].setBookCopies(books[i].getBookCopies() - 1);
                    break;
                }else if(books[i].getIssued()){
                    System.out.println("Book is issued so you cant delete it now.");
                    break;
                }
            }else
                isHere=false;
        }
        if(!isHere)
            System.out.println("Book of given name is not here!");

        WriteBook();
        WriteIssueRecord();
    }

    void issueBook(String bookName , String Id , int date , int month , int year){ // issues the book
        boolean isHere = true;
        for(int i=0 ; i < 100 ; i++){
            isHere=true;
            if(books[i].getBookName().equals(bookName) ){
                if(books[i].student.getStudentId().equals("NotIssued")){
                    books[i].setIssued(true);
                    books[i].student.setStudentId(Id);
                    books[i].setDay(date);
                    books[i].setMonth(month);
                    books[i].setYear(year);
                    books[i].setReturnDay(0);
                    books[i].setReturnYear(0);
                    books[i].setReturnMonth(0);
                }else{
                    System.out.println("Book is already issued so you cant issue it now.");
                }
                break;
            }else
                isHere=false;
        }
        if(!isHere)
            System.out.println("Book of given name is not here!");
        WriteBook();
        WriteIssueRecord();
    }

    void viewBooks(){ // shows all books present
        for(int i=0; i < 100 ; i++)
            if(!books[i].getBookName().equals("NoRecord"))
                System.out.println("Book Name : " + books[i].getBookName() + "  ||  Author Name : " + books[i].getAuthorName() );
    }

    void viewRecord(){ // shows all books that are issued
        ReadIssuedRecord();
    }

    void changePass(String newPass){ // change password
        Admin.setPassword(newPass);
    }

    void SearchBook(String bookName){ // search the book and shows it
        int k=0,j=0;
        for(int i=0 ; i < 100 ; i++){
            if(books[i].getBookName().equals(bookName)){
                k++;
                if(!books[i].student.getStudentId().equals("NotIssued"))
                    j++;
            }
        }
        System.out.println("There are " + k +" copies of this book present in library.");
        System.out.println("And " + j + " are issued.");
    }

    void readBook(String bookName , String Id) { // for reading book
        boolean isHere= true;
        for (int i = 0; i < 100; i++) {
            isHere = true;
            if (books[i].getBookName().equals(bookName)) {
                if(!books[i].getIssued()){
                    books[i].setRead(true);
                    books[i].student.setStudentId(Id);
                    break;
                }else if (books[i].getIssued()){
                    System.out.println("Book is already issued so you cant read it now.");
                    break;
                }
            }else
                isHere=false;
        }
        if(!isHere)
            System.out.println("Book of given name is not here!");
        WriteBook();
        WriteIssueRecord();
    }

    void returnBook(String bookName, String Id, int date , int month , int year){ // Return the issued book by student
        boolean isHere = false;int pen=0;
        for(int i=0 ; i < 100 ; i++){
            isHere=false;
            if(books[i].student.getStudentId().equals(Id) && books[i].getBookName().equals(bookName)){
                books[i].setReturnDay(date);
                books[i].setReturnYear(year);
                books[i].setReturnMonth(month);
                books[i].setIssued(true);
                books[i].student.setStudentId("NotIssued");
                books[i].setReturn(true);
                double dayBetween = (Math.abs(date - books[i].getDay())) + (Math.abs(month - books[i].getMonth())*30) + ((year - books[i].getYear())*12*30);
                System.out.println(dayBetween);
                if(dayBetween>5)
                    pen+=1000;
                books[i].student.setPenalty(pen);
                break;
            }else{
                isHere=true;
            }
        }
        if(isHere)
            System.out.println("Book is never issued or issuer name is wrong or Book name is wrong!");

        WriteBook();
        WriteIssueRecord();

    }
    void WriteBook(){ // Write the record in file Books.txt
        try {

            FileWriter fileWriter = new FileWriter("Books.txt");
            Formatter fmt = new Formatter(fileWriter);
            fmt.format( "%-30s%30s%30s%30s%30s%20s\n\n" , "Book Name" , "Author Name" , "Issuer Id" , "Issue Date" , "Return Date" , "Penalty");
            for(int i=0 ; i < 100 ;i++)
                if(!books[i].getBookName().equals("NoRecord"))
                        fmt.format( "%-30s%30s%30s%30s%30s%20d\n" , books[i].getBookName() , books[i].getAuthorName() , books[i].student.getStudentId() , books[i].getDate() , books[i].getReturnDate() , books[i].student.getPenalty());

            fileWriter.flush();
            fileWriter.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    void MonthRecord(int month){ // Write and show the record of specified month
        try {
            FileWriter fileWriter = new FileWriter("MonthRecord.txt");
            Formatter fmt = new Formatter(fileWriter);
            fmt.format( "\n%-30s%30s%30s%30s%30s%20s\n\n" , "Book Name" , "Author Name" , "Issuer Id" , "Issue Date" , "Return Date" , "Penalty");
            for(int i=0 ; i < 100 ;i++)
                if(!books[i].student.getStudentId().equals("NotIssued") || books[i].getIssued())
                    if(books[i].getMonth() == month)
                        fmt.format( "%-30s%30s%30s%30s%30s%20d\n" , books[i].getBookName() , books[i].getAuthorName() , books[i].student.getStudentId() , books[i].getDate() , books[i].getReturnDate() , books[i].student.getPenalty());

            fileWriter.flush();
            fileWriter.close();
            File file = new File("MonthRecord.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine())
                System.out.println(scan.nextLine());

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    void WriteIssueRecord(){ // Write data in two files
        try{
            FileWriter fileWriter = new FileWriter("Record.txt");
            FileWriter fileWriter1 = new FileWriter("RecordForUser.txt");
            Formatter fmt = new Formatter(fileWriter);
            Formatter fmt1 = new Formatter(fileWriter1);
            for(int i=0 ; i < 100 ;i++)
                if(!books[i].getBookName().equals("NoRecord"))
                    fmt.format( "%-10s%10s%10s%5d%5d%5d%5d%5d%5d%10d\n" , books[i].getBookName() , books[i].getAuthorName() , books[i].student.getStudentId() ,  books[i].getDay() , books[i].getMonth() , books[i].getYear()  , books[i].getReturnDay() , books[i].getReturnMonth() , books[i].getReturnYear() , books[i].student.getPenalty() );
            fileWriter.flush();
            fileWriter.close();
            fmt1.format( "%-30s%30s%30s%30s%30s%20s\n\n" , "Book Name" , "Author Name" , "Issuer Id" , "Issue Date" , "Return Date" , "Penalty");
            for(int i=0 ; i < 100 ;i++)
                if(!books[i].student.getStudentId().equals("NotIssued") || books[i].getIssued())
                    if((books[i].getReturnMonth()==0 && books[i].getReturnDay()==0 && books[i].getReturnYear()==0))
                        fmt1.format( "%-30s%30s%30s%30s%30s%20s\n" , books[i].getBookName() , books[i].getAuthorName() , books[i].student.getStudentId() , books[i].getDate() , "Not Returned" , "No Penalty");
                    else
                        fmt1.format( "%-30s%30s%30s%30s%30s%20d\n" , books[i].getBookName() , books[i].getAuthorName() , books[i].student.getStudentId() , books[i].getDate() , books[i].getReturnDate() , books[i].student.getPenalty());

            fileWriter1.flush();
            fileWriter1.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    void ReadIssuedRecord() { // Reads the record from RecordForUser file basically shows the books that are issued
        try {
            File fileWriter = new File("RecordForUser.txt");
            Scanner scan = new Scanner(fileWriter);
            while (scan.hasNextLine())
                System.out.println(scan.nextLine());

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
