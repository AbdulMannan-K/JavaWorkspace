package DataBases;

import LinkedLists.SinglyList;
import Models.Citizen;
import Nodes.SinglyNode;

import java.io.FileWriter;
import java.io.IOException;

/**
 * AD stands for Alien Database
 * Class contains Single Linked list of Citizens whose nationality has been declared alien
 */
public class AD {

    private static SinglyList<Citizen> aliens = new SinglyList<>();


    public static SinglyList<Citizen> getAliens() {
        return aliens;
    }

    /**
     * Prints the Name of Whole Linked List
     */
    public static void printAliens(){
        SinglyNode<Citizen> singlyNode = aliens.getHead();
        do {
            System.out.println(singlyNode.getData().getName());
            singlyNode = singlyNode.getNext();
        } while (singlyNode != null);
    }

    /**
     * Writes the data in file named AD.txt
     */
    public static void write(){
        try {
            FileWriter myWriter = new FileWriter("AD.txt");
            SinglyNode<Citizen> node = aliens.getHead();
            while(node!=null){
                myWriter.write(node.getData().getCNIC()+" "+node.getData().getName()+" "+node.getData().getFatherName()+" "+node.getData().getGender()+" "+node.getData().getAddress()+" "+node.getData().getNationality()+" "+node.getData().isAlien()+"\n");
                node=node.getNext();
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
