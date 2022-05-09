package ui.department.inputs;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import data.Data;
import ui.Test;
import utilities.UIUtilities;
import SMExceptions.naming_exceptions.*;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartInput implements Initializable {

    @FXML private JFXButton add;

    @FXML private Label errorBool;
    @FXML private Label errorDepartName;

    @FXML private JFXCheckBox bool1;
    @FXML private JFXCheckBox bool2;
    @FXML private JFXCheckBox bool3;
    @FXML private JFXCheckBox bool4;

    @FXML private JFXTextField departName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        add.setOnAction(e -> {
            if (!(bool1.isSelected() && bool2.isSelected() && bool3.isSelected() && bool4.isSelected()))
                UIUtilities.animateError(errorBool, "No Option Selected");
            if (departName.getText().equals("") || departName.getText() == null)
                UIUtilities.animateError(errorDepartName, "No Name Entered");
            else {
                Data.Temp.getTempDepartment().getDegrees().set(bool1.isSelected(), bool2.isSelected(), bool3.isSelected(), bool4.isSelected());
                Data.add(Data.Temp.getTempDepartment().clone());
                Data.Temp.clearDepartment();
                Test.loader.getDialogs().getDepartInputDialog().close();
                departName.setText("");
                errorDepartName.setVisible(false);
                bool1.setSelected(false);
                bool2.setSelected(false);
                bool3.setSelected(false);
                bool4.setSelected(false);
                errorBool.setVisible(false);
            }
        });

        departName.textProperty().addListener((obj, ov, nv) -> {
            errorDepartName.setVisible(false);
            try {
                Data.Temp.getTempDepartment().getName().set(nv);
            } catch (WrongInputException wie) {
                UIUtilities.animateError(errorDepartName, wie.getMessage());
            }
        });

        bool1.selectedProperty().addListener((obj, ov, nv) -> errorBool.setVisible(false));
        bool2.selectedProperty().addListener((obj, ov, nv) -> errorBool.setVisible(false));
        bool3.selectedProperty().addListener((obj, ov, nv) -> errorBool.setVisible(false));
        bool4.selectedProperty().addListener((obj, ov, nv) -> errorBool.setVisible(false));
    }
}