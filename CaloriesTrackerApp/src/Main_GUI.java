import Data.DataHandle;
import Models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileReader;
import java.util.Scanner;

public class Main_GUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        FileReader read = new FileReader("records.txt");
        Scanner scan = new Scanner(read);

        while(scan.hasNext()){
            String name = scan.next();
            String pass = scan.next();
            int id = scan.nextInt();
            DataHandle.users.add(new User(name,pass));
            for(User user : DataHandle.users){
                if(user.getName().equals(name))
                    user.getTracker().setId(id);
            }
        }

        Parent root = FXMLLoader.load(getClass().getResource("Interface/LoginSignup.fxml"));
        primaryStage.setTitle("Calorie Tracker");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
