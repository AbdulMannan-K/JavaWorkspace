package ui.student.admission;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import data.Data;
import data.Department;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import ui.Test;
import ui.student.admission.inputs.*;
import ui.student.viewer.StudentsView;
import utilities.UIUtilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class StudentAdmission implements Initializable {

    @FXML private Label name;

    @FXML private Rectangle rect;

    @FXML private JFXButton next;
    @FXML private JFXButton prev;
    @FXML private JFXButton browseBtn;

    @FXML private StackPane stack;
    @FXML private AnchorPane view;
    @FXML private AnchorPane mainPane;

    private static Stage innerStage;
    private static Stage STAGE;
    private static Scene SCENE;

    private static int mover = 0;

    private static final LinkedList<Scene> inputs = new LinkedList<>();
    private static final LinkedList<Controller> controllers = new LinkedList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        next.setGraphic(new ImageView(Test.class.getResource("graphics/chevron_right_white_24x24.png").toExternalForm()));
        prev.setGraphic(new ImageView(Test.class.getResource("graphics/chevron_left_white_24x24.png").toExternalForm()));

        prev.setDisable(true);

        browseBtn.setOnAction(event -> {

            final FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter filter0 = new FileChooser.ExtensionFilter("JPEG", "*.jpeg");
            FileChooser.ExtensionFilter filter1 = new FileChooser.ExtensionFilter("PNG", "*.png");
            FileChooser.ExtensionFilter filter2 = new FileChooser.ExtensionFilter("TIFF", "*.tiff");
            FileChooser.ExtensionFilter filter3 = new FileChooser.ExtensionFilter("BMP", "*.bmp");
            FileChooser.ExtensionFilter filterAll = new FileChooser.ExtensionFilter("All images", "*.jpg", "*.jpeg", "*.png", "*.tiff", "*.bmp");

            fileChooser.getExtensionFilters().setAll(filterAll, filter0, filter1, filter2, filter3);
            fileChooser.setSelectedExtensionFilter(filter0);

            final File file = fileChooser.showOpenDialog(null);

            if (file != null) {
                rect.setFill(new ImagePattern(new Image(file.toURI().toString())));
            }

        });

        next.setOnAction(event -> nextButtonAction());
        prev.setOnAction(event -> prevButtonAction());
    }

    private void nextButtonAction() {
        if (inputs.indexOf(inputs.get(mover)) == inputs.size() - 1 && controllers.get(mover).canGoAhead()) {
            innerStage.close();
            JFXDialog dialog = Test.loader.getDialogs().getSuccess().getSuccessDialog("New Student was Added!", 250);
            dialog.setOnDialogClosed(event -> {
                Test.loader.loadStuInput();
                Data.Temp.getTempStudent().getRollNo().generate(Data.Temp.getTempStudent());
                STAGE.hide();
            });
            next.setDisable(true);
            mainPane.setEffect(new GaussianBlur(5));
            dialog.show(stack);
        } else if (controllers.get(mover).canGoAhead()) {
            next.setDisable(true);
            UIUtilities.createFadeTransition(innerStage.getScene().getRoot(), 1.0, 1, true, e -> {
                innerStage.close();
                if (inputs.indexOf(inputs.get(mover)) == 0) {
                    changeFormStyle(eee -> {
                        innerStage.setScene(inputs.get(++mover));
                        innerStage.setX(533);
                        innerStage.setY(230);
                        innerStage.getScene().getRoot().setOpacity(0);
                        innerStage.show();
                        UIUtilities.createFadeTransition(innerStage.getScene().getRoot(), 1.0, 1, false).play();
                        updater();
                    });
                } else {
                    innerStage.setScene(inputs.get(++mover));
                    innerStage.setX(533);
                    innerStage.setY(230);
                    innerStage.getScene().getRoot().setOpacity(0);
                    innerStage.show();
                    UIUtilities.createFadeTransition(innerStage.getScene().getRoot(), 1.0, 1, false).play();
                    updater();
                }
            }).play();
        }
    }

    private void prevButtonAction() {

        prev.setDisable(true);
        if (inputs.indexOf(inputs.get(mover)) == 1) {
            UIUtilities.createFadeTransition(name, 1.0, 1, true, e -> playBack()).play();
        } else {
            playBack();
        }
    }

    private void playBack() {
        UIUtilities.createFadeTransition(innerStage.getScene().getRoot(), 1.0, 1, true, ee -> {
            innerStage.close();
            if (inputs.indexOf(inputs.get(mover)) == 1) {
                reverseFormStyle(eee -> {
                    innerStage.setScene(inputs.get(--mover));
                    innerStage.setX(533.0);
                    innerStage.setY(342.0);
                    innerStage.getScene().getRoot().setOpacity(0);
                    innerStage.show();
                    UIUtilities.createFadeTransition(innerStage.getScene().getRoot(), 1.0, 1, false).play();
                    updater();
                });
            } else {
                innerStage.setScene(inputs.get(--mover));
                innerStage.setX(533);
                innerStage.setY(230);
                innerStage.getScene().getRoot().setOpacity(0);
                innerStage.show();
                UIUtilities.createFadeTransition(innerStage.getScene().getRoot(), 1.0, 1, false).play();
                updater();
            }
        }).play();
    }

    private void updater() {
        next.setDisable(false);

        if (mover <= 0)
            prev.setDisable(true);
        else
            prev.setDisable(false);
    }

    private void reverseFormStyle(EventHandler<ActionEvent> value) {
        UIUtilities.createSequentialTransition(value, applyPathTransition(-42, 30, 61, 62), UIUtilities.createParallelTransition(UIUtilities.createSequentialTransition(UIUtilities.createFadeTransition(view, 1.0, 1, true, e -> changeViewSizing(false)), UIUtilities.createFadeTransition(view, 1.0, 1, false)), UIUtilities.createSequentialTransition(UIUtilities.createParallelTransition(UIUtilities.createFadeTransition(rect, 1.0, 1, true, e -> changeAngles(false)), UIUtilities.createRotateTransition(rect, 1.0, 1, true)), UIUtilities.createParallelTransition(UIUtilities.createRotateTransition(rect, 1.0, 1, false), UIUtilities.createFadeTransition(rect, 1.0, 1, false))))).play();
    }

    private void changeFormStyle(EventHandler<ActionEvent> value) {
        ParallelTransition pt = UIUtilities.createParallelTransition(UIUtilities.createSequentialTransition(UIUtilities.createFadeTransition(view, 1.0, 1, true, e -> changeViewSizing(true)), UIUtilities.createFadeTransition(view, 1.0, 1, false)), UIUtilities.createSequentialTransition(UIUtilities.createParallelTransition(UIUtilities.createRotateTransition(rect, 1.0, 1, true), UIUtilities.createFadeTransition(rect, 1.0, 1, true, e -> changeAngles(true))), UIUtilities.createParallelTransition(UIUtilities.createRotateTransition(rect, 1.0, 1, false), UIUtilities.createFadeTransition(rect, 1.0, 1, false))));
        pt.play();
        pt.setOnFinished(e -> {
            PathTransition pth = applyPathTransition(ee -> {
                String name = Data.Temp.getTempStudent().getStudentName().get();
                if (name.contains("Muhammad"))
                    name = name.replace("Muhammad", "");
                String[] strings = name.split("\\s+");

                for (String string: strings)
                    if (!(name = string).equals("")) {
                        this.name.setText("Hi, " + name);
                        break;
                    }
                this.name.setVisible(true);
                FadeTransition ft = UIUtilities.createFadeTransition(this.name, 1.0, 1, false);
                ft.play();
                ft.setOnFinished(value);
            });
            pth.play();
        });
    }

    private PathTransition applyPathTransition(int i, int j, int k, int l) {
        PathTransition pt = new PathTransition(Duration.seconds(1), new Path(new MoveTo(i, j), new LineTo(k, l)), rect);
        pt.setCycleCount(1);
        pt.setAutoReverse(false);
        return pt;
    }

    private PathTransition applyPathTransition(EventHandler<ActionEvent> value) {
        PathTransition pt = applyPathTransition(61, 62, -42, 30);
        pt.setOnFinished(value);
        return pt;
    }

    private void changeAngles(boolean b) {
        if (b) {
            rect.setArcHeight(500);
            rect.setArcWidth(500);
            rect.setWidth(rect.getWidth() / 1.3);
            rect.setHeight(rect.getHeight() / 1.3);
            rect.setLayoutX(143);
            rect.setLayoutY(80);
        } else {
            rect.setArcHeight(0);
            rect.setArcWidth(0);
            rect.setWidth(rect.getWidth() * 1.3);
            rect.setHeight(rect.getHeight() * 1.3);
            rect.setLayoutX(126);
            rect.setLayoutY(68);
        }
    }

    private void changeViewSizing(boolean b) {
        if (b) {
            view.setPrefHeight(565);
            view.setLayoutY(40);
            view.setStyle(view.getStyle() + "-fx-background-radius: 70px 0 0 0 ;");
            browseBtn.setVisible(false);
        } else {
            view.setPrefHeight(448);
            view.setLayoutY(157);
            view.setStyle(view.getStyle() + "-fx-background-radius: 0 0 0 0 ;");
            browseBtn.setVisible(true);
        }
    }

    private static void reload() {
        controllers.clear();
        inputs.clear();
        mover = 0;
        try {
            controllers.add(new Input1());
            controllers.add(new Input2());
            controllers.add(new Input3());
            controllers.add(new Input4());
            controllers.add(new Input5());
            Parent parent1 = FXMLLoader.load(Test.class.getResource("student/admission/inputs/Input1.fxml"));
            inputs.add(new Scene(parent1));
            Parent parent2 = FXMLLoader.load(Test.class.getResource("student/admission/inputs/Input2.fxml"));
            inputs.add(new Scene(parent2));
            Parent parent3 = FXMLLoader.load(Test.class.getResource("student/admission/inputs/Input3.fxml"));
            inputs.add(new Scene(parent3));
            Parent parent4 = FXMLLoader.load(Test.class.getResource("student/admission/inputs/Input4.fxml"));
            inputs.add(new Scene(parent4));
            Parent parent5 = FXMLLoader.load(Test.class.getResource("student/admission/inputs/Input5.fxml"));
            inputs.add(new Scene(parent5));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show(Stage parent, Stage stage) {
        stage.initOwner(parent);
        reload();
        STAGE = stage;
        try {
            Parent parent1 = FXMLLoader.load(Test.class.getResource("student/admission/StudentAdmission.fxml"));
            SCENE = new Scene(parent1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (stage.getScene() == null)
            stage.setScene(SCENE);
        if (stage.getModality() == null)
            stage.initModality(Modality.WINDOW_MODAL);

        stage.show();

        innerStage = new Stage();
        innerStage.setScene(inputs.get(mover));
        innerStage.setX(533.0);
        innerStage.setY(342);
        innerStage.initStyle(StageStyle.UNDECORATED);
        innerStage.initOwner(STAGE);
        innerStage.show();

        if (stage.getStyle() == null)
            stage.initStyle(StageStyle.UTILITY);

        stage.setResizable(false);
        stage.setOnHiding(event -> {
            if (Data.Temp.getTempStudent().isNull())
                return;

            for (Department department : Data.getDeparts())
                if (department.getName().get().equals(Data.Temp.getTempStudent().getDepart().getName().get())) {
                    department.addStu(Data.Temp.getTempStudent().clone());
                    break;
                }
            StudentsView.updateTable(null);
            stage.close();
        });
    }
}