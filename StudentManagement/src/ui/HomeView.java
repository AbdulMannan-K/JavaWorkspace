package ui;

import com.jfoenix.controls.JFXListView;
import data.Data;
import data.Department;
import data.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeView implements Initializable {

    @FXML private Label total;
    @FXML private Label males;
    @FXML private Label females;

    @FXML private JFXListView<String> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int males = 0, females = 0;
        list.setStyle("-fx-font-size: 17px;");
        list.getItems().clear();
        for (Department department: Data.getDeparts()) {
            list.getItems().add(department.getName().get());
            for (Student student: department.getStudents()) {
                if (student.getGender().get().equals("Male"))
                    males++;
                else
                    females++;
            }
        }

        this.total.setText((males + females) + "");
        this.males.setText(males + "");
        this.females.setText(females + "");
    }
}
