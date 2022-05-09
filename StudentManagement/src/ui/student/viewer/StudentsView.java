package ui.student.viewer;

import com.jfoenix.controls.*;
import data.Data;
import data.Department;
import data.Student;
import data.info.RollNo;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.Home;
import ui.Test;
import ui.student.admission.StudentAdmission;
import ui.student.editor.StudentEditor;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class StudentsView implements Initializable {

    @FXML private StackPane stack;

    @FXML private JFXTextField search;

    @FXML private JFXButton remove;
    @FXML private JFXButton viewStudent;
    @FXML private JFXButton addNewStudent;

    @FXML private JFXComboBox<String> departs;

    @FXML private TableView<StudentCell> table;
    public static TableView<StudentCell> TABLE;

    @FXML private TableColumn<StudentCell, String> nics;
    @FXML private TableColumn<StudentCell, String> names;
    @FXML private TableColumn<StudentCell, String> emails;
    @FXML private TableColumn<StudentCell, String> genders;
    @FXML private TableColumn<StudentCell, String> contacts;
    @FXML private TableColumn<StudentCell, String> date;
    @FXML private TableColumn<StudentCell, JFXCheckBox> rolls;

    @FXML private JFXRadioButton onlyBS;
    @FXML private JFXRadioButton onlyMS;
    @FXML private JFXRadioButton onlyPhd;

    private static JFXRadioButton OB;
    private static JFXRadioButton OM;
    private static JFXRadioButton OPhd;

    private static JFXComboBox<String> Depart;
    private static JFXComboBox<String> Year;

    @FXML private JFXComboBox<String> year;
    @FXML private JFXComboBox<String> type;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TABLE = table;

        Year = year;
        Depart = departs;

        OB = onlyBS;
        OM = onlyMS;
        OPhd = onlyPhd;

        addNewStudent.setGraphic(new ImageView(getClass().getResource("plus.png").toExternalForm()));
        viewStudent.setGraphic(new ImageView(getClass().getResource("pencil.png").toExternalForm()));
        remove.setGraphic(new ImageView(getClass().getResource("minus.png").toExternalForm()));

        addNewStudent.setText("");
        viewStudent.setText("");
        remove.setText("");

        type.getItems().addAll("Roll #", "Name", "NIC #");
        search.setPromptText("Enter Details.");

        ChangeListener<String> cl1 = (observable, oldValue, newValue) -> {

            if (newValue.equals("")) {
                updateTable(null);
                return;
            }

            ArrayList<Integer> al = new ArrayList<>();
            ArrayList<Student> sl = new ArrayList<>();
            int comp;
            Department department = Data.getByName(departs.getSelectionModel().getSelectedItem());
            if (department != null)
                for (Student student: department.getStudents()) {
                    comp = newValue.compareToIgnoreCase(student.getStudentName().get());
                    if (comp <= 0 && newValue.length() <= student.getRollNo().get().length()) {
                        al.add(comp);
                        sl.add(student);
                    }
                }
            updateTable(sort(al,sl));
        };

        ChangeListener<String> cl2 = (observable, oldValue, newValue) -> {

            if (newValue.equals("")) {
                updateTable(null);
                return;
            }

            ArrayList<Integer> al = new ArrayList<>();
            ArrayList<Student> sl = new ArrayList<>();
            int comp;
            Department department = Data.getByName(departs.getSelectionModel().getSelectedItem());
            if (department != null)
                for (Student student: department.getStudents()) {
                    comp = newValue.compareToIgnoreCase(student.getRollNo().get());
                    if (comp <= 0 && newValue.length() <= student.getRollNo().get().length()) {
                        al.add(comp);
                        sl.add(student);
                    }
                }
            updateTable(sort(al,sl));
        };

        ChangeListener<String> cl3 = (observable, oldValue, newValue) -> {

            if (newValue.equals("")) {
                updateTable(null);
                return;
            }

            ArrayList<Integer> al = new ArrayList<>();
            ArrayList<Student> sl = new ArrayList<>();
            int comp;
            Department department = Data.getByName(departs.getSelectionModel().getSelectedItem());
            if (department != null)
                for (Student student: department.getStudents()) {
                    comp = newValue.compareToIgnoreCase(student.getNicNumber().get());
                    if (comp <= 0 && newValue.length() <= student.getNicNumber().get().length()) {
                        al.add(comp);
                        sl.add(student);
                    }
                }
            updateTable(sort(al,sl));
        };

        type.valueProperty().addListener((obj, ov, nv) -> {
            if (type.getSelectionModel().getSelectedItem() == null)
                return;
            if (type.getSelectionModel().getSelectedItem().equals("Roll #"))
                search.textProperty().addListener(cl2);
            if (type.getSelectionModel().getSelectedItem().equals("Name"))
                search.textProperty().addListener(cl1);
            if (type.getSelectionModel().getSelectedItem().equals("NIC #"))
                search.textProperty().addListener(cl3);
        });

        final ToggleGroup toggleGroup = new ToggleGroup();
        onlyBS.setToggleGroup(toggleGroup);
        onlyMS.setToggleGroup(toggleGroup);
        onlyPhd.setToggleGroup(toggleGroup);

        onlyBS.setSelected(true);

        year.setItems(FXCollections.observableList(getYears()));
        year.setValue(year.getItems().get(0));

        year.valueProperty().addListener((obj, ov, nv) ->{ updateTable(null); });

        toggleGroup.selectedToggleProperty().addListener((obj, ov, nv) -> {
            updateTable(null);
        });

        table.setSelectionModel(null);

        table.getStylesheets().add(getClass().getResource("StudentView.css").toExternalForm());

        nics.setCellValueFactory(param -> param.getValue().nicProperty());
        rolls.setCellValueFactory(param -> param.getValue().rollProperty());
        names.setCellValueFactory(param -> param.getValue().nameProperty());
        emails.setCellValueFactory(param -> param.getValue().emailProperty());
        genders.setCellValueFactory(param -> param.getValue().genderProperty());
        contacts.setCellValueFactory(param -> param.getValue().contactProperty());
        date.setCellValueFactory(param -> param.getValue().timeProperty());

        viewStudent.setOnAction(e -> {
            if (isSelected()) {
                Stage stage = StudentEditor.start(Home.stage, getSelectedStudent());
                if (stage != null)
                    stage.setOnCloseRequest(ee -> updateTable(null));
            }
            else if(getNumberOfSelected() > 1)
                Test.loader.getDialogs().getError().getErrorDialog("You have selected More than One");
            else
                Test.loader.getDialogs().getError().getErrorDialog("Nothing selected.");
        });


        remove.setOnAction(e -> delSelected());

        Test.loader.getDialogs().setStudentParent(stack);

        departs.setOnMousePressed(event -> {
            departs.getItems().clear();
            for (Department department: Data.getDeparts())
                departs.getItems().add(department.getName().get());
        });

        departs.valueProperty().addListener((obj, ov, nv) -> {
            if (departs.getSelectionModel().getSelectedItem() != null) {
                updateTable(null);
            }
        });

        addNewStudent.setOnAction(e-> {
            Stage stage = new Stage();
            StudentAdmission.show(Home.stage, stage);
        });
    }

    private List<Student> sort(List<Integer> list1, List<Student> list2) {
        for (int i = 0; i < list1.size(); i++)
            for (int j = i; j < list1.size(); j++)
                if (list1.get(i) < list1.get(j)) {
                    int temp = list1.get(i);
                    list1.set(i, list1.get(j));
                    list1.set(j, temp);
                    Student tempS = list2.get(i);
                    list2.set(i, list2.get(j));
                    list2.set(j, tempS);
                }
        return list2;
    }

    private int getNumberOfSelected() {
        int i = 0;
        for(StudentCell dc: table.getItems())
            if(dc.rollProperty().get().isSelected())
                i++;
        return i;
    }

    private Student getSelectedStudent() {
        for(StudentCell dc: table.getItems())
            if(dc.rollProperty().get().isSelected())
                return dc.student;
        return null;
    }

    private void delSelected() {
        if(!isSelected()) {
            Test.loader.getDialogs().getError().getErrorDialog("Nothing Selected...").show(stack);
        } else {
            JFXDialog dialog = Test.loader.getDialogs().getWarning().getWarningDialog("Are You Sure, You want to Expel Selected Students ?");
            dialog.setOnDialogClosed(event -> {
                if (Test.loader.getDialogs().getWarning().canDo())
                    while (isSelected())
                        del();
            });
            Platform.runLater(() -> dialog.show(stack));
        }
        table.requestFocus();
    }

    private boolean isSelected() {
        for(StudentCell dc: table.getItems())
            if(dc.rollProperty().get().isSelected())
                return true;
        return false;
    }

    private void del() {
        Department department = Data.getByName(departs.getSelectionModel().getSelectedItem());
        for(StudentCell dc: table.getItems()) {
            if(dc.rollProperty().get().isSelected()) {
                table.getItems().remove(dc);
                try {
                    if (department != null)
                        department.removeStu(dc.student);
                } catch (NullPointerException npe) {
                    npe.printStackTrace();
                }
                return;
            }
        }
    }

    private static class StudentCell {
        private final JFXCheckBox roll = new JFXCheckBox();
        private final StringProperty name;
        private final StringProperty nic;
        private final StringProperty contact;
        private final StringProperty email;
        private final StringProperty gender;
        private final StringProperty date;
        private final Student student;

        StudentCell(Student stu) {
            this(
                    stu.getStudentName().get(),
                    stu.getNicNumber().get(),
                    stu.getStuContact().get(),
                    stu.getEmail().get(),
                    stu.getGender().get(),
                    stu.getRollNo().get(),
                    stu.getTime(),
                    stu
            );
        }

        private StudentCell(String name, String nic, String contact, String email, String gender, String roll,String time, Student stu) {
            this.roll.setText(roll);
            this.name = new SimpleStringProperty(name);
            this.nic = new SimpleStringProperty(nic);
            this.contact = new SimpleStringProperty(contact);
            this.email = new SimpleStringProperty(email);
            this.gender = new SimpleStringProperty(gender);
            this.date = new SimpleStringProperty(time);
            this.student = stu;
        }

        private StringProperty nameProperty() {
            return name;
        }

        private StringProperty nicProperty() {
            return nic;
        }

        private StringProperty contactProperty() {
            return contact;
        }

        private StringProperty emailProperty() {
            return email;
        }

        private StringProperty genderProperty() {
            return gender;
        }

        private StringProperty timeProperty() {
            return date;
        }

        private SimpleObjectProperty<JFXCheckBox> rollProperty() {
            return new SimpleObjectProperty<>(roll);
        }
    }

    private ArrayList<String> getYears() {
        LocalDateTime dt = LocalDateTime.now();
        LocalDate date = dt.toLocalDate();

        int year = date.getYear();
        ArrayList<String> s = new ArrayList<>();

        s.add("" + year--);
        s.add("" + year--);
        s.add("" + year--);
        s.add("" + year);

        return s;
    }

    public static void updateTable(List<Student> list) {
        TABLE.getItems().clear();
        String depart = (String)Depart.getSelectionModel().getSelectedItem();
        if (list == null) {
            Department department = Data.getByName(depart);
            if (null != department && department.getStudents() != null) {
                list = department.getStudents();
            }
        }

        String degree = null;
        if (OM.isSelected()) {
            degree = "MS";
        } else if (OPhd.isSelected()) {
            degree = "Phd";
        } else if (OB.isSelected()) {
            degree = "BS";
        }

        String year = (String)Year.getSelectionModel().getSelectedItem();
        if (list != null && depart != null && degree != null && year != null) {
            Iterator var5 = list.iterator();

            while(var5.hasNext()) {
                Student student = (Student)var5.next();
                if (((RollNo)student.getRollNo()).getYear().equals(year) && student.getDepart().getDegreeCode().equals(degree)) {
                    TABLE.getItems().add(new StudentCell(student));
                }
            }
        }
    }
}