import admin.Login;
import data.io.Reader;
import data.io.Writer;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.Test;
import java.io.IOException;
import java.util.ArrayList;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        Reader.readAll();
    }

    @Override
    public void stop() throws Exception {
        try {
            Writer.removeAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Writer.writeAll();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(2% -8);
        ArrayList<String> c= new ArrayList<>();

        Test.loadUp();
        Login.show();
    }
}
