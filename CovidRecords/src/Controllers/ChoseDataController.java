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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ChoseDataController {

    @FXML
    private ComboBox reign;
    @FXML
    private ComboBox range;
    @FXML
    private GridPane numOfDays;
    @FXML
    private GridPane numOfGroups;
    @FXML
    private GridPane datePick;
    @FXML
    private ComboBox month;
    @FXML
    private ComboBox day;
    @FXML
    private ComboBox year;
    @FXML
    private TextField days;
    @FXML
    private TextField groups;



    ObservableList<String> reignList = FXCollections
            .observableArrayList();
    ObservableList<String> rangeList = FXCollections
            .observableArrayList("No Range","Number of Groups","Number of Days");
    ObservableList<String> months = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");
    ObservableList<String> years = FXCollections.observableArrayList();
    ObservableList<String> dayList = FXCollections.observableArrayList();

    public void initialize(){

        numOfDays.setVisible(false);
        numOfGroups.setVisible(false);
        datePick.setVisible(false);

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

        for(Record record : AllRecord.records){
            if(reignList.contains(record.getCountryName()))
                continue;
            else
                reignList.add(record.getCountryName());
        }

        reign.setItems(reignList);
        range.setItems(rangeList);
        this.day.setItems(dayList);
        month.setItems(months);
        year.setItems(years);


        range.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                if(t1.equals("No Range")){
                    datePick.setVisible(true);
                    numOfDays.setVisible(false);
                    numOfGroups.setVisible(false);
                }
                else if(t1.equals("Number of Groups")){
                    numOfGroups.setVisible(true);
                    numOfDays.setVisible(false);
                    datePick.setVisible(false);
                }
                else{
                    numOfDays.setVisible(true);
                    numOfGroups.setVisible(false);
                    datePick.setVisible(false);
                }
            }
        });

    }


    public void sendInfo(ActionEvent actionEvent) throws IOException {

        AllRecord.Allgroups.removeAll(AllRecord.Allgroups);

        if(range.getValue().equals("No Range")){
            String date = month.getValue()+"/"+day.getValue()+"/"+year.getValue();
            for(Record record1 : AllRecord.records){
                if(record1.getDate().equals(date) && record1.getCountryName().equals(reign.getValue()))
                    AllRecord.record=record1;
            }
            try {
                System.out.println(AllRecord.record.getDate());
            }catch (NullPointerException e){
                System.out.println("Summary of this Day is not availabe");
            }

            Parent root = FXMLLoader.load(getClass().getResource("/Interface/ShowSummary.fxml"));
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else if(range.getValue().equals("Number of Groups")){
            int num = Integer.parseInt(groups.getText());
            int numOfDays=0;
            String country = reign.getValue().toString();
            ArrayList<Record>  testRecords = new ArrayList<>();
            for(Record record : AllRecord.records){
                if(record.getCountryName().equals(country)){
                    numOfDays++;
                    testRecords.add(record);
                }
            }
            System.out.println(numOfDays);

            for(int i=0 ; i < num ; i++)
                AllRecord.Allgroups.add(i,new Group());

            System.out.println(AllRecord.Allgroups.size());

            double limit = (double)numOfDays/num;
            for(int i=0 ; i < numOfDays ;){
                for(int j=0 ; j < num ;){

                    if(i==Math.round(limit)){
                        if(j!=AllRecord.Allgroups.size()-1)
                            j++;
                        limit+=Math.round((double)numOfDays/num);
                    }

                    if(i < numOfDays && i >= 0)
                        AllRecord.Allgroups.get(j).getGroups().add(testRecords.get(i));

                    i++;
                    if(i==numOfDays)
                        break;
                }
            }

//            int a=1;
//            for(Group group : AllRecord.Allgroups){
//                for(Record record : group.getGroups()){
//                    System.out.println(record.getCountryName()+ " " + record.getDate() + " " + a);
//                    a++;
//                }
//                System.out.println();
//                System.out.println(group.getGroups().size());
//                System.out.println();
//            }

            Parent root = FXMLLoader.load(getClass().getResource("/Interface/ShowSummaryGroups.fxml"));
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();

        }
        else{
            int num = Integer.parseInt(days.getText());
            int numOfDays=0;
            String country = reign.getValue().toString();
            ArrayList<Record>  testRecords = new ArrayList<>();
            for(Record record : AllRecord.records){
                if(record.getCountryName().equals(country)){
                    numOfDays++;
                    testRecords.add(record);
                }
            }
            System.out.println(numOfDays);

            if(num%5!=0){
                Alert alert = new Alert(Alert.AlertType.WARNING,"The number of Days isn't multiple of 5");
                alert.show();
            }
            else if(numOfDays%num == 0){
                for(int i=0 ; i < numOfDays/num ; i++)
                    AllRecord.Allgroups.add(i,new Group());

                System.out.println(AllRecord.Allgroups.size());

                double limit = num;
                for(int i=0 ; i < numOfDays ;){
                    for(int j=0 ; j < AllRecord.Allgroups.size() ;){

                        if(i==limit){
                            System.out.println("Limit Reacher");
                            j++;
                            limit+=num;
                        }

                        if(i < numOfDays && i >= 0)
                            AllRecord.Allgroups.get(j).getGroups().add(testRecords.get(i));

                        System.out.println(i);
                        i++;
                    }
                }

                Parent root = FXMLLoader.load(getClass().getResource("/Interface/ShowSummaryDays.fxml"));
                Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setX(440);
                stage.setY(150);
                stage.show();
//                int a=1;
//            for(Group group : AllRecord.Allgroups){
//                for(Record record : group.getGroups()){
//                    System.out.println(record.getCountryName()+ " " + record.getDate() + " " + a);
//                    a++;
//                }
//                System.out.println();
//                System.out.println(group.getGroups().size());
//                System.out.println();
//            }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING,"The groups can't be devided equally!");
                alert.show();
            }

        }



    }
}
