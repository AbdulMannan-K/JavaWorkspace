import DataBases.AD;
import DataBases.CBID;
import DataBases.CCID;
import DataBases.CCND;
import Models.*;
import Models.PhoneUser;
import Models.Number;
import Nodes.DoublyNode;
import Nodes.SinglyNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        read();
        CBID.sortByCNIC();

        // A menu and a switch case that do whatever is in list at that number
        System.out.println("Enter What you want to do : ");
        System.out.println("1- Search by CNIC in CBID");
        System.out.println("2- Search by CNIC in CCID");
        System.out.println("3- Search by CNIC in CCND");
        System.out.println("4- Update Record in CBID");
        System.out.println("5- Make someone a Alien");
        System.out.println("6- Add a Crime to crimeList");
        System.out.println("7- Delete Crime from CrimeList");
        System.out.println("8- Update Crimes on CrimeList");
        System.out.println("9- Add Cell Number of a specified CNIC");
        System.out.println("10- Swap ownership of numbers");
        System.out.println("11- Show Cell Numbers registered on each Network");
        System.out.println("12- Show Alien DataBase List");
        System.out.println("0- Enter zero to exit");
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter What you want to do : ");
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter CNIC : ");
                    Citizen citizen = CBID.search(scan.nextInt()).getData();
                    System.out.println(citizen.getName() + " " + citizen.getFatherName() + " " + citizen.getAddress() + " " + citizen.getNationality() + " " + citizen.getGender());
                    System.out.println();
                    SinglyNode<Crime> crimes = citizen.getCriminal().getData().getCrimes().getHead();
                    while (crimes != null) {
                        System.out.println(crimes.getData().getDetails() + " " + crimes.getData().getPunishment() + " " + crimes.getData().getFine());
                        crimes = crimes.getNext();
                    }
                    System.out.println();
                    SinglyNode<Number> numbers = citizen.getNetworkUser().getData().getNumbers().getHead();
                    while (numbers != null) {
                        System.out.println(numbers.getData().getNetwork() + " " + numbers.getData().getActivationDate() + " " + numbers.getData().getDeActivationDate());
                        numbers = numbers.getNext();
                    }
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Enter CNIC : ");
                    Criminal criminal = CCID.search(scan.nextInt()).getData();
                    System.out.println(criminal.getCitizen().getData().getName() + " " + criminal.getCitizen().getData().getFatherName() + " " + criminal.getCitizen().getData().getAddress() + " " + criminal.getCitizen().getData().getNationality() + " " + criminal.getCitizen().getData().getGender());
                    SinglyNode<Crime> crimes = criminal.getCrimes().getHead();
                    while (crimes != null) {
                        System.out.println(crimes.getData().getDetails() + " " + crimes.getData().getPunishment() + " " + crimes.getData().getFine());
                        crimes = crimes.getNext();
                    }
                    SinglyNode<Number> numbers = criminal.getCitizen().getData().getNetworkUser().getData().getNumbers().getHead();
                    while (numbers != null) {
                        System.out.println(numbers.getData().getNetwork() + " " + numbers.getData().getNumber() + " " + numbers.getData().getActivationDate() + " " + numbers.getData().getDeActivationDate());
                        numbers = numbers.getNext();
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Enter CNIC : ");
                    PhoneUser user = CCND.searchData(scan.nextInt()).getData();
                    System.out.println(user.getCitizen().getData().getName() + " " + user.getCitizen().getData().getFatherName() + " " + user.getCitizen().getData().getAddress() + " " + user.getCitizen().getData().getNationality() + " " + user.getCitizen().getData().getGender());
                    SinglyNode<Crime> crimes = user.getCitizen().getData().getCriminal().getData().getCrimes().getHead();
                    while (crimes != null) {
                        System.out.println(crimes.getData().getDetails() + " " + crimes.getData().getPunishment() + " " + crimes.getData().getFine());
                        crimes = crimes.getNext();
                    }
                    SinglyNode<Number> numbers = user.getNumbers().getHead();
                    while (numbers != null) {
                        System.out.println(numbers.getData().getNetwork() + " " + numbers.getData().getNumber() + " " + numbers.getData().getActivationDate() + " " + numbers.getData().getDeActivationDate());
                        numbers = numbers.getNext();
                    }
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Enter CNIC : ");
                    Citizen citizen = CBID.search(scan.nextInt()).getData();
                    System.out.println("Enter new Name : ");
                    citizen.setName(scan.next());
                    System.out.println(citizen.getName() + " " + citizen.getFatherName() + " " + citizen.getAddress() + " " + citizen.getNationality() + " " + citizen.getGender());
                    System.out.println();
                }
                case 5 -> {
                    System.out.println("Enter CNIC : ");
                    Citizen citizen = CBID.search(scan.nextInt()).getData();
                    citizen.setAlien(true);
                }
                case 6 -> {
                    System.out.println("Enter CNIC of criminal : ");
                    Citizen citizen = CBID.search(scan.nextInt()).getData();
                    System.out.println("Enter Crime detail : (Without Spacing)");
                    String crime = scan.next();
                    System.out.println("Enter Crime Punishment :(Without Spacing)");
                    String punishment = scan.next();
                    System.out.println("Enter Fine : ");
                    int fine = scan.nextInt();
                    Crime crimeToAdd = new Crime(crime, punishment, fine);
//                    citizen.getCriminal().getData().getCrimes().addNode(crimeToAdd);
                    citizen.addCrime(crimeToAdd);
                }
                case 7 -> {
                    System.out.println("Enter CNIC of criminal : ");
                    Citizen citizen = CBID.search(scan.nextInt()).getData();
                    System.out.println("Enter Crime detail : (Without Spacing)");
                    String c = scan.next();
                    SinglyNode<Crime> crime = citizen.getCriminal().getData().getCrimes().getHead();
                    while (crime != null) {
                        if (crime.getData().getDetails().equals(c))
                            break;
                        crime = crime.getNext();
                    }
                    citizen.getCriminal().getData().getCrimes().deleteAny(crime.getData());
                }
                case 8 -> {
                    System.out.println("Enter CNIC of criminal : ");
                    Citizen citizen = CBID.search(scan.nextInt()).getData();
                    System.out.println("Enter Crime detail : (Without Spacing)");
                    String c = scan.next();
                    SinglyNode<Crime> crime = citizen.getCriminal().getData().getCrimes().getHead();
                    while (crime != null) {
                        if (crime.getData().getDetails().equals(c))
                            break;
                        crime = crime.getNext();
                    }
                    System.out.println("Enter new Details : ");
                    crime.getData().setDetails(scan.next());
                }
                case 9 -> {
                    System.out.println("Enter CNIC of user : ");
                    Citizen citizen = CBID.search(scan.nextInt()).getData();
                    System.out.println("Enter Network : ");
                    String network = scan.next();

                    System.out.println("Enter Number (5 Digit without Space)  : ");
                    String number = scan.next();
                    Number numbertoAdd = new Number(network, number);
                    citizen.getNetworkUser().getData().getNumbers().addNode(numbertoAdd);
                }
                case 10 -> {
                    System.out.println("Enter CNIC of First user :  ");
                    int CNICOne = scan.nextInt();
                    System.out.println("Enter CNIC of Second user :  ");
                    int CNICTwo = scan.nextInt();
                    System.out.println("Enter Number of first user : ");
                    String numberOne = scan.next();
                    System.out.println("Enter Number of second user : ");
                    String numberTwo = scan.next();
                    CCND.swap(CNICOne ,numberOne,CNICTwo, numberTwo);
                }
                case 11 -> {
                    CCND.showNumbersonNetwork();
                }
                case 12 -> {
                    AD.printAliens();
                }
                case 0 -> {
                    CBID.writeCitizen();
                    CCID.write();
                    CCND.write();
                    AD.write();
                    System.exit(0);
                }
            }
        }while(true);
    }

    /**
     * Reads all the data of CBID,cCID,AD,CCND
     */
    public static void read(){
        try {
            FileReader file = new FileReader("CBID.txt");
            BufferedReader reader = new BufferedReader(file);
            String line;
            while((line=reader.readLine())!=null) {
                String[] parts = line.split(" ");
                Citizen citizen = new Citizen(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3],parts[4],parts[5]);
                DoublyNode<Citizen> citizenNode = new DoublyNode<>(citizen);
                CBID.getCitizens().addNode(citizenNode);
                citizenNode.getData().setCriminal();
                citizenNode.getData().setNetworkUser();
            }
            file = new FileReader("CCID.txt");
            reader = new BufferedReader(file);
            while((line=reader.readLine())!=null) {
                String[] parts = line.split(" ");
                int CNIC = Integer.parseInt(parts[0]);
                Citizen citizen = CBID.search(CNIC).getData();
                DoublyNode<Criminal> criminaltemp = CCID.getCriminals().getHead();
                boolean alreadyHere=false;
                do {
                    if (criminaltemp != null){
                        if (criminaltemp.getData().getCrimes().size()>0) {
                            alreadyHere = true;
                            break;
                        }
                    criminaltemp = criminaltemp.getNext();
                    }
                }while(criminaltemp!=CCID.getCriminals().getHead());
                if(alreadyHere) {
                    System.out.println("Here");
                    continue;
                }
                FileReader file1 = new FileReader("CCID.txt");
                BufferedReader reader1 = new BufferedReader(file1);
                String line1;
                while((line1=reader1.readLine())!=null){
                    String[] parts1 = line1.split(" ");
                    int CNIC1 = Integer.parseInt(parts1[0]);
                    if(CNIC==CNIC1) {
                        citizen.addCrime(new Crime(parts1[1], parts1[2], Integer.parseInt(parts1[3])));
                    }
                }
            }
            file = new FileReader("CCND.txt");
            reader = new BufferedReader(file);
            while((line=reader.readLine())!=null) {
                String[] parts = line.split(" ");
                int CNIC = Integer.parseInt(parts[0]);
                Citizen citizen = CBID.search(CNIC).getData();
                DoublyNode<PhoneUser> user1 = CCND.getUsers().getHead();
                boolean alreadyHere=false;
                do{
                    if(user1 != null) {
                        if (user1.getData().getNumbers().size()>0) {
                            alreadyHere = true;
                            break;
                        }
                        user1 = user1.getNext();
                    }
                }while(user1!=CCND.getUsers().getHead());
                if(alreadyHere)
                    continue;
                FileReader file1 = new FileReader("CCND.txt");
                BufferedReader reader1 = new BufferedReader(file1);
                String line1;
                while((line1=reader1.readLine())!=null){
                    String[] parts1 = line1.split(" ");
                    int CNIC1 = Integer.parseInt(parts1[0]);
                    if(CNIC==CNIC1)
                        citizen.addNumbers(new Number(parts1[1], parts1[2], parts1[3], parts1[4],parts1[5]));
                }
            }
            file = new FileReader("AD.txt");
            reader = new BufferedReader(file);
            while((line=reader.readLine())!=null) {
                String[] parts = line.split(" ");
                Citizen citizen = new Citizen(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3],parts[4],parts[5]);
                AD.getAliens().addNode(citizen);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
