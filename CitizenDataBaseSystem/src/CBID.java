import java.io.FileWriter;
import java.io.IOException;

public class CBID {

    private static DoubleLinkedList<Citizen> citizens = new DoubleLinkedList<Citizen>(); ;

    public DoubleLinkedList<Citizen> Citizens() {
        return citizens;
    }

    public void setCitizens(DoubleLinkedList<Citizen> citizens) {
        CBID.citizens = citizens;
    }

    public static DoubleLinkedList<Citizen> getCitizens() {
        return citizens;
    }

    public void sortByCNIC(){
        DoubleNode<Citizen> firstNode = citizens.getHead();

        do{
            DoubleNode<Citizen> secondNode = firstNode;
            do{
                if(firstNode.getData().getCNIC()> (secondNode.getData().getCNIC())){
                    Citizen temp = firstNode.getData();
                    firstNode.setData(secondNode.getData());
                    secondNode.setData(temp);
                }
                secondNode=secondNode.getNext();
            }while(secondNode!=citizens.getHead());
            firstNode=firstNode.getNext();
        }while(firstNode!=citizens.getHead());

    }

    public static DoubleNode<Citizen> search(int CNIC){
        DoubleNode<Citizen> temp=citizens.getHead();
        while(temp!=null){
            if(CNIC == (temp.getData().getCNIC()))
                break;
            temp=temp.getNext();
        }
        return temp;
    }

    public static void writeCitizen(){
        try {
            FileWriter myWriter = new FileWriter("Citizens.txt");
            DoubleNode<Citizen> node = citizens.getHead();
            while(node!=null){
                myWriter.write(node.getData().getCNIC()+","+node.getData().getName()+","+node.getData().getFatherName()+","+node.getData().getGender()+","+node.getData().getAddress()+","+node.getData().getNationality()+","+node.getData().isAlien()+"\n");
                node=node.getNext();
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}