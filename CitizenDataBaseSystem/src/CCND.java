import java.io.FileWriter;
import java.io.IOException;

public class CCND {

    private static CircularLinkedList<NetworkUser> users= new CircularLinkedList<>(); // double list

    public static CircularLinkedList<NetworkUser> getUsers() {
        return users;
    }

    public static void writeUsers(){
        try {
            FileWriter myWriter = new FileWriter("Users.txt");
            DoubleNode<NetworkUser> node = users.getHead();
            do{
                SingleNode<Number> otherNode = node.getData().getNumbers().getHead();
                while(otherNode!=null) {
                    myWriter.write(node.getData().getCitizen().getCNIC() + "," +  otherNode.getData().getNetwork()+ "," +  otherNode.getData().getNumber()+ "," +otherNode.getData().getActivationDate() + "," + otherNode.getData().getDeActivationDate() + "," + otherNode.getData().isActivated() + "\n");
                    otherNode=otherNode.getNext();
                }
                node=node.getNext();
            }while(node!=users.getHead());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static DoubleNode<NetworkUser> search(int CNIC){
        DoubleNode<NetworkUser> temp=users.getHead();
        do{
            if(CNIC == (temp.getData().getCitizen().getCNIC()))
                break;
            temp=temp.getNext();
        }while(temp!=users.getHead());
        return temp;
    }

    public static int cellsOnSameNetwork(String networkToFind){
        DoubleNode<NetworkUser> user = users.getHead();
        int i=0;
        do{
            SingleNode<Number> number = user.getData().getNumbers().getHead();
            while(number!=null){
                String network = number.getData().getNetwork();
                if(network.equalsIgnoreCase(networkToFind))
                    i++;
                number = number.getNext();
            }
            user=user.getNext();
        }while(user!=users.getHead());
        return i;
    }

    public static void swapNumbers(int CNIC_one,String number_one, int CINC_two,String number_two){
        NetworkUser user_one = search(CNIC_one).getData();
        NetworkUser user_two = search(CINC_two).getData();

        SingleNode<Number> number_one_to_change = user_one.getNumbers().getHead();
        boolean notFound = true;
        while (number_one_to_change!=null){
            if(number_one_to_change.getData().getNumber().equals(number_one)) {
                notFound=false;
                break;
            }
            number_one_to_change=number_one_to_change.getNext();
        }
        if(notFound) {
            System.out.println("Number One is wrong !");
            return;
        }
        SingleNode<Number> number_two_to_change = user_two.getNumbers().getHead();
        notFound = true;
        while (number_two_to_change!=null){
            if(number_two_to_change.getData().getNumber().equals(number_two)) {
                notFound=false;
                break;
            }
            number_two_to_change=number_two_to_change.getNext();
        }
        if(notFound) {
            System.out.println("Number Two is wrong !");
            return;
        }

        String temp = number_one_to_change.getData().getNumber();
        String temp1 = number_two_to_change.getData().getNumber();
        number_two_to_change.getData().setNumber("11111111111");
        number_one_to_change.getData().setNumber(temp1);
        number_two_to_change.getData().setNumber(temp);

    }
}
