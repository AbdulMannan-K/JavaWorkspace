import ConsoleUI.Menu;
import Data.DataHandle;
import Models.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main_Console {

    public static void main(String[] args) throws FileNotFoundException {

        FileReader read = new FileReader("records.txt");
        Scanner scan = new Scanner(read);

        while(scan.hasNextLine()){
            String name = scan.next();
            String pass = scan.next();
            int id = scan.nextInt();
            DataHandle.users.add(new User(name,pass));
            for(User user : DataHandle.users){
                if(user.getName().equals(name))
                    user.getTracker().setId(id);
            }
        }

        Menu menu = new Menu();
        menu.menu();
    }

}
