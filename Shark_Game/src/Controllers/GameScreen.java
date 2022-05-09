package Controllers;

import Model.Fish;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;

public class GameScreen {

    @FXML
    public AnchorPane pane;


    public void initialize(){
        pane.getChildren().add(new Fish());

        Platform.runLater(() -> {
                int i=0,j=0;
                ArrayList<Fish> fishes = new ArrayList<>();
                while(true){
                    if(j==10) break;
                    if(i==3){
                        System.out.println("well its working");
                        Fish f = new Fish();
                        fishes.add(f);
                        pane.getChildren().add(f);
                        i=0;
                        j++;
                    }
//                    for(Fish f : fishes) {
//                        f.move();
//                    }
                    i++;
                }
        });
    }

}
