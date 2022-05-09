package ui.student.editor;

import SMExceptions.naming_exceptions.WrongInputException;
import com.jfoenix.controls.*;
import data.Data;
import data.Department;
import data.Student;
import data.info.SMDate;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.Home;
import ui.Loader;
import utilities.UIUtilities;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentEditor implements Initializable{
    @FXML private JFXButton next;
    @FXML private JFXButton prev;

    @FXML private JFXTextField stuName;
    @FXML private JFXTextField fatherName;
    @FXML private JFXTextField motherName;
    @FXML private JFXTextField contact;
    @FXML private JFXTextField contactFather;
    @FXML private JFXTextField email;
    @FXML private JFXDatePicker DOB;
    @FXML private JFXRadioButton male;
    @FXML private JFXRadioButton female;

    @FXML private JFXToggleButton toggleEditing;

    @FXML private AnchorPane inputs;
    @FXML private AnchorPane main;
    @FXML private VBox show;

    @FXML private BorderPane border;

    @FXML private Label show1;
    @FXML private Label show2;
    @FXML private Label show3;
    @FXML private Label show4;
    @FXML private Label show5;
    @FXML private Label show6;
    @FXML private Label show7;
    @FXML private Label show8;
    @FXML private Label show9;
    @FXML private Label show10;
    @FXML private Label show11;

    @FXML private Label stuError;
    @FXML private Label fatherError;
    @FXML private Label motherError;
    @FXML private Label emailError;
    @FXML private Label contactError;
    @FXML private Label fatherOccupationError;
    @FXML private Label fatherContactError;
    @FXML private Label addressError;
    @FXML private Label NICError;

    @FXML private JFXTextArea address;
    @FXML private JFXTextArea occupation;

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

    Student studen = new Student();

    private final ArrayList<JFXTextField> nicNumber = new ArrayList<>();

    private static int index = 0;

    private static Student tempStudent = new Student();
    private static Student STUDENT;
    private static Department DEPARTMENT;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nicNumber.addAll(FXCollections.observableArrayList(nic1, nic2, nic3, nic4, nic5, nic6, nic7, nic8, nic9, nic10, nic11, nic12, nic13));
        final ToggleGroup toggleGroup = new ToggleGroup();
        male.setToggleGroup(toggleGroup);
        female.setToggleGroup(toggleGroup);
        setInputs(STUDENT);

        toggleGroup.selectedToggleProperty().addListener((obj, ov, nv) -> {
            if (male.isSelected()) {
                try {
                    tempStudent.getGender().set("Male");
                } catch (WrongInputException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    tempStudent.getGender().set("Female");
                } catch (WrongInputException e) {
                    e.printStackTrace();
                }
            }
        });

        stuName.textProperty().addListener((obj, ov, nv) -> {
            stuError.setVisible(false);
            try {
                tempStudent.getStudentName().set(nv);
            } catch (WrongInputException e) {
                UIUtilities.animateError(stuError, e.getMessage());
            }
        });

        fatherName.textProperty().addListener((obj, ov, nv) -> {
            fatherError.setVisible(false);
            try {
                tempStudent.getFatherName().set(nv);
            } catch (WrongInputException e) {
                UIUtilities.animateError(fatherError, e.getMessage());
            }
        });

        motherName.textProperty().addListener((obj, ov, nv) -> {
            motherError.setVisible(false);
            try {
                tempStudent.getMotherName().set(nv);
            } catch (WrongInputException e) {
                UIUtilities.animateError(motherError, e.getMessage());
            }
        });

        contact.textProperty().addListener((obj, ov, nv) -> {
            contactError.setVisible(false);
            try {
                tempStudent.getStuContact().set(nv);
            } catch (WrongInputException e) {
                UIUtilities.animateError(contactError, e.getMessage());
            }
        });

        contactFather.textProperty().addListener((obj, ov, nv) -> {
            fatherContactError.setVisible(false);
            try {
                tempStudent.getFathersContact().set(nv);
            } catch (WrongInputException e) {
                UIUtilities.animateError(fatherContactError, e.getMessage());
            }
        });

        email.textProperty().addListener((obj, ov, nv) -> {
            emailError.setVisible(false);
            try {
                tempStudent.getEmail().set(nv);
            } catch (WrongInputException e) {
                UIUtilities.animateError(emailError, e.getMessage());
            }
        });

        address.textProperty().addListener((obj, ov, nv) -> {
            addressError.setVisible(false);
            try {
                tempStudent.getAddress().set(nv);
            } catch (WrongInputException e) {
                UIUtilities.animateError(addressError, e.getMessage());
            }
        });

        occupation.textProperty().addListener((obj, ov, nv) -> {
            fatherOccupationError.setVisible(false);
            try {
                tempStudent.getFathersOccupation().set(nv);
            } catch (WrongInputException e) {
                UIUtilities.animateError(fatherOccupationError, e.getMessage());
            }
        });

        DOB.getEditor().textProperty().addListener((obj, ov, nv) -> {
            try {
                LocalDate ld = DOB.getValue();
                tempStudent.getDateOfBirth().set(ld.getDayOfMonth() + "/" + ld.getMonth().getValue() + "/" + ld.getYear());
            } catch (WrongInputException e) {
                e.printStackTrace();
            }
        });

        for (JFXTextField textField: nicNumber) {

            textField.textProperty().addListener((obj, ov, nv) ->
                Platform.runLater(()-> {
                    if (nv.length() > 1)
                        textField.setText(nv.charAt(nv.length() - 1) + "");

                    int index = nicNumber.indexOf(textField);
                    if (index != nicNumber.size() - 1)
                        nicNumber.get(index + 1).requestFocus();

                    createNIC();
                })
            );

            textField.setOnKeyPressed(keyEvent ->
                Platform.runLater(()-> {
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

                    createNIC();
                })
            );

            textField.focusedProperty().addListener((obj, ov, nv) ->
                Platform.runLater(()-> {
                    if (nv)
                        textField.selectAll();
                })
            );

            textField.setOnMousePressed(e -> textField.requestFocus());
        }

        next.setGraphic(new ImageView(Home.class.getResource("graphics/chevron_left_white_24x24.png").toExternalForm()));
        prev.setGraphic(new ImageView(Home.class.getResource("graphics/chevron_right_white_24x24.png").toExternalForm()));

        update();

        main.getChildren().remove(inputs);

        setStudent(STUDENT);
        inputs.setOpacity(0);
        toggleEditing.setOnAction(event -> {
            if (!(!stuError.isVisible() & !fatherError.isVisible() & !motherError.isVisible() & !contactError.isVisible() &
                    !fatherContactError.isVisible() & !fatherOccupationError.isVisible() & !emailError.isVisible() & !addressError.isVisible() & !NICError.isVisible())) {
                toggleEditing.setSelected(true);
            }

        });

        toggleEditing.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (toggleEditing.isSelected()) {
                UIUtilities.createFadeTransition(show, 1.0, 1, true, e -> {
                    border.setRight(inputs);
                    UIUtilities.createFadeTransition(inputs, 1.0, 1, false).play();
                }).play();
            } else {
                UIUtilities.createFadeTransition(inputs, 1.0, 1, true, e -> {
                    if (!STUDENT.equals(tempStudent)) {
                        DEPARTMENT.removeStu(STUDENT);
                        STUDENT = tempStudent.clone();
                        DEPARTMENT.addStu(STUDENT);
                        setStudent(STUDENT);
                    }
                    border.setRight(show);
                    UIUtilities.createFadeTransition(show, 1.0, 1, false).play();
                }).play();

            }
        });

        next.setOnAction(event -> {
            setStudent((STUDENT = DEPARTMENT.getStudents().get(++index)));
            tempStudent = STUDENT.clone();
            update();
        });

        prev.setOnAction(event -> {
            setStudent((STUDENT = DEPARTMENT.getStudents().get(--index)));
            tempStudent = STUDENT.clone();
            update();
        });
    }

    private void setInputs(Student stu) {

        for (int i = 0; i< nicNumber.size(); i++)
            nicNumber.get(i).setText(stu.getNicNumber().get().charAt(i) + "");

        stuName.setText(stu.getStudentName().get());
        fatherName.setText(stu.getFatherName().get());
        motherName.setText(stu.getMotherName().get());
        DOB.setValue(((SMDate)stu.getDateOfBirth()).getDate());
        contact.setText(stu.getStuContact().get());
        contactFather.setText(stu.getFathersContact().get());
        email.setText(stu.getEmail().get());

        if (stu.getGender().get().equals("Male"))
            male.setSelected(true);
        else
            female.setSelected(true);

        occupation.setText(stu.getFathersOccupation().get());
        address.setText(stu.getAddress().get());
    }

    private void setStudent(Student stu) {
        show1.setText(stu.getStudentName().get());
        show2.setText(stu.getFatherName().get());
        show3.setText(stu.getMotherName().get());
        show4.setText(stu.getGender().get());
        show5.setText(stu.getDateOfBirth().get());
        show6.setText(stu.getNicNumber().get());
        show7.setText(stu.getStuContact().get());
        show8.setText(stu.getAddress().get());
        show9.setText(stu.getFathersContact().get());
        show10.setText(stu.getFathersOccupation().get());
        show11.setText(stu.getEmail().get());
    }

    private void update() {
        if (DEPARTMENT != null) {
            if (index == DEPARTMENT.getStudents().size() - 1)
                next.setDisable(true);
            else
                next.setDisable(false);

            if (index == 0)
                prev.setDisable(true);
            else
                prev.setDisable(false);
        }
    }

    public static Stage start(Stage parent, Student student) {
        STUDENT = student;

        DEPARTMENT = Data.getByName(STUDENT.getDepart().getName().get());

        tempStudent = STUDENT.clone();

        if (DEPARTMENT != null)
            index = DEPARTMENT.getStudents().indexOf(student);
        else
            return null;

        Stage stage = new Stage();

        if (stage.getOwner() == null)
            stage.initOwner(parent);

        if (stage.getScene() == null)
            stage.setScene(new Scene(Loader.loadStudentEditor()));

        stage.show();
        return stage;
    }

    private String generateNumber() {
        StringBuilder sb = new StringBuilder("");

        for(JFXTextField tf: nicNumber)
            if(tf.getText() != null && !tf.getText().equals(""))
                sb.append(tf.getText());

        return sb.toString();
    }

    private void createNIC() {
        NICError.setVisible(false);
        try {
            tempStudent.getNicNumber().set(generateNumber());
        } catch (WrongInputException wie) {
            UIUtilities.animateError(NICError, wie.getMessage());
        }
    }
}