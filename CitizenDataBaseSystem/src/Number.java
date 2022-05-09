import java.time.LocalDate;
import java.util.Scanner;

public class Number {

    private String number;
    private String network;
    private String activationDate;
    private String deActivationDate;
    private boolean activated;

    Scanner scan = new Scanner(System.in);

    public Number(String network,String number ) {
        setNetwork(network);
        setNumber(number);
        setActivationDate(LocalDate.now().toString());
        this.activated=true;
    }

    public Number(String network,String number, String activationDate, String deActivationDate, Boolean activated) {
        setNetwork(network);
        setNumber(number);
        setActivationDate(activationDate);
        setDeActivationDate(deActivationDate);
        this.activated=activated;
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

    public void setActivated(boolean status) {
        if(!status)
            deActivationDate = LocalDate.now().toString();
        this.activated = status;
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

    public boolean isActivated() {
        return activated;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (!number.matches("^\\d{11}$")) {
            System.out.println("Number not in correct Format. Please check file!");
            return;
        }
        DoubleNode<NetworkUser> user = CCND.getUsers().getHead();
        do {
            SingleNode<Number> temp = user.getData().getNumbers().getHead();
            while (temp != null) {
                if (temp.getData().getNumber().equals(number)) {
                    System.out.println("Number already exists!");
                    showAllNumbers();
                    System.out.println("Enter Number again : ");
                    this.number = scan.next();
                    if (!number.matches("^\\d{11}$"))
                        System.out.println("Number not in correct Format. Please check file!");
                    return;
                }
                temp = temp.getNext();
            }
            user = user.getNext();
        } while (user != CCND.getUsers().getHead());
        this.number = number;
    }

    public void showAllNumbers(){
        DoubleNode<NetworkUser> user = CCND.getUsers().getHead();
        do{
            SingleNode<Number> temp = user.getData().getNumbers().getHead();
            while(temp!=null){
                System.out.println(temp.getData().getNumber());
                temp=temp.getNext();
            }
            user=user.getNext();
        }while(user != CCND.getUsers().getHead());
    }
}