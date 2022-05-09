package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;

public class Loader {

    private Pane home;
    private Pane departView;
    private Pane departEdit;
    private Pane departInput;
    private Pane studentView;
    private Pane studentInput;
    private final Dialogs dialogs = new Dialogs();

    public void loadStuInput() {
        try {
            studentInput = FXMLLoader.load(getClass().getResource("student/admission/StudentAdmission.fxml"));
        } catch (IOException e) {
            studentInput = null;
            e.printStackTrace();
        }
    }

    void loadAll() {
        Pane home;
        Pane departView;
        Pane departEdit;
        Pane departInput;
        Pane studentView;
        Pane studentInput;

        try {
            home = FXMLLoader.load(getClass().getResource("/ui/Home.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            home = null;
        }
        this.home = home;

        try {
            departView = FXMLLoader.load(getClass().getResource("department/viewers/DepartView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            departView = null;
        }
        this.departView = departView;

        try {
            departEdit = FXMLLoader.load(getClass().getResource("department/editor/DepartmentEditor.fxml"));
        } catch (IOException e) {
            departEdit = null;
            e.printStackTrace();
        }
        this.departEdit = departEdit;

        try {
            departInput = FXMLLoader.load(getClass().getResource("department/inputs/DepartInput.fxml"));
        } catch (IOException e) {
            departInput = null;
            e.printStackTrace();
        }
        this.departInput = departInput;

        try {
            studentView = FXMLLoader.load(new URL("file:///C:\\Users\\arish\\IdeaProjects\\StudentManagement\\src\\ui\\student\\viewer\\StudentView.fxml"));
        } catch (IOException e) {
            studentView = null;
            e.printStackTrace();
        }
        this.studentView = studentView;

        try {
            studentInput = FXMLLoader.load(getClass().getResource("student/admission/StudentAdmission.fxml"));
        } catch (IOException e) {
            studentInput = null;
            e.printStackTrace();
        }
        this.studentInput = studentInput;

    }

    public static Pane loadStudentEditor() {
        Pane studentEdit;
        try {
            studentEdit = FXMLLoader.load(Loader.class.getResource("student/editor/StudentEditor.fxml"));
        } catch (IOException e) {
            studentEdit = null;
            e.printStackTrace();
        }
        return studentEdit;
    }

    public Dialogs getDialogs() {
        return dialogs;
    }

    Pane getHome() {
        return home;
    }

    Pane getDepartView() {
        return departView;
    }

    public Pane getDepartEdit() {
        return departEdit;
    }

    private Pane getDepartInput() {
        return departInput;
    }

    Pane getStudentView() {
        return studentView;
    }

    public Pane getStudentInput() {
        return studentInput;
    }

    public class Dialogs {
        private StackPane departParent;
        private JFXDialog departInputDialog;
        private Error error = new Error();
        private Warning warning = new Warning();
        private Success success = new Success();
        private boolean canStudentGo = false;

        public void setCanStudentGo(boolean bool) {
            canStudentGo = bool;
        }

        public boolean canStudentGo() {
            return canStudentGo;
        }

        private Dialogs() {
        }

        public JFXDialog getDepartInputDialog() {
            return departInputDialog;
        }

        public JFXDialog getAndGenerateDepartInputDialog() {
            return (departInputDialog = generateDepartInputDialog());
        }

            public void setDepartParent(StackPane stackPane) {
            this.departParent = stackPane;
        }

        public void setStudentParent(StackPane studentParent) {
        }

        private JFXDialog generateDepartInputDialog() {
            final Pane pane = getDepartInput();

            assert pane != null & departParent != null;
            JFXDialogLayout layout = new JFXDialogLayout();
            layout.setMinSize(pane.getWidth(), pane.getHeight());
            layout.setMaxSize(pane.getWidth(), pane.getHeight());
            layout.setPrefSize(pane.getWidth(), pane.getHeight());
            layout.setHeading(pane);
            return new JFXDialog(departParent, pane, JFXDialog.DialogTransition.CENTER);
        }

        public Error getError() {
            return error;
        }

        public Success getSuccess() {
             return success;
        }

        public Warning getWarning() {
            return warning;
        }

        public class Warning {
            private JFXDialog warningDialog;
            private final Text message = new Text("Unknown Error Occurred");
            private boolean canDo = false;

            private Warning() {
            }

            private JFXDialog generateWarningDialog() {
                final Label heading = new Label("Warning !");
                heading.setStyle("" +
                        "-fx-text-fill: yellow;" +
                        "-fx-font-size: 20px;" +
                        "-fx-effect: dropshadow(three-pass-box, gray, 5, 0, 0.0, 1)" +
                        "");

                message.setStyle("" +
                        "-fx-text-fill: black;" +
                        "-fx-font-size: 13px;" +
                        "-fx-alignment: center" +
                        "");

                final JFXButton yesBtn = new JFXButton("Yes");
                final JFXButton noBtn = new JFXButton("no");

                final JFXDialogLayout layout = new JFXDialogLayout();
                layout.setHeading(heading);
                layout.setBody(message);
                layout.setActions(yesBtn, noBtn);

                final JFXDialog dialog = new JFXDialog(null, layout, JFXDialog.DialogTransition.CENTER);
                yesBtn.setOnAction(event ->  {
                    dialog.close();
                    canDo = true;
                });
                noBtn.setOnAction(event -> {
                    dialog.close();
                    canDo = false;
                });

                return dialog;
            }

            public JFXDialog getWarningDialog(String error) {
                warningDialog = generateWarningDialog();
                message.setText(error);
                return warningDialog;
            }

            public boolean canDo() {
                return canDo;
            }
        }

        public class Error {
            private JFXDialog errorDialog;
            private final Text message = new Text();

            private Error() {
            }

            private JFXDialog generateErrorDialog() {
                final Label heading = new Label("Error !");
                heading.setStyle("" +
                        "-fx-text-fill: red;" +
                        "-fx-font-size: 20px;" +
                        "-fx-effect: dropshadow(three-pass-box, gray, 5, 0, 0.0, 1)" +
                        "");

                message.setStyle("" +
                        "-fx-text-fill: black;" +
                        "-fx-font-size: 13px;" +
                        "-fx-alignment: center" +
                        "");

                final JFXButton okBtn = new JFXButton("Okay");

                final JFXDialogLayout layout = new JFXDialogLayout();
                layout.setHeading(heading);
                layout.setBody(message);
                layout.setActions(okBtn);

                final JFXDialog dialog = new JFXDialog(null, layout, JFXDialog.DialogTransition.CENTER);
                okBtn.setOnAction(event -> dialog.close());

                return dialog;
            }

            public JFXDialog getErrorDialog(String error) {
                errorDialog = generateErrorDialog();
                message.setText(error);
                return errorDialog;
            }
        }

        public class Success {
            private JFXDialog successDialog;
            private final Text message = new Text();

            private Success() {
            }

            private JFXDialog generateSuccessDialog() {
                final Label heading = new Label("Success !");
                heading.setStyle("" +
                        "-fx-text-fill: green;" +
                        "-fx-font-size: 20px;" +
                        "-fx-effect: dropshadow(three-pass-box, gray, 5, 0, 0.0, 1)" +
                        "");

                message.setStyle("" +
                        "-fx-text-fill: black;" +
                        "-fx-font-size: 13px;" +
                        "-fx-alignment: center" +
                        "");

                final JFXButton okBtn = new JFXButton("Okay");

                final JFXDialogLayout layout = new JFXDialogLayout();
                layout.setHeading(heading);
                layout.setBody(message);
                layout.setActions(okBtn);

                final JFXDialog dialog = new JFXDialog(null, layout, JFXDialog.DialogTransition.CENTER);
                okBtn.setOnAction(event -> dialog.close());

                return dialog;
            }

            public JFXDialog getSuccessDialog(String error, double width) {
                successDialog = generateSuccessDialog();
                successDialog.getContent().setMaxWidth(width);
                message.setText(error);
                return successDialog;
            }
        }
    }
}