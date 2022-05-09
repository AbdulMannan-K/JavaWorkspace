package ui.department.editor;

import SMExceptions.naming_exceptions.WrongInputException;
import com.jfoenix.controls.*;
import data.Data;
import data.Department;
import data.Student;
import data.info.RollNo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.Test;
import ui.student.viewer.StudentsView;
import utilities.UIUtilities;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartmentEditor extends UIUtilities implements Initializable {

    @FXML private StackPane stack;
    @FXML private JFXTextArea provideDetails;
    @FXML private Group group;
    @FXML private Label details;
    @FXML private Text degrees;
    @FXML private GridPane editDegrees;
    @FXML private JFXCheckBox BS4;
    @FXML private JFXCheckBox BS2;
    @FXML private JFXCheckBox MS;
    @FXML private JFXCheckBox Phd;
    @FXML private Text code;
    @FXML private Text depart;
    @FXML private JFXToggleButton toggleEditing;
    @FXML private JFXButton deleteDepart;
    @FXML private JFXTextField name;
    @FXML private FlowPane flow;
    @FXML private JFXButton next;
    @FXML private JFXButton prev;

    private static JFXButton nex;
    private static JFXButton pre;

    private static Department DEPARTMENT;
    private Department department = new Department();
    private static Stage mainStage;
    private static Scene scene;

    private static Label DETAILS;
    private static Text DEGREES;
    private static Text CODE;
    private static Text DEPART;

    private static int index;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nex = next;
        pre = prev;

        next.setOnAction(e -> {
            setDepart((DEPARTMENT = Data.getDeparts().get(++index)));
            update(next, prev);
        });

        prev.setOnAction(e -> {
            setDepart((DEPARTMENT = Data.getDeparts().get(--index)));
            update(next, prev);
        });

        CODE = code;
        DEGREES = degrees;
        DETAILS = details;
        DEPART = depart;

        flow.getChildren().remove(name);
        name.setVisible(false);
        name.setStyle("-fx-text-fill: white;");
        name.setCache(true);
        provideDetails.setVisible(false);
        editDegrees.setVisible(false);

        provideDetails.textProperty().addListener((obj, ov, nv) -> {
            try {
                if (nv.equals(""))
                    nv = "No Details";
                department.getDetails().set(nv);
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
        });

        name.textProperty().addListener((obj, ov, nv) -> {
            try {
                department.getName().set(nv);
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
        });

        BS2.selectedProperty().addListener((obj, ov, nv) -> setDegrees());
        BS4.selectedProperty().addListener((obj, ov, nv) -> setDegrees());
        MS.selectedProperty().addListener((obj, ov, nv) -> setDegrees());
        Phd.selectedProperty().addListener((obj, ov, nv) -> setDegrees());

        toggleEditing.setOnAction(e-> {
            if(toggleEditing.isSelected()) {
                flow.getChildren().add(name);
                name.setOpacity(0);
                flow.getChildren().remove(depart);
                name.setText(depart.getText());
                turnOnEditing();
            } else {
                Data.remove(DEPARTMENT);
                flow.getChildren().remove(name);
                flow.getChildren().add(depart);
                depart.setOpacity(0);
                turnOffEditing();
                if (
                        !department.getDetails().get().equals(DEPARTMENT.getDetails().get()) ||
                        !department.getName().get().equals(DEPARTMENT.getName().get()) ||
                        !department.getDegrees().toString().equals(DEPARTMENT.getDegrees().toString())
                   ) {
                    Data.remove(DEPARTMENT);
                    DEPARTMENT.getDegrees().set(department.getDegrees().isBs4year(), department.getDegrees().isBs2year(), department.getDegrees().isMs(), department.getDegrees().isPhd());
                    try {
                        DEPARTMENT.getName().set(department.getName().get());
                    } catch (WrongInputException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        DEPARTMENT.getDetails().set(department.getDetails().get());
                    } catch (WrongInputException e1) {
                        e1.printStackTrace();
                    }
                    setDepart(DEPARTMENT);
                }
                Data.add(DEPARTMENT);

                for (Student student: DEPARTMENT.getStudents()) {
                    try {
                        DEPARTMENT.removeStu(student);
                        student.getDepart().getName().set(DEPARTMENT.getName().get());
                        ((RollNo)student.getRollNo()).updateCode(student);
                        DEPARTMENT.addStu(student);
                    } catch (WrongInputException e1) {
                        e1.printStackTrace();
                    }
                }

                StudentsView.updateTable(null);
            }
        });

        deleteDepart.setOnAction(e-> {
            JFXDialog dialog = Test.loader.getDialogs().getWarning().getWarningDialog("Are you Sure, You want to Delete it ?");
            dialog.show(stack);
            dialog.setOnDialogClosed(event -> {
                if (Test.loader.getDialogs().getWarning().canDo()) {
                    int i = Data.getDeparts().indexOf(DEPARTMENT);
                    if(i == 0)
                        mainStage.close();
                    else if(i == Data.getDeparts().size() -1)
                        setDepart((DEPARTMENT = Data.getDeparts().get(Data.getDeparts().indexOf(DEPARTMENT) -1)));
                    else
                        setDepart((DEPARTMENT = Data.getDeparts().get(Data.getDeparts().indexOf(DEPARTMENT) +1)));
                    Data.remove(DEPARTMENT);
                }
            });
        });
    }

    private void setDegrees() {
        department.getDegrees().set(BS4.isSelected(), BS2.isSelected(), MS.isSelected(), Phd.isSelected());
    }

    private static void update(JFXButton next, JFXButton prev) {
        if(index == Data.getDeparts().size() -1)
            next.setDisable(true);
        else
            next.setDisable(false);

        if(index == 0)
            prev.setDisable(true);
        else
            prev.setDisable(false);
    }

    private static void setDepart(Department Depart) {
        DEGREES.setText(Depart.getDegrees().toString());
        DEPART.setText(Depart.getName().get());
        CODE.setText(Depart.getName().getCode());
        DETAILS.setText(Depart.getDetails().get());
    }

    private void turnOnEditing() {
        try {
            department.getName().set(DEPARTMENT.getName().get());
            department.getDegrees().set(DEPARTMENT.getDegrees().isBs4year(), DEPARTMENT.getDegrees().isBs2year(), DEPARTMENT.getDegrees().isMs(), DEPARTMENT.getDegrees().isPhd());
            department.getDetails().set(DEPARTMENT.getDetails().get());
            provideDetails.setText(department.getDetails().get());
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        provideDetails.setVisible(true);
        editDegrees.setVisible(true);
        depart.setVisible(false);
        name.setVisible(true);
        provideDetails.setOpacity(0); editDegrees.setOpacity(0);
        BS2.setSelected(DEPARTMENT.getDegrees().isBs2year());
        BS4.setSelected(DEPARTMENT.getDegrees().isBs4year());
        MS.setSelected(DEPARTMENT.getDegrees().isMs());
        Phd.setSelected(DEPARTMENT.getDegrees().isPhd());
        UIUtilities.createSequentialTransition(
                UIUtilities.createParallelTransition(UIUtilities.createFadeTransition(degrees, 1.0, 1, true), UIUtilities.createFadeTransition(group, 1.0, 1, true), UIUtilities.createFadeTransition(depart, 1.0, 1, true)),
                UIUtilities.createParallelTransition(UIUtilities.createFadeTransition(editDegrees, 1.0, 1, false), UIUtilities.createFadeTransition(provideDetails, 1.0, 1, false), UIUtilities.createFadeTransition(name, 1.0,1, false))).play();
    }

    private void turnOffEditing() {
        UIUtilities.createSequentialTransition(
                UIUtilities.createParallelTransition(e-> { name.setVisible(false); depart.setVisible(true); provideDetails.setVisible(false); editDegrees.setVisible(false); }, UIUtilities.createFadeTransition(editDegrees, 1.0, 1, true), UIUtilities.createFadeTransition(provideDetails, 1.0, 1, true), UIUtilities.createFadeTransition(name, 1.0, 1, true)),
                UIUtilities.createParallelTransition(UIUtilities.createFadeTransition(degrees, 1.0, 1, false), UIUtilities.createFadeTransition(group, 1.0, 1, false), UIUtilities.createFadeTransition(depart, 1.0, 1, false))).play();
    }

    public static void show(Stage stage,Stage stageS, Department department) {
        mainStage = stageS;

        if (scene == null)
            scene = new Scene(Test.loader.getDepartEdit());

        if (mainStage.getOwner() == null)
            mainStage.initOwner(stage);

        mainStage.setScene(scene);
        mainStage.show();

        DEPARTMENT = department;
        setDepart(DEPARTMENT);
        index = Data.getDeparts().indexOf(DEPARTMENT);
        update(nex, pre);
    }
}