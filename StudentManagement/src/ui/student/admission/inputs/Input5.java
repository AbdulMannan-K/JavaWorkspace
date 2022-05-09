package ui.student.admission.inputs;

import SMExceptions.naming_exceptions.WrongInputException;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import data.Data;
import data.Department;
import data.info.Depart;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import ui.Test;
import ui.student.admission.Controller;

import java.net.URL;
import java.util.ResourceBundle;

public class Input5 implements Initializable, Controller {

    @FXML private JFXCheckBox agree;

    @FXML private JFXRadioButton MS;
    @FXML private JFXRadioButton Phd;
    @FXML private JFXRadioButton BS2Y;
    @FXML private JFXRadioButton BS4Y;

    @FXML private JFXComboBox<String> depart;

    private static boolean canGo = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final ToggleGroup toggleGroup = new ToggleGroup();
        MS.setToggleGroup(toggleGroup);
        Phd.setToggleGroup(toggleGroup);
        BS2Y.setToggleGroup(toggleGroup);
        BS4Y.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener((obj, ov, nv) -> {
            agree.setDisable(false);
            if (BS2Y.isSelected())
                Data.Temp.getTempStudent().getDepart().setDegree(Depart.Degree.BS2);
            if (BS4Y.isSelected())
                Data.Temp.getTempStudent().getDepart().setDegree(Depart.Degree.BS4);
            if (MS.isSelected())
                Data.Temp.getTempStudent().getDepart().setDegree(Depart.Degree.MS);
            if (Phd.isSelected())
                Data.Temp.getTempStudent().getDepart().setDegree(Depart.Degree.Phd);
            setValid();
        });

        agree.selectedProperty().addListener((obj, ov, nv) ->  setValid());

        depart.setOnMousePressed(event -> {
            depart.getItems().clear();
            for (Department department: Data.getDeparts())
                depart.getItems().add(department.getName().get());
        });

        depart.valueProperty().addListener((obj, ov, nv) -> {
            if (depart.getSelectionModel().getSelectedItem() != null) {
                Department department = Data.getByName(depart.getSelectionModel().getSelectedItem());
                assert department != null;
                MS.setDisable(!department.getDegrees().isMs());
                Phd.setDisable(!department.getDegrees().isPhd());
                BS2Y.setDisable(!department.getDegrees().isBs2year());
                BS4Y.setDisable(!department.getDegrees().isBs4year());
                try {
                    Data.Temp.getTempStudent().getDepart().getName().set(depart.getSelectionModel().getSelectedItem());
                } catch (WrongInputException e) {
                    e.printStackTrace();
                }
                Test.loader.getDialogs().setCanStudentGo(true);
            }
        });
    }

    private void setValid() {
        canGo = (BS2Y.isSelected() || BS4Y.isSelected() || MS.isSelected() || Phd.isSelected()) && agree.isSelected();
    }

    @Override
    public boolean canGoAhead() {
        return canGo;
    }
}