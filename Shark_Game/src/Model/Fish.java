package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Fish extends ImageView{
    
    private boolean left;

    public Fish(){
        super.setImage(new Image("file:src/Model/angler-fish.png"));
        super.setFitHeight(30);
        super.setFitWidth(30);
        double x = Math.random();
        if(x>0.5) {
            left=true;
            super.setLayoutX(-50);
        }
        if(x<0.5) {
            left=false;
            super.setLayoutX(140);
        }
        Random random = new Random();
        super.setLayoutY(random.nextDouble(600));
    }
    
    public void move(){
        super.setLayoutX(super.getLayoutX()+100);
    }
    
    

}
