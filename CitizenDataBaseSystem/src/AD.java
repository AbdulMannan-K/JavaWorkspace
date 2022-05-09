import java.io.FileWriter;
import java.io.IOException;

public class AD {

    private static SingleLinkedList<Citizen> aliens = new SingleLinkedList<>();


    public static SingleLinkedList<Citizen> getAliens() {
        return aliens;
    }

    public static void printAliens(){
        SingleNode<Citizen> singleNode = aliens.getHead();
        do {
            System.out.println(singleNode.getData().getName());
            singleNode = singleNode.getNext();
        } while (singleNode != null);
    }

    public static void writeAline(){
        try {
            FileWriter myWriter = new FileWriter("Aliens.txt");
            SingleNode<Citizen> node = aliens.getHead();
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
