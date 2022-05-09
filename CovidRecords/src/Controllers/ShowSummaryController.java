package Controllers;

import Data.AllRecord;
import Models.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowSummaryController {

    @FXML
    private ComboBox day;
    @FXML
    private ComboBox month;
    @FXML
    private ComboBox year;
    @FXML
    private Label countryName;
    @FXML
    private Label population;
    @FXML
    private Label cases;
    @FXML
    private Label deaths;
    @FXML
    private Label vaccinated;

    ObservableList<String> months = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");
    ObservableList<String> years = FXCollections.observableArrayList();
    ObservableList<String> dayList = FXCollections.observableArrayList();

    public void initialize(){

        countryName.setText("Country : " + AllRecord.record.getCountryName());
        population.setText("Population : " + String.valueOf(AllRecord.record.getPopulation()));

        cases.setText(String.valueOf(AllRecord.record.getNewCases()));
        deaths.setText(String.valueOf(AllRecord.record.getNewDeaths()));
        vaccinated.setText(String.valueOf(AllRecord.record.getPeopleVaccinated()));

        for(Record record : AllRecord.records){
            String dayTest = record.getDate().substring(3,5);
            String yearTest = record.getDate().substring(record.getDate().length()-4);

            if(dayTest.charAt(0)=='/')
                dayTest=String.valueOf(dayTest.charAt(1));
            else if(dayTest.charAt(1)=='/')
                dayTest=String.valueOf(dayTest.charAt(0));

            if(!dayList.contains(dayTest))
                dayList.add(dayTest);
            if(!years.contains(yearTest))
                years.add(yearTest);
        }

        this.day.setItems(dayList);
        month.setItems(months);
        year.setItems(years);


    }

    public void show(ActionEvent actionEvent) {
        String date = month.getValue()+"/"+day.getValue()+"/"+year.getValue();
        for(Record record1 : AllRecord.records){
            if(record1.getDate().equals(date) && record1.getCountryName().equals(AllRecord.record.getCountryName()))
                AllRecord.record=record1;
        }
        try {
            System.out.println(AllRecord.record.getDate());
        }catch (NullPointerException e){
            System.out.println("Summary of this Day is not availabe");
        }

        cases.setText(String.valueOf(AllRecord.record.getNewCases()));
        deaths.setText(String.valueOf(AllRecord.record.getNewDeaths()));
        vaccinated.setText(String.valueOf(AllRecord.record.getPeopleVaccinated()));
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/ChoseData.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
