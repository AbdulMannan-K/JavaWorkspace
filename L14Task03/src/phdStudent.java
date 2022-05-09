
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class phdStudent extends Student{

    @Override
    public void Exam() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file adress : ");
        String adress = scan.next();
        try{
            FileReader file = new FileReader(adress);
            System.out.println("Theisis Submitted succesfully");
        }catch (IOException e){
            System.out.println("File not Found");
        }
    }
}
