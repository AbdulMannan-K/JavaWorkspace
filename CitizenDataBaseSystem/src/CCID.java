import java.io.FileWriter;
import java.io.IOException;

public class CCID {

    private static CircularLinkedList<Criminal> criminals = new CircularLinkedList<>();;

    public void setCriminals(CircularLinkedList<Criminal> criminals) {
        CCID.criminals = criminals;
    }

    public static CircularLinkedList<Criminal> getCriminals() {
        return criminals;
    }

    public static void writeCriminal(){
        try {
            FileWriter myWriter = new FileWriter("Criminals.txt");
            DoubleNode<Criminal> node = criminals.getHead();
            do{
                SingleNode<Crime> otherNode = node.getData().getCrimes().getHead();
                while(otherNode!=null) {
                    myWriter.write(node.getData().getCitizen().getCNIC() + "," +  otherNode.getData().getDetails()+ "," +otherNode.getData().getPunishment() + "," + otherNode.getData().getCharges() + "," + otherNode.getData().getFine() + "\n");
                    otherNode=otherNode.getNext();
                }
                node=node.getNext();
            }while(node!=criminals.getHead());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static DoubleNode<Criminal> search(int CNIC){
        DoubleNode<Criminal> temp=criminals.getHead();
        while(temp!=null){
            if(CNIC == (temp.getData().getCitizen().getCNIC()))
                break;
            temp=temp.getNext();
        }
        return temp;
    }
}
