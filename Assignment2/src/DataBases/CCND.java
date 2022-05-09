package DataBases;

import LinkedLists.CircularDoublyList;
import Models.PhoneUser;
import Models.Number;
import Nodes.DoublyNode;
import Nodes.SinglyNode;

import java.io.FileWriter;
import java.io.IOException;

public class CCND {

    private static CircularDoublyList<PhoneUser> users= new CircularDoublyList<>(); // double list

    public static CircularDoublyList<PhoneUser> getUsers() {
        return users;
    }

    /**
     * Writes the network user data in file Named CCND.txt
     */
    public static void write(){
        try {
            FileWriter write = new FileWriter("CCND.txt");
            DoublyNode<PhoneUser> user = users.getHead();
            do{
                SinglyNode<Number> number = user.getData().getNumbers().getHead();
                while(number!=null) {
                    write.write(user.getData().getCitizen().getData().getCNIC() + " " +  number.getData().getNumber()+ " " +  number.getData().getNetwork()+ " " +number.getData().getActivationDate() + " " + number.getData().getDeActivationDate() + " " + number.getData().getactivated() + "\n");
                    number=number.getNext();
                }
                user=user.getNext();
            }while(user!=users.getHead());
            write.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * searches the Citizen by a given CNIC
     * @param CNIC is the CNIC of the citizen to find
     * @return the Citizen Node which we were finding or null if nothing is found
     */
    public static DoublyNode<PhoneUser> searchData(int CNIC){
        DoublyNode<PhoneUser> temp=users.getHead();
        do{
            if(CNIC == (temp.getData().getCitizen().getData().getCNIC()))
                break;
            temp=temp.getNext();
        }while(temp!=users.getHead());
        return temp;
    }

    /**
     * shows how many numbers are on each network
     */
    public static void showNumbersonNetwork(){
        SinglyNode<Number> number = users.getHead().getData().getNumbers().getHead();
        while(number != null){
            String network = number.getData().getNetwork();
            SinglyNode<Number> number1 = users.getHead().getData().getNumbers().getHead();
            int numbers=0;
            while(number1 != null){
                if(network.equals(number.getData().getNetwork())) {
                    numbers++;
                }
                number1=number1.getNext();
            }
            System.out.println(network+" has this many numbers : " + numbers);
            number = number.getNext();
        }
    }

    /**
     *
     * @param CNIC1 is CNIC of firstUser
     * @param firstNumber is number to replace of firstUser
     * @param CINC2 is CNIC of second User
     * @param secondNumber is number to replace of secondUSer
     */
    public static void swap(int CNIC1, String firstNumber, int CINC2, String secondNumber){
        PhoneUser firstUser = searchData(CNIC1).getData();
        PhoneUser SecondUser = searchData(CINC2).getData();

        SinglyNode<Number> number1 = firstUser.getNumbers().getHead();
        boolean notFound = true;
        while (number1!=null){
            if(number1.getData().getNumber().equals(firstNumber)) {
                notFound=false;
                break;
            }
            number1=number1.getNext();
        }
        if(notFound) {
            System.out.println("First Number sent is not found on records");
            return;
        }
        SinglyNode<Number> number2 = SecondUser.getNumbers().getHead();
        notFound = true;
        while (number2!=null){
            if(number2.getData().getNumber().equals(secondNumber)) {
                notFound=false;
                break;
            }
            number2=number2.getNext();
        }
        if(notFound) {
            System.out.println("Second Number sent is not found on records");
            return;
        }

        String temp = number1.getData().getNumber();
        String temp1 = number2.getData().getNumber();
        number2.getData().setNumber("32344");
        number1.getData().setNumber(temp1);
        number2.getData().setNumber(temp);

    }
}
