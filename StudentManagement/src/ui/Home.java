package ui;

import admin.Login;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import data.Data;
import data.Department;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML private StackPane stack;
    @FXML private JFXButton options;
    @FXML private MenuItem user;

    @FXML private ImageView picture;

    public static JFXDialog dialog;

    @FXML private JFXButton homeBtn;
    @FXML private JFXButton stuViewBtn;
    @FXML private JFXButton departViewBtn;
    @FXML private JFXButton logoutBtn;
    @FXML private JFXButton exitBtn;

    public static Stage stage = new Stage();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
            stack.getChildren().clear();
            stack.getChildren().add(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        picture.setImage(new Image(getClass().getResource("graphics/back.png").toExternalForm()));

        homeBtn.setGraphic(new ImageView(getClass().getResource("graphics/home_black_18x18.png").toExternalForm()));
        homeBtn.setAlignment(Pos.CENTER_LEFT);
        stuViewBtn.setGraphic(new ImageView(getClass().getResource("graphics/view_list_black_18x18.png").toExternalForm()));
        stuViewBtn.setAlignment(Pos.CENTER_LEFT);
        departViewBtn.setGraphic(new ImageView(getClass().getResource("graphics/view_list_black_18x18.png").toExternalForm()));
        departViewBtn.setAlignment(Pos.CENTER_LEFT);
        logoutBtn.setGraphic(new ImageView(getClass().getResource("graphics/exit_to_app_black_18x18.png").toExternalForm()));
        logoutBtn.setAlignment(Pos.CENTER_LEFT);
        exitBtn.setGraphic(new ImageView(getClass().getResource("graphics/close_black_18x18.png").toExternalForm()));
        exitBtn.setAlignment(Pos.CENTER_LEFT);
        options.setText("");
        options.setGraphic(new ImageView(getClass().getResource("graphics/menu.png").toExternalForm()));

        homeBtn.setOnAction(event -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
                stack.getChildren().clear();
                stack.getChildren().add(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        user.setOnAction((ActionEvent event) -> {
            JFXDialogLayout dialogLayout = new JFXDialogLayout();
            try {
                Parent parent = FXMLLoader.load(Test.class.getResource("user/UserList.fxml"));
                dialogLayout.setBody(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
            dialog = new JFXDialog(stack, dialogLayout, JFXDialog.DialogTransition.CENTER);
            dialog.setMinSize(330, 400);
            dialogLayout.setMinSize(330, 400);
            dialog.setMaxSize(330, 400);
            dialogLayout.setMaxSize(330, 400);
            dialog.setPrefSize(330, 400);
            dialogLayout.setPrefSize(330, 400);
            dialog.show();
        });
        departViewBtn.setOnAction(event ->
                Platform.runLater(() -> {
                    stack.getChildren().clear();
                    Platform.runLater(() -> stack.getChildren().add(Test.loader.getDepartView()));
                })
        );

        stuViewBtn.setOnAction(event ->
                Platform.runLater(() -> {
                    stack.getChildren().clear();
                    Platform.runLater(() -> stack.getChildren().add(Test.loader.getStudentView()));
                })
        );

        exitBtn.setOnAction(event -> Platform.exit());

        logoutBtn.setOnAction(event -> {
            stage.close();
            Login.show();
        });
    }

    public static void show() {
        if (stage.getScene() == null)
            stage.setScene(new Scene(Test.loader.getHome()));
        stage.setFullScreen(true);
        stage.show();
    }
}