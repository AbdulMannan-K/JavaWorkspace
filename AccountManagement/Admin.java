import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Admin {
    private static String password;
    private static int interest=1;

    public static void setPassword() {
        try {
            File file = new File("pass.txt");
            Scanner scan = new Scanner(file);
            if(scan.hasNext())
                Admin.password=scan.next();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int getInterest() {
        return interest;
    }

    public static void setInterest(int interest) {
        Admin.interest = interest;
    }

    public static String getPassword() {
        return password;
    }
}
