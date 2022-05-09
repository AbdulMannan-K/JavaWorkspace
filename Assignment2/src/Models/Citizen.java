package Models;

import DataBases.AD;
import DataBases.CBID;
import DataBases.CCID;
import DataBases.CCND;
import Nodes.DoublyNode;
import Nodes.SinglyNode;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Citizen is the core entity of DataBase
 */
public class Citizen {

    private int CNIC;
    private String name;
    private String fatherName;
    private String gender;
    private String address;
    private String Nationality;
    private boolean isAlien;
    private int current_number_count=0; // for checking the numbers wont exceed 4 numbers

    private DoublyNode<Criminal> criminal;
    private DoublyNode<PhoneUser> networkUser;

    Scanner scan = new Scanner(System.in);

    public Citizen(int CNIC, String name, String fatherName, String gender, String address, String Nationality){
        setCNIC(CNIC);
        setName(name);
        setFatherName(fatherName);
        setGender(gender);
        setAddress(address);
        setNationality(Nationality);
        this.isAlien=false;
    }

    public void addCrime(Crime crime){
        criminal.getData().getCrimes().addNode(crime);
    }

    public void addNumbers(Number number){
        if(current_number_count>=4){
            System.out.println("Numbers registration Limit has reached!");
            return;
        }
        networkUser.getData().getNumbers().addNode(number);
        current_number_count++;
    }

    public void setAlien(boolean alien) {
        if(isAlien){
            System.out.println("Already Alien!");
            return;
        }
        isAlien = alien;
        if(alien) {
            SinglyNode<Number> number = networkUser.getData().getNumbers().getHead();
            while(number!=null){
                number.getData().setDeActivationDate(LocalDate.now().toString());
                number.getData().setActivated("unActive");
                number=number.getNext();
            }
            setNationality("Alien");
            AD.getAliens().addNode(this);
        }

    }

    public void setNationality(String nationality) {
        if(nationality.matches(".*\\d.*")){
            System.out.println("Nationality can not contain Numbers! ");
            System.out.println("Please Enter again : ");
            setNationality(scan.next());
        }else
            Nationality = nationality;
    }

    public void setName(String name) {
        if(name.matches(".*\\d.*")){
            System.out.println("Name can not contain Numbers! ");
            System.out.println("Please Enter again : ");
            setName(scan.next());
        }else
            this.name = name;
    }

    public void setGender(String gender) {
        if(!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f")){
            System.out.println("Gender can't be other than M(m) or F(f)!");
            System.out.println("Please Enter again : ");
            setGender(scan.next());
        }else
            this.gender = gender;
    }

    public void setFatherName(String fatherName) {
        if(fatherName.matches(".*\\d.*")){
            System.out.println("Nationality can not contain Numbers!");
            System.out.println("Please Enter again : ");
            setFatherName(scan.next());
        }else
            this.fatherName = fatherName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCNIC(int CNIC){
        if(CNIC>9999) {
            System.out.println("Limit exceeded can't set above then four digits");
            System.out.println("Enter again : ");
            setCNIC(scan.nextInt());
        }else if(checkCNIC(CNIC))
            setCNIC(CNIC);
        else
            this.CNIC = CNIC;
    }

    public boolean checkCNIC(int CNIC){
        DoublyNode<Citizen> citizen = CBID.getCitizens().getHead();
        while(citizen != null) {
            if(citizen.getData().getCNIC()==CNIC){
                System.out.println("CNIC is already present!");
                System.out.println("Enter Again : ");
                setCNIC(scan.nextInt());
                return true;
            }
            citizen=citizen.getNext();
        }
        return false;
    }

    public void setCriminal() {
        criminal = new DoublyNode<Criminal>(new Criminal(CBID.search(this.CNIC)));
        CCID.getCriminals().addNode(criminal);
    }

    public void setNetworkUser() {
        networkUser = new DoublyNode<PhoneUser>(new PhoneUser(CBID.search(this.CNIC)));
        CCND.getUsers().addNode(networkUser);
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

    public DoublyNode<Criminal> getCriminal() {
        return this.criminal;
    }

    public int getCNIC() {
        return CNIC;
    }

    public DoublyNode<PhoneUser> getNetworkUser() {
        return networkUser;
    }

    public String getAddress() {
        return address;
    }

    public boolean isAlien() {
        return isAlien;
    }
}
