package ui.student.admission.inputs;

import SMExceptions.naming_exceptions.WrongInputException;
import com.jfoenix.controls.JFXTextField;
import data.Data;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import ui.student.admission.Controller;
import utilities.UIUtilities;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Input2 implements Initializable, Controller {

    @FXML private Label errorNic;
    @FXML private Label errorFatherName;
    @FXML private Label errorMotherName;
    @FXML private JFXTextField nic1;
    @FXML private JFXTextField nic2;
    @FXML private JFXTextField nic3;
    @FXML private JFXTextField nic4;
    @FXML private JFXTextField nic5;
    @FXML private JFXTextField nic6;
    @FXML private JFXTextField nic7;
    @FXML private JFXTextField nic8;
    @FXML private JFXTextField nic9;
    @FXML private JFXTextField nic10;
    @FXML private JFXTextField nic11;
    @FXML private JFXTextField nic12;
    @FXML private JFXTextField nic13;
    @FXML private JFXTextField fathersName;
    @FXML private JFXTextField mothersName;

    private static boolean canGo = false;

    private final ArrayList<JFXTextField> nicNumber = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nicNumber.addAll(FXCollections.observableArrayList(nic1, nic2, nic3, nic4, nic5, nic6, nic7, nic8, nic9, nic10, nic11, nic12, nic13));

        fathersName.textProperty().addListener((obj, ov, nv) -> {
            errorFatherName.setVisible(false);
            try {
                Data.Temp.getTempStudent().getFatherName().set(nv);
            } catch (WrongInputException wie) {
                UIUtilities.animateError(errorFatherName, wie.getMessage());
            }
        });

        mothersName.textProperty().addListener((obj, ov, nv) -> {
            errorMotherName.setVisible(false);
            try {
                Data.Temp.getTempStudent().getMotherName().set(nv);
            } catch (WrongInputException wie) {
                UIUtilities.animateError(errorMotherName, wie.getMessage());
            }
        });

        for (JFXTextField textField: nicNumber) {
            textField.textProperty().addListener((obj, ov, nv) -> {
                if (nv.length() > 1)
                    textField.setText(nv.charAt(nv.length() - 1) + "");

                int index = nicNumber.indexOf(textField);
                if (index != nicNumber.size() - 1)
                    nicNumber.get(index + 1).requestFocus();

                setValid();
            });

            textField.setOnKeyPressed(keyEvent -> {
                int index = nicNumber.indexOf(textField);

                if (keyEvent.getCode() == KeyCode.BACK_SPACE)
                    if (index != 0)
                        nicNumber.get(index - 1).requestFocus();

                if (keyEvent.getCode() == KeyCode.LEFT) {
                    if (index == 0)
                        textField.requestFocus();
                    else
                        nicNumber.get(index - 1).requestFocus();
                }

                if (keyEvent.getCode() == KeyCode.RIGHT) {
                    if (index == nicNumber.size() - 1)
                        textField.requestFocus();
                    else
                        nicNumber.get(index + 1).requestFocus();
                }

                setValid();
            });

            textField.focusedProperty().addListener((obj, ov, nv) -> {
                if (nv)
                    textField.selectAll();
            });

            textField.setOnMousePressed(e -> textField.requestFocus());
        }
    }

    private void setValid() {
        canGo = !errorFatherName.isVisible() && !errorMotherName.isVisible() && createNIC();
    }

    private boolean createNIC() {
        errorNic.setVisible(false);
        try {
            Data.Temp.getTempStudent().getNicNumber().set(generateNumber());
        } catch (WrongInputException wie) {
            UIUtilities.animateError(errorNic, wie.getMessage());
            return false;
        }
        return true;
    }

    private String generateNumber() {
        StringBuilder sb = new StringBuilder("");

        for(JFXTextField tf: nicNumber)
            if(tf.getText() != null && !tf.getText().equals(""))
                sb.append(tf.getText());

        return sb.toString();
    }

    @Override
    public boolean canGoAhead() {
        return canGo;
    }
}