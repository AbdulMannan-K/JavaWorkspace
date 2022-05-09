package Controllers;

import Models.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.control.TextField;
import java.io.IOException;

public class TrackerMain {

    @FXML
    private Label UserName;
    @FXML
    private Label trackerId;
    @FXML
    private TextField itemName;
    @FXML
    private TextField protein;
    @FXML
    private TextField fats;
    @FXML
    private TextField carbs;

    public void initialize() {
        UserName.setText("Name : "+LoginSignup.user.getName());
        trackerId.setText("Tracker Id : "+String.valueOf(LoginSignup.user.getTracker().getId()));
    }

    public void summary(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/TrackerSummary.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void add(ActionEvent actionEvent) {
        LoginSignup.user.getTracker().getItems().add(new Item(itemName.getText().toString(),Double.parseDouble(fats.getText()),Double.parseDouble(carbs.getText()),Double.parseDouble(protein.getText())));
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/LoginSignup.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
