package DataBases;

import LinkedLists.CircularDoublyList;
import Models.Crime;
import Models.Criminal;
import Nodes.DoublyNode;
import Nodes.SinglyNode;

import java.io.FileWriter;
import java.io.IOException;

/**
 * CCID contains the list of Criminals
 */
public class CCID {

    private static CircularDoublyList<Criminal> criminals = new CircularDoublyList<>();;

    public void setCriminals(CircularDoublyList<Criminal> criminals) {
        CCID.criminals = criminals;
    }

    public static CircularDoublyList<Criminal> getCriminals() {
        return criminals;
    }

    /**
     * writes the data in file CCID.txt
     */
    public static void write(){
        try {
            FileWriter write = new FileWriter("CCID.txt");
            DoublyNode<Criminal> criminal = criminals.getHead();
            do{
                SinglyNode<Crime> crime = criminal.getData().getCrimes().getHead();
                while(crime!=null) {
                    write.write(criminal.getData().getCitizen().getData().getCNIC() + " " +  crime.getData().getDetails()+ " " +crime.getData().getPunishment() + " " + crime.getData().getFine() + "\n");
                    crime=crime.getNext();
                }
                criminal=criminal.getNext();
            }while(criminal!=criminals.getHead());
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * searches the Citizen by a given CNIC
     * @param CNIC is the CNIC of the citizen to find
     * @return the Citizen Node which we were finding or null if nothing is found
     */
    public static DoublyNode<Criminal> search(int CNIC){
        DoublyNode<Criminal> temp=criminals.getHead();
        while(temp!=null){
            if(CNIC == (temp.getData().getCitizen().getData().getCNIC()))
                break;
            temp=temp.getNext();
        }
        return temp;
    }
}
