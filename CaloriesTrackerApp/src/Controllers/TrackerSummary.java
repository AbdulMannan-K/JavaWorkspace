package Controllers;

import Models.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackerSummary {

    @FXML
    private Label calories;
    @FXML
    private GridPane gridPane;
    @FXML
    private PieChart pie;
    @FXML
    private Label carbperc;
    @FXML
    private Label properc;
    @FXML
    private Label fatperc;

    public void tracker(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/TrackerMain.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(){
        double calori =0;int i=0;
        double fatp=0,proteinp=0,carbp=0;

        for(Item item : LoginSignup.user.getTracker().getItems()){
            calori+=(4*item.getProtein())+(4*item.getCarbs())+(9*item.getFat());
            fatp+=item.getFat();
            proteinp+=item.getProtein();
            carbp+=item.getCarbs();
            i++;
        }
        calories.setText("Total Calories : " + String.valueOf(calori));

        Label[][] labels = new Label[i][4];

        for(int j=0 ; j < i ; j++){
            labels[j][0] = new Label(LoginSignup.user.getTracker().getItems().get(j).getName());
            labels[j][1] = new Label(String.valueOf(LoginSignup.user.getTracker().getItems().get(j).getFat()));
            labels[j][1].setPrefHeight(20);
            labels[j][1].setCenterShape(true);
            labels[j][2] = new Label(String.valueOf(LoginSignup.user.getTracker().getItems().get(j).getCarbs()));
            labels[j][2].setPrefHeight(20);
            labels[j][3] = new Label(String.valueOf(LoginSignup.user.getTracker().getItems().get(j).getProtein()));
            labels[j][3].setPrefHeight(20);
            gridPane.addRow(j+1,labels[j][0],labels[j][1],labels[j][2],labels[j][3]);
        }

        fatp = calori/fatp;
        carbp = calori/carbp;
        proteinp = calori/proteinp;

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Fat",fatp),
                        new PieChart.Data("Protein",proteinp),
                        new PieChart.Data("Carbs",carbp)
                );

        pie.setData(pieChartData);
        System.out.println(pie.isLegendVisible());

        properc.setText("Proteins : " + String.valueOf(proteinp));
        carbperc.setText("Carbs : " + String.valueOf(carbp));
        fatperc.setText("Fats : " + String.valueOf(fatp));

    }

}
