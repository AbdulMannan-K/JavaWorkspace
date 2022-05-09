package Controllers;

import Models.Player;
import Models.PlayerOne;
import Models.PlayerTwo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class NameWindowController {

    static Player player1;
    static Player player2;

    @FXML
    private TextField PlayerO;
    @FXML
    private TextField PlayerT;

    public void next(javafx.event.ActionEvent actionEvent) throws IOException {
        player1 = new PlayerOne(PlayerO.getText());
        player2 = new PlayerTwo(PlayerT.getText());
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/gameWindow.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
