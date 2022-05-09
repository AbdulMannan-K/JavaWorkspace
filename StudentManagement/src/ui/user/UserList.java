package ui.user;

import admin.Admin;
import admin.User;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import ui.Home;
import ui.Test;

import java.net.URL;
import java.util.ResourceBundle;

import static admin.Admin.getUsers;

public class UserList implements Initializable {

    @FXML private JFXButton add;
    @FXML private JFXButton close;
    @FXML private JFXButton remove;

    @FXML private JFXListView<JFXCheckBox> list;

    @FXML private StackPane stack;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (User user: getUsers())
            list.getItems().add(new JFXCheckBox(user.getUserName()));
        close.setText("");
        close.setGraphic(new ImageView(getClass().getResource("close.png").toExternalForm()));

        close.setOnAction(event -> Home.dialog.close());

        remove.setOnAction(event -> {
            list.getItems().clear();

            if (noOfSelected() > 1) {
                while (getSelectedUser() != null)
                    Admin.remove((getByName(getSelectedUser())));
                for (User user: getUsers())
                    list.getItems().add(new JFXCheckBox(user.getUserName()));

            }
            if (noOfSelected() == 1) {
                Admin.remove(getByName(getSelectedUser()));
                for (User user: getUsers())
                    list.getItems().add(new JFXCheckBox(user.getUserName()));
            }
        });

        add.setOnAction(event -> {
            JFXDialogLayout dialogLayout = new JFXDialogLayout();
            JFXDialog dialog = new JFXDialog(stack, dialogLayout, JFXDialog.DialogTransition.CENTER);

            VBox vb = new VBox();
            HBox hb = new HBox();
            JFXButton ok = new JFXButton("Add");
            JFXButton no = new JFXButton("Cancel");

            JFXTextField userName = new JFXTextField();
            JFXPasswordField pass = new JFXPasswordField();

            userName.setPromptText("Username");
            pass.setPromptText("Password");
            userName.setLabelFloat(true);
            pass.setLabelFloat(true);
            dialogLayout.setBody(vb);
            dialog.setPrefSize(310, 200);
            dialogLayout.setPrefSize(310, 3200);
            dialog.setMinSize(310,200);
            dialogLayout.setMinSize(310,250);
            dialog.setMaxSize(310,200);
            dialogLayout.setMaxSize(310,200);


            vb.setSpacing(20);
            vb.getChildren().addAll(userName, pass, hb);
            vb.setAlignment(Pos.CENTER);
            hb.getChildren().addAll(ok, no);
            ok.setOnAction(event1 -> {
                if (userName.getText().equals("") || pass.getText().equals(""))
                    dialog.close();
                else {
                    Admin.add(new User(userName.getText(), pass.getText()));
                    dialog.close();
                }
            });
            no.setOnAction(event1 -> dialog.close());

            dialog.show();
            dialog.setOnDialogClosed(event1 -> {
                list.getItems().clear();
                for (User user: getUsers())
                    list.getItems().add(new JFXCheckBox(user.getUserName()));
            });
        });
    }

    private int noOfSelected() {
        int count = 0;
        for (JFXCheckBox cb: list.getItems())
            if (cb.isSelected())
                count++;
        return count;
    }

    private String getSelectedUser() {
        for (JFXCheckBox cb: list.getItems())
            if (cb.isSelected())
                return cb.getText();
        return null;
    }

    private User getByName(String name) {
        for (User user: getUsers())
            if (name.equals(user.getUserName()))
                return user;
        return null;
    }
}