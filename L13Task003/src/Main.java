import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws EmailNotUniqueException{
        ArrayList<String> emails = new ArrayList<>();

        while(true){
            System.out.print("Enter Email : ");
            Scanner scan=  new Scanner(System.in);
            String mail = scan.next();
            if(emails.contains(mail)){
                throw new EmailNotUniqueException("Emails is not unique!");
            }
            emails.add(mail);
        }
    }
}
