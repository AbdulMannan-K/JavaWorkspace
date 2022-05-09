package ui.student.admission.inputs;

import SMExceptions.naming_exceptions.*;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import data.Data;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import ui.student.admission.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Input3 implements Initializable, Controller {

    @FXML private Label errorMail;
    @FXML private Label errorEmail;
    @FXML private DatePicker datePicker;
    @FXML private JFXTextArea address;
    @FXML private JFXTextField email;

    private static boolean canGo = false;

    @Override public void initialize(URL location, ResourceBundle resources) {
        datePicker.getEditor().textProperty().addListener((obj, ov, nv) -> {
            try {
                LocalDate ld = datePicker.getValue();
                Data.Temp.getTempStudent().getDateOfBirth().set(ld.getDayOfMonth() + "/" + ld.getMonth().getValue() + "/" + ld.getYear());
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
            setValid();
        });

        address.textProperty().addListener((obj, ov, nv) -> {
            errorMail.setVisible(false);
            try {
                Data.Temp.getTempStudent().getAddress().set(nv);
            } catch (WrongInputException wie) {
                utilities.UIUtilities.animateError(errorMail, wie.getMessage());
            }
            setValid();
        });

        email.textProperty().addListener((obj, ov, nv) -> {
            errorEmail.setVisible(false);
            try {
                Data.Temp.getTempStudent().getEmail().set(nv);
            } catch (WrongInputException wie) {
                utilities.UIUtilities.animateError(errorEmail, wie.getMessage());
            }
            setValid();
        });
    }

    private void setValid() {
        canGo = (!errorMail.isVisible()) && (!errorEmail.isVisible()) && (!datePicker.getEditor().getText().equals(""));
    }

    @Override public boolean canGoAhead() {
        return canGo;
    }
}