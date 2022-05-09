package ui.student.admission.inputs;

import SMExceptions.naming_exceptions.*;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import data.Data;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import ui.student.admission.Controller;
import utilities.UIUtilities;

import java.net.URL;
import java.util.ResourceBundle;

public class Input1 implements Initializable, Controller {

    @FXML private Label stuNameError;
    @FXML private JFXTextField stuName;
    @FXML private JFXRadioButton genderMale;
    @FXML private JFXRadioButton genderFemale;

    private static boolean canGo = false;

    @Override public void initialize(URL location, ResourceBundle resources) {
        final ToggleGroup toggleGroup = new ToggleGroup();
        genderMale.setToggleGroup(toggleGroup);
        genderFemale.setToggleGroup(toggleGroup);

        stuName.textProperty().addListener((obj, ov, nv) -> {
            stuNameError.setVisible(false);
            try {
                Data.Temp.getTempStudent().getStudentName().set(nv);
            } catch (WrongInputException wie) {
                UIUtilities.animateError(stuNameError, wie.getMessage());
            }
            setValid();
        });

        toggleGroup.selectedToggleProperty().addListener((obj, ov, nv) -> {
            try {
                if (genderMale.isSelected())
                    Data.Temp.getTempStudent().getGender().set("Male");
                else
                    Data.Temp.getTempStudent().getGender().set("Female");
            } catch (WrongInputException wie) {
                wie.printStackTrace();
            }
            setValid();
        });
    }

    private void setValid() {
        canGo = (genderMale.isSelected() || genderFemale.isSelected()) && !stuNameError.isVisible();
    }

    @Override public boolean canGoAhead() {
        return canGo;
    }
}