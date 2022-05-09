package ui.department.viewers;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import data.Data;
import data.Department;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.Home;
import ui.Test;
import ui.department.editor.DepartmentEditor;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartmentView implements Initializable {

    @FXML private JFXButton remove;
    @FXML private JFXButton viewDepart;
    @FXML private JFXButton addNewDepart;

    @FXML private StackPane stack;
    @FXML private BorderPane borderPane;

    @FXML private TableView<DepartmentCell> table;

    @FXML private TableColumn<DepartmentCell, String> names;
    @FXML private TableColumn<DepartmentCell, String> number;
    @FXML private TableColumn<DepartmentCell, String> degrees;
    @FXML private TableColumn<DepartmentCell, String> time;
    @FXML private TableColumn<DepartmentCell, JFXCheckBox> serial;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addNewDepart.setGraphic(new ImageView(getClass().getResource("plus.png").toExternalForm()));
        viewDepart.setGraphic(new ImageView(getClass().getResource("pencil.png").toExternalForm()));
        remove.setGraphic(new ImageView(getClass().getResource("minus.png").toExternalForm()));

        addNewDepart.setText("");
        viewDepart.setText("");
        remove.setText("");

        Test.loader.getDialogs().setDepartParent(stack);

        for (Department department: Data.getDeparts())
            table.getItems().addAll(new DepartmentCell(department));

        table.setSelectionModel(null);

        table.getStylesheets().add(getClass().getResource("DepartmentView.css").toExternalForm());

        names.setCellValueFactory(param -> param.getValue().nameProperty());
        degrees.setCellValueFactory(param -> param.getValue().degreesProperty());
        number.setCellValueFactory(param -> param.getValue().sizeProperty());
        serial.setCellValueFactory(param -> param.getValue().getSelection());
        time.setCellValueFactory(param -> param.getValue().timeProperty());

        remove.setOnAction(e-> delSelected());
        addNewDepart.setOnAction(e-> addNew());


        viewDepart.setOnAction(e-> {
            int i = getNumberOfSelected();
            if(i == 1) {
                final Stage stage = new Stage();
                DepartmentEditor.show(Home.stage, stage, Data.getByName(getSelected()));
                stage.setOnCloseRequest(event -> {
                    table.getItems().clear();
                    for (Department department: Data.getDeparts())
                        table.getItems().addAll(new DepartmentCell(department));
                });
            }
            else if(i > 1) {
                borderPane.setDisable(true);
                JFXDialog dialog = Test.loader.getDialogs().getError().getErrorDialog("You have Selected More than one...");
                dialog.setOnDialogClosed(ee-> borderPane.setDisable(false));
                dialog.show(stack);
            } else
                Test.loader.getDialogs().getError().getErrorDialog("Error Nothing Selected").show(stack);
        });
    }

    private void addNew() {
        Platform.runLater(() ->
            Platform.runLater(() -> {
                JFXDialog dialog = Test.loader.getDialogs().getAndGenerateDepartInputDialog();
                dialog.show(stack);
                dialog.setOnDialogClosed(e -> {
                    table.getItems().clear();
                    for (Department department: Data.getDeparts())
                        table.getItems().addAll(new DepartmentCell(department));
                });
            })
        );
    }

    private String getSelected() {
        for(DepartmentCell dc: table.getItems())
            if(dc.getSelection().get().isSelected())
                return dc.nameProperty().get();
        return null;
    }

    private int getNumberOfSelected() {
        int i = 0;
        for(DepartmentCell dc: table.getItems())
            if(dc.getSelection().get().isSelected())
                i++;
        return i;
    }

    private void delSelected() {
        if(!isSelected()) {
            JFXDialog dialog = Test.loader.getDialogs().getError().getErrorDialog("Nothing Selected.");
            dialog.show(stack);
        } else {
            JFXDialog dialog = Test.loader.getDialogs().getWarning().getWarningDialog("Are you Sure, You want to delete Selected ?");
            dialog.setOnDialogClosed(e -> {
                if (Test.loader.getDialogs().getWarning().canDo())
                    while(isSelected())
                        del();
            });
            dialog.show(stack);
        }
    }

    private boolean isSelected() {
        for(DepartmentCell dc: table.getItems())
            if(dc.getSelection().get().isSelected())
                return true;
        return false;
    }

    private void del() {
        if (table.getItems() == null)
            return;

        for(DepartmentCell dc: table.getItems()) {
            if(dc.getSelection().get().isSelected()) {
                table.getItems().remove(dc);
                Department d = Data.getByName(dc.nameProperty().get());
                if (d != null) {
                    Data.remove(d);
                    return;
                }
            }
        }
    }


    private final static class DepartmentCell extends RecursiveTreeObject<DepartmentCell> {

        private final JFXCheckBox selection = new JFXCheckBox();
        private final StringProperty name;
        private final StringProperty size;
        private final StringProperty degrees;
        private final StringProperty time;

        DepartmentCell(Department depart) {
            this(depart.getName().get(),depart.getStudents().size()+"", depart.getDegrees().toString(), depart.getTime());
        }

        DepartmentCell(String name, String size, String degrees, String time) {
            this.name = new SimpleStringProperty(name);
            this.size = new SimpleStringProperty(size);
            this.degrees = new SimpleStringProperty(degrees);
            this.time = new SimpleStringProperty(time);
        }

        StringProperty nameProperty() {
            return name;
        }

        StringProperty sizeProperty() {
            return size;
        }

        StringProperty degreesProperty() {
            return degrees;
        }

        StringProperty timeProperty() {
            return time;
        }

        SimpleObjectProperty<JFXCheckBox> getSelection() {
            return new SimpleObjectProperty<>(selection);
        }
    }
}