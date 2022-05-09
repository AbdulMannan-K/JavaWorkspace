import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidCodeException {

        while(true){
            System.out.print("Enter a character in unicode decimal : ");
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();
            if(ch<65||ch>90)
                throw new InvalidCodeException("Not A chracter!");
            else
                System.out.println("Char you entered is : " + (char)ch);

        }

    }

}
