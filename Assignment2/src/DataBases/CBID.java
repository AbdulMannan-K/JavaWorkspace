package DataBases;

import LinkedLists.DoublyList;
import Models.Citizen;
import Nodes.DoublyNode;

import java.io.FileWriter;
import java.io.IOException;

/**
 * CBID contains the list of Citizens
 */
public class CBID {

    private static DoublyList<Citizen> citizens = new DoublyList<Citizen>(); ;

    public DoublyList<Citizen> Citizens() {
        return citizens;
    }

    public void setCitizens(DoublyList<Citizen> citizens) {
        CBID.citizens = citizens;
    }

    public static DoublyList<Citizen> getCitizens() {
        return citizens;
    }

    /**
     * sorts the CNIC in ascending order
     */
    public static void sortByCNIC(){
        DoublyNode<Citizen> firstNode = citizens.getHead();

        while(firstNode!=null){
            DoublyNode<Citizen> secondNode = citizens.getHead();
            while(secondNode!=null){
                if(firstNode.getData().getCNIC()> (secondNode.getData().getCNIC())){
                    Citizen temp = firstNode.getData();
                    firstNode.setData(secondNode.getData());
                    secondNode.setData(temp);
                }
                secondNode=secondNode.getNext();
            }
            firstNode=firstNode.getNext();
        }

    }

    /**
     * searches the Citizen by a given CNIC
     * @param CNIC is the CNIC of the citizen to find
     * @return the Citizen Node which we were finding or null if nothing is found
     */
    public static DoublyNode<Citizen> search(int CNIC){
        DoublyNode<Citizen> temp=citizens.getHead();
        while(temp!=null){
            if(CNIC == (temp.getData().getCNIC())) {
                break;
            }
            temp=temp.getNext();
        }
        return temp;
    }

    /**
     * writes the data in file CBID.txt
     */
    public static void writeCitizen(){
        try {
            FileWriter write = new FileWriter("CBID.txt");
            DoublyNode<Citizen> node = citizens.getHead();
            while(node!=null){
                write.write(node.getData().getCNIC()+" "+node.getData().getName()+" "+node.getData().getFatherName()+" "+node.getData().getGender()+" "+node.getData().getAddress()+" "+node.getData().getNationality()+" "+node.getData().isAlien()+"\n");
                node=node.getNext();
            }
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}