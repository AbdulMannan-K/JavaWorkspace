package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.lang.constant.Constable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameWindowController {

    private boolean isTurn = false; //false is for P1 , true is for P2
    static int gameMode; // 1 for single player
    private int i = 0;

    @FXML
    private Label Label1x1;
    @FXML
    private Label Label2x1;
    @FXML
    private Label Label3x1;
    @FXML
    private Label Label1x2;
    @FXML
    private Label Label2x2;
    @FXML
    private Label Label3x2;
    @FXML
    private Label Label1x3;
    @FXML
    private Label Label2x3;
    @FXML
    private Label Label3x3;
    @FXML
    private Label winner;
    @FXML
    private Button reset;

    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/StartingWindow.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void restart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/gameWindow.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void makeMove(MouseEvent mouseEvent) throws IOException {
        reset.setDisable(true);

        Alert alert;

        Label l = (Label) mouseEvent.getSource();
        if(l.getText().equals("X")||l.getText().equals("O")){
            alert = new Alert(Alert.AlertType.WARNING,"The box is Already Filled");
            alert.show();
        }else {
            if (!isTurn)
                l.setText(NameWindowController.player1.getIdentity());
            else
                l.setText(NameWindowController.player2.getIdentity());
            isTurn = !isTurn;
        }

        if(gameMode==1&&i!=16){
            Random random =  new Random();
            boolean isRepeat = false;
            Label finalPos = null;
            do {
                isRepeat=false;
                int pos = random.nextInt(9);
                switch (pos) {
                    case 0 -> {
                        isRepeat=true;
                    }
                    case 1 -> {
                        if (Label1x1.getText().equals("X") || Label1x1.getText().equals("O")){
                            isRepeat=true;
                        }
                        finalPos=Label1x1;
                    }
                    case 2 -> {
                        if (Label1x2.getText().equals("X") || Label1x2.getText().equals("O")){
                            isRepeat=true;
                        }
                        finalPos=Label1x2;
                    }
                    case 3 -> {
                        if (Label1x3.getText().equals("X") || Label1x3.getText().equals("O")){
                            isRepeat=true;
                        }
                        finalPos=Label1x3;
                    }
                    case 4 -> {
                        if (Label2x1.getText().equals("X") || Label2x1.getText().equals("O")){
                            isRepeat=true;
                        }
                        finalPos=Label2x1;
                    }
                    case 5 -> {
                        if (Label2x2.getText().equals("X") || Label2x2.getText().equals("O")){
                            isRepeat=true;
                        }
                        finalPos=Label2x2;
                    }
                    case 6 -> {
                        if (Label2x3.getText().equals("X") || Label2x3.getText().equals("O")){
                            isRepeat=true;
                        }
                        finalPos=Label2x3;
                    }
                    case 7 -> {
                        if (Label3x1.getText().equals("X") || Label3x1.getText().equals("O")){
                            isRepeat=true;
                        }
                        finalPos=Label3x1;
                    }
                    case 8 -> {
                        if (Label3x2.getText().equals("X") || Label3x2.getText().equals("O")){
                            isRepeat=true;
                        }
                        finalPos=Label3x2;
                    }
                    case 9 -> {
                        if (Label3x3.getText().equals("X") || Label3x3.getText().equals("O")){
                            isRepeat=true;
                        }
                        finalPos=Label3x3;
                    }
                }
            }while (isRepeat);
            assert finalPos != null;
            finalPos.setText("O");
            isTurn = !isTurn;
            i += 2;
        }

        if (checkStatus().equals(true)) {
            winner.setText(NameWindowController.player1.getName()+" has won the Game");
            reset.setDisable(false);
        } else if (checkStatus().equals(false)) {
            winner.setText(NameWindowController.player2.getName()+" has won the Game");
            reset.setDisable(false);
        }

        if (i == 18) {
            alert = new Alert(Alert.AlertType.INFORMATION, "Match is Draw");
            alert.show();
            reset.setDisable(false);
        }

    }

    public Constable checkStatus () {
        if (Label1x1.getText().equals(Label1x2.getText()) && Label1x1.getText().equals(Label1x3.getText()) && Label1x1.getText().equals("X"))
            return true;
        if (Label2x1.getText().equals(Label2x2.getText()) && Label2x1.getText().equals(Label2x3.getText()) && Label2x1.getText().equals("X"))
            return true;
        if (Label3x1.getText().equals(Label3x2.getText()) && Label3x1.getText().equals(Label3x3.getText()) && Label3x1.getText().equals("X"))
            return true;

        if (Label1x1.getText().equals(Label2x1.getText()) && Label1x1.getText().equals(Label3x1.getText()) && Label1x1.getText().equals("X"))
            return true;
        if (Label1x2.getText().equals(Label2x2.getText()) && Label1x2.getText().equals(Label3x2.getText()) && Label1x2.getText().equals("X"))
            return true;
        if (Label1x3.getText().equals(Label2x3.getText()) && Label1x3.getText().equals(Label3x3.getText()) && Label1x3.getText().equals("X"))
            return true;

        if (Label1x1.getText().equals(Label2x2.getText()) && Label1x1.getText().equals(Label3x3.getText()) && Label1x1.getText().equals("X"))
            return true;
        if (Label1x3.getText().equals(Label2x2.getText()) && Label1x3.getText().equals(Label3x1.getText()) && Label1x3.getText().equals("X"))
            return true;

        if (Label1x1.getText().equals(Label1x2.getText()) && Label1x1.getText().equals(Label1x3.getText()) && Label1x1.getText().equals("O"))
            return false;
        if (Label2x1.getText().equals(Label2x2.getText()) && Label2x1.getText().equals(Label2x3.getText()) && Label2x1.getText().equals("O"))
            return false;
        if (Label3x1.getText().equals(Label3x2.getText()) && Label3x1.getText().equals(Label3x3.getText()) && Label3x1.getText().equals("O"))
            return false;

        if (Label1x1.getText().equals(Label2x1.getText()) && Label1x1.getText().equals(Label3x1.getText()) && Label1x1.getText().equals("O"))
            return false;
        if (Label1x2.getText().equals(Label2x2.getText()) && Label1x2.getText().equals(Label3x2.getText()) && Label1x2.getText().equals("O"))
            return false;
        if (Label1x3.getText().equals(Label2x3.getText()) && Label1x3.getText().equals(Label3x3.getText()) && Label1x3.getText().equals("O"))
            return false;

        if (Label1x1.getText().equals(Label2x2.getText()) && Label1x1.getText().equals(Label3x3.getText()) && Label1x1.getText().equals("O"))
            return false;
        if (Label1x3.getText().equals(Label2x2.getText()) && Label1x3.getText().equals(Label3x1.getText()) && Label1x3.getText().equals("O"))
            return false;

        i++;
        return "NuN";
    }


}
