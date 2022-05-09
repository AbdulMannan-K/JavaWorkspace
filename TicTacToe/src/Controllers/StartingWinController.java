package Controllers;

import Models.PlayerOne;
import Models.PlayerTwo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class StartingWinController {

    public void singlePlayer(javafx.event.ActionEvent actionEvent) throws IOException {
        GameWindowController.gameMode=1;
        NameWindowController.player2 = new PlayerTwo("Computer");
        NameWindowController.player1 = new PlayerOne("You");
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/gameWindow.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void multiPlayer(javafx.event.ActionEvent actionEvent) throws IOException {
        GameWindowController.gameMode=0;
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/NameWindow.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}