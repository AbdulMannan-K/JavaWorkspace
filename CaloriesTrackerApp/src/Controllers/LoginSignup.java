package Controllers;

import Data.DataHandle;
import Models.Tracker;
import Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;


public class LoginSignup {

    static User user;

    @FXML
    private TextField loginName;
    @FXML
    private PasswordField loginPass;
    @FXML
    private TextField signupName;
    @FXML
    private PasswordField signupPass;

    public void login(ActionEvent actionEvent) throws IOException {
        boolean isPresent = false;
        for(User user : DataHandle.users){
            isPresent=true;
            if(user.getName().equals(loginName.getText()) && user.getPassword().equals(loginPass.getText())){
                isPresent=true;
                LoginSignup.user = user;
                Parent root = FXMLLoader.load(getClass().getResource("/Interface/TrackerMain.fxml"));
                Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                break;
            }else {
                isPresent=false;
            }
        }
        if(!isPresent){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Wrong Credentials");
            alert.show();
        }
    }

    public void signup(ActionEvent actionEvent) throws IOException {
        boolean isPresent = false;
        FileWriter write = new FileWriter("Records.txt");
        for(User user : DataHandle.users){
            if(user.getName().equals(signupName.getText())){
                isPresent=true;
                break;
            }
        }
        if(isPresent){
            Alert alert = new Alert(Alert.AlertType.WARNING,"This Name is already Registered! Try Another one");
            alert.show();
        }else{
            DataHandle.users.add(new User(signupName.getText(),signupPass.getText()));
            for(User user : DataHandle.users){
                write.write(user.getName()+"   "+user.getPassword()+"    "+user.getTracker().getId()+"\n");
            }
        }
        write.flush();
        write.close();
    }
}
