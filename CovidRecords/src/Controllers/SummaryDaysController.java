package Controllers;

import Data.AllRecord;
import Models.Group;
import Models.Record;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.IOException;

public class SummaryDaysController {

    @FXML
    private Label countryName;
    @FXML
    private Label population;
    @FXML
    private GridPane pane;
    @FXML
    private ComboBox<String> daysGroups;
    @FXML
    private BarChart chart;
    @FXML
    private BarChart deathsChart;
    @FXML
    private BarChart vacChart;

    ObservableList<String> allGroups = FXCollections.observableArrayList();

    public void initialize(){


        countryName.setText("Country : " + AllRecord.Allgroups.get(0).getGroups().get(0).getCountryName());
        population.setText("Population : " + String.valueOf(AllRecord.Allgroups.get(0).getGroups().get(0).getPopulation()));

        for(Group group : AllRecord.Allgroups){
            String range = group.getGroups().get(0).getDate() + " to " + group.getGroups().get(group.getGroups().size()-1).getDate();
            allGroups.add(range);
        }

        daysGroups.setItems(allGroups);
        int[] i = {1};
        daysGroups.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                if(chart.getData().size()>0) {
                    chart.getData().removeAll(chart.getData());
                    deathsChart.getData().removeAll(deathsChart.getData());
                    vacChart.getData().removeAll(vacChart.getData());
                }

                for(Group group : AllRecord.Allgroups){
                    if(t1.equals(group.getGroups().get(0).getDate() + " to " + group.getGroups().get(group.getGroups().size()-1).getDate())){
                        System.out.println(pane.getRowConstraints().size());
                        if(i[0]!=1){
                            for(int j=1 ; j < i[0] ; j++){
                                pane.getRowConstraints().get(j).setMaxHeight(0);
                            }
                        }
                        for(Record record : group.getGroups()){
                            Label date = new Label(record.getDate());
                            date.setPrefHeight(20);
                            date.setMinHeight(0);
                            pane.setHalignment(date,HPos.CENTER);
                             Label newCases = new Label(String.valueOf(record.getNewCases()));
                             newCases.setPrefHeight(20);
                            newCases.setMinHeight(0);
                            pane.setHalignment(newCases, HPos.CENTER);
                            Label newDeaths = new Label(String.valueOf(record.getNewDeaths()));
                             newDeaths.setPrefHeight(20);
                             newDeaths.setMinHeight(0);
                            pane.setHalignment(newDeaths, HPos.CENTER);
                            Label vacPeople = new Label(String.valueOf(record.getPeopleVaccinated()));
                             vacPeople.setPrefHeight(20);
                             vacPeople.setMinHeight(0);
                            pane.setHalignment(vacPeople, HPos.CENTER);
                            pane.addRow(i[0],date,newCases,newDeaths,vacPeople);
                            pane.getRowConstraints().add(new RowConstraints(20));
                            i[0]++;
                        }


                        XYChart.Series data = new XYChart.Series();
                        XYChart.Series deathData = new XYChart.Series();
                        XYChart.Series vacData = new XYChart.Series();
                        for(Record record : group.getGroups()){
                            data.getData().add(new XYChart.Data(record.getDate(),record.getNewCases()));
                            deathData.getData().add(new XYChart.Data(record.getDate(),record.getNewDeaths()));
                            vacData.getData().add(new XYChart.Data(record.getDate(),record.getPeopleVaccinated()));
                        }
                        chart.getData().addAll(data);
                        chart.getXAxis().setLabel("Date");
                        chart.getYAxis().setLabel("New Cases");
                        deathsChart.getData().addAll(deathData);
                        deathsChart.getXAxis().setLabel("Date");
                        deathsChart.getYAxis().setLabel("New Deaths");
                        vacChart.getData().addAll(vacData);
                        vacChart.getXAxis().setLabel("Date");
                        vacChart.getYAxis().setLabel("People Vaccinated");
                    }
                }
            }
        });



    }

    public void resize(MouseEvent mouseEvent) {
        Stage stage = (Stage)countryName.getScene().getWindow();
        pane.setPrefWidth(stage.getWidth());
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/ChoseData.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
