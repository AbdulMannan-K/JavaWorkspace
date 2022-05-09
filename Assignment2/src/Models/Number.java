package Models;

import DataBases.CCND;
import Nodes.DoublyNode;
import Nodes.SinglyNode;

import java.time.LocalDate;
import java.util.Scanner;

public class Number {

    private String number;
    private String network;
    private String activationDate;
    private String deActivationDate;
    private String activated;

    Scanner scan = new Scanner(System.in);

    public Number(String network,String number ) {
        setNetwork(network);
        setNumber(number);
        setActivationDate(LocalDate.now().toString());
        this.activated="active";
    }

    public Number(String number,String network, String activationDate, String deActivationDate, String activated) {
        setNetwork(network);
        setNumber(number);
        setActivationDate(activationDate);
        setDeActivationDate(deActivationDate);
        this.activated="active";
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public void setDeActivationDate(String deActivationDate) {
        this.deActivationDate = deActivationDate;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public void setActivated(String activation) {
        if(!activation.equalsIgnoreCase("unActive")&& !activation.equalsIgnoreCase("active")){
            System.out.println("Wrong Status, Check The File again!");
            return;
        }
        if(activation.equalsIgnoreCase("unActive"))
            deActivationDate = LocalDate.now().toString();
        this.activated = activation;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public String getDeActivationDate() {
        return deActivationDate;
    }

    public String getNetwork() {
        return network;
    }

    public String getactivated() {
        return activated;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (!number.matches("^\\d{5}$")) {
            System.out.println("Number not in correct Format. Please check file!");
            return;
        }
        DoublyNode<PhoneUser> user = CCND.getUsers().getHead();
        boolean firstTime=true;
        do {
            SinglyNode<Number> temp = user.getData().getNumbers().getHead();
            while (temp != null) {
                if (temp.getData().getNumber().equals(number)) {
                    if(!firstTime) {
                        System.out.println("Number already exists!");
                        showEveryNumber();
                        System.out.println("Enter Number again : ");
                        this.number = scan.next();
                        if (!number.matches("^\\d{5}$")) {
                            System.out.println("Number not in correct Format!");
                            System.exit(0);
                        }
                    }
                    firstTime=false;
                }
                temp = temp.getNext();
            }
            user = user.getNext();
        } while (user != CCND.getUsers().getHead());
        this.number = number;
    }

    public void showEveryNumber(){
        DoublyNode<PhoneUser> user = CCND.getUsers().getHead();
        do{
            SinglyNode<Number> temp = user.getData().getNumbers().getHead();
            while(temp!=null){
                System.out.println(temp.getData().getNumber());
                temp=temp.getNext();
            }
            user=user.getNext();
        }while(user != CCND.getUsers().getHead());
    }
}