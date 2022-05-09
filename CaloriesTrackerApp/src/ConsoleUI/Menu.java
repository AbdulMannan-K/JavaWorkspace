package ConsoleUI;

import Controllers.LoginSignup;
import Data.DataHandle;
import Models.Item;
import Models.User;
import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Scanner;

public class Menu {

    public void menu(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Login\n2- Signup\n0- Exit");
        choice = scanner.nextInt();

        switch (choice){
            case 0 -> {
                System.exit(0);
            }
            case 1 -> {
                System.out.print("Enter UserName : ");
                String name = scanner.next();
                System.out.print("Enter Password : ");
                login(name,scanner.next());
            }
            case 2 -> {
                System.out.print("Enter UserName : ");
                String name = scanner.next();
                System.out.print("Enter Password : ");
                signup(name, scanner.next());
            }
        }
    }

    public void trackerMenu(User user){
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Add Items\n2- Check Summary\n0-back");
        choice = scanner.nextInt();
        switch (choice){
            case 0 -> {
                menu();
            }
            case 1 -> {
                System.out.print("Enter Name of Item : ");
                String name = scanner.next();
                System.out.print("Enter fats percentage in it : ");
                double fat = scanner.nextDouble();
                System.out.print("Enter protein percentage in it : ");
                double protein = scanner.nextDouble();
                System.out.print("Enter carbs percentage in it : ");
                double carbs = scanner.nextDouble();
                addItems(user, name,fat,protein,carbs);
            }
            case 2 -> {
                showSummary(user);
            }
        }
    }

    public void showSummary(User user){
        double calori =0;
        double fatp=0,proteinp=0,carbp=0;

        for(Item item : user.getTracker().getItems()){
            calori+=(4*item.getProtein())+(4*item.getCarbs())+(9*item.getFat());
            fatp+=item.getFat();
            proteinp+=item.getProtein();
            carbp+=item.getCarbs();
        }

        System.out.println("Your Total Calories are : " + calori);
        System.out.println("Fat Percentage is : " + calori/fatp);
        System.out.println("Carbs Percentage is : " + calori/carbp);
        System.out.println("protein Percentage is : " + calori/proteinp);

        System.out.println();

        System.out.println("All Items : ");
        System.out.println("Name"+"\t"+"Fats"+"\t"+"Carbs"+"\t"+"Protein");
        for(Item item : user.getTracker().getItems()){
            System.out.println(item.getName()+"|\t"+item.getFat()+"|\t"+item.getCarbs()+"|\t"+item.getProtein());
        }
        trackerMenu(user);
    }

    public void addItems(User user , String name , double fat , double protein , double carbs){
        user.getTracker().getItems().add(new Item(name,fat,carbs,protein));
        trackerMenu(user);
    }

    public void login(String name , String password){
        boolean isPresent = false;
        for(User user : DataHandle.users){
            if(user.getName().equals(name) && user.getPassword().equals(password)){
                isPresent=true;
                trackerMenu(user);
            }else{
                isPresent=false;
            }
        }
        if(!isPresent){
            System.out.println("\nWrong Credentials\n");
            menu();
        }
    }

    public void signup(String name , String password){
        boolean isPresent = false;
        for(User user : DataHandle.users){
            if(user.getName().equals(name)){
                isPresent=true;
                break;
            }
        }
        if(isPresent){
            System.out.println("Name is Already Resgistered!");
            menu();
        }else{
            DataHandle.users.add(new User(name,password));
            menu();
        }
    }

}
