package admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.Home;
import ui.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML private JFXButton cancel;
    @FXML private JFXButton login;
    @FXML private JFXTextField user;
    @FXML private JFXPasswordField pass;
    @FXML private JFXPasswordField sKey;
    @FXML private StackPane stack;

    private static Stage stage = new Stage();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login.setOnAction(event -> {
            JFXDialog dialog = Test.loader.getDialogs().getError().getErrorDialog("Wrong userName or PassWord");

            if (user.getText().equals("") || pass.getText().equals(""))
                dialog.show(stack);
            else {
                if (user.getText().equals(Admin.getAdmin())) {
                    for (String pass : Admin.getPass())
                        if (pass.equals(this.pass.getText())) {
                            ahead();
                        }
                } else {
                    for (User user : Admin.getUsers()) {
                        if (user.getUserName().equals(this.user.getText())) {
                            if (user.getPassWords().equals(this.pass.getText())) {
                                ahead();
                            } else dialog.show(stack);
                        } else dialog.show(stack);
                    }
                }
            }
        });

        cancel.setOnAction(event -> Platform.exit());
    }

    private void ahead() {
        this.user.setText("");
        this.pass.setText("");
        stage.close();
        if (sKey.getText().equals(Admin.getKey())) {
            Admin.setUnlock(true);
        } else {
            Admin.setUnlock(false);
        }
        this.sKey.setText("");
        Home.show();
    }

    public static void show() {
        try {
            if (stage.getScene() == null) {
                Parent parent = FXMLLoader.load(Login.class.getResource("Login.fxml"));
                stage.setScene(new Scene(parent));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }
}