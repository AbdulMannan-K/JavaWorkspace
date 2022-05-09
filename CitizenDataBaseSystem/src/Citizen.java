
import java.time.LocalDate;
import java.util.Scanner;

public class Citizen {

    private int CNIC;
    private static int CNIC_count=1;
    private String name;
    private String fatherName;
    private String gender;
    private String address;
    private String Nationality;
    private boolean isAlien;

    private Criminal criminal;
    private NetworkUser networkUser;

    Scanner scan = new Scanner(System.in);

    public Citizen(String name, String fatherName, String gender, String address, String Nationality,boolean isAlien){
        setCNIC();
        setName(name);
        setFatherName(fatherName);
        setGender(gender);
        setAddress(address);
        setNationality(Nationality);
        setAlien(isAlien);
        criminal = null;
        networkUser = null;
    }

    public Citizen(int CNIC, String name, String fatherName, String gender, String address, String Nationality,boolean isAlien){
        this.CNIC=CNIC;
        setName(name);
        setFatherName(fatherName);
        setGender(gender);
        setAddress(address);
        setNationality(Nationality);
        this.isAlien=isAlien;
        criminal = null;
        networkUser = null;
    }

    public void setAlien(boolean alien) {
        isAlien = alien;
        if(alien) {
            if(networkUser!=null){
                SingleNode<Number> node = networkUser.getNumbers().getHead();
                while(node!=null){
                    node.getData().setDeActivationDate(LocalDate.now().toString());
                    node.getData().setActivated(false);
                    node=node.getNext();
                }
            }
            setNationality("Alien");
            SingleNode<Citizen> node = AD.getAliens().getHead();
            while(node!=null){
                if(node.getData().getCNIC()==getCNIC()){
                    System.out.println("Already declared Alien");
                    return;
                }
                node=node.getNext();
            }
            AD.getAliens().addNode(this);
        }

    }

    public void setNationality(String nationality) {
        if(nationality.matches(".*\\d.*")){
            System.out.println("Nationality can not contain Digit! \nPlease Fix the File ");
            return;
        }
        Nationality = nationality;
    }

    public void setName(String name) {
        if(name.matches(".*\\d.*")){
            System.out.println("Name can not contain Digit! \nPlease Fix the File ");
            return;
        }
        this.name = name;
    }

    public void setGender(String gender) {
        if(!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("FeMale")){
            System.out.println("Gender can't be other than Male or Female! \nPlease Fix the File ");
            return;
        }
        this.gender = gender;
    }

    public void setFatherName(String fatherName) {
        if(fatherName.matches(".*\\d.*")){
            System.out.println("Nationality can not contain Digit! \nPlease Fix the File ");
            return;
        }
        this.fatherName = fatherName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCNIC(){
        if(CNIC_count>9999) {
            System.out.println("Limit exceeded can't set above then four digits");
            return;
        }
        this.CNIC = CNIC_count++;
    }

    public void setCriminal(Criminal criminal) {
        this.criminal = criminal;
        CCID.getCriminals().insertAtEnd(criminal);
    }

    public void setNetworkUser(NetworkUser networkUser) {
        this.networkUser = networkUser;
        CCND.getUsers().insertAtEnd(networkUser);
    }

    public String getNationality() {
        return Nationality;
    }

    public String getGender() {
        return gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getName() {
        return name;
    }

    public Criminal getCriminal() {
        return this.criminal;
    }

    public int getCNIC() {
        return CNIC;
    }

    public NetworkUser getNetworkUser() {
        return networkUser;
    }

    public String getAddress() {
        return address;
    }

    public boolean isAlien() {
        return isAlien;
    }
}
