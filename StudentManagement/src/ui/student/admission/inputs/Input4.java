package ui.student.admission.inputs;

import SMExceptions.naming_exceptions.*;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import data.Data;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import ui.student.admission.Controller;

import java.net.URL;
import java.util.ResourceBundle;

public class Input4 implements Initializable, Controller {

    @FXML private Label errorOccupation;
    @FXML private Label errorContactStu;
    @FXML private Label errorContactFather;
    @FXML private JFXTextArea occupation;
    @FXML private JFXTextField contactStu;
    @FXML private JFXTextField contactFather;

    private static boolean canGo = false;

    @Override public void initialize(URL location, ResourceBundle resources) {
        contactFather.textProperty().addListener((obj, ov, nv) -> {
            errorContactFather.setVisible(false);
            try {
                Data.Temp.getTempStudent().getFathersContact().set(nv);
            } catch (WrongInputException wie) {
                utilities.UIUtilities.animateError(errorContactFather, wie.getMessage());
            }
            setValid();
        });

        contactStu.textProperty().addListener((obj, ov, nv) -> {
            errorContactStu.setVisible(false);
            try {
                Data.Temp.getTempStudent().getStuContact().set(nv);
            } catch (WrongInputException wie) {
                utilities.UIUtilities.animateError(errorContactStu, wie.getMessage());
            }
            setValid();
        });

        occupation.textProperty().addListener((obj, ov, nv) -> {
            errorOccupation.setVisible(false);
            try {
                Data.Temp.getTempStudent().getFathersOccupation().set(nv);
            } catch (WrongInputException wie) {
                utilities.UIUtilities.animateError(errorOccupation, wie.getMessage());
            }
            setValid();
        });
    }

    private void setValid() { canGo = !errorContactStu.isVisible() && !errorContactFather.isVisible() && !errorOccupation.isVisible(); }

    @Override public boolean canGoAhead() {
        return canGo;
    }
}