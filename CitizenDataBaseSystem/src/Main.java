import java.io.*;

public class Main {

    public static void main(String[] args) {

        Main.readData();

        // Task 1
        System.out.println("--- Task 1 ---");
        Citizen citizen = CBID.search(2).getData();
        System.out.println(citizen.getName()+" "+citizen.getFatherName()+" "+citizen.getAddress()+" "+citizen.getNationality()+" "+citizen.getGender());
        SingleNode<Crime> crimes = citizen.getCriminal().getCrimes().getHead();
        while(crimes!=null){
            System.out.println(crimes.getData().getDetails()+" " +crimes.getData().getPunishment()+" " + crimes.getData().getFine());
            crimes=crimes.getNext();
        }
        SingleNode<Number> numbers = citizen.getNetworkUser().getNumbers().getHead();
        while(numbers!=null){
            System.out.println(numbers.getData().getNetwork()+" " +numbers.getData().getActivationDate()+" " + numbers.getData().getDeActivationDate());
            numbers=numbers.getNext();
        }
        System.out.println();

        //Task 2
        System.out.println("--- Task 2 ---");
        Criminal criminal = CCID.search(1).getData();
        System.out.println(criminal.getCitizen().getName()+" "+criminal.getCitizen().getFatherName()+" "+criminal.getCitizen().getAddress()+" "+criminal.getCitizen().getNationality()+" "+criminal.getCitizen().getGender());
         crimes = criminal.getCrimes().getHead();
        while(crimes!=null){
            System.out.println(crimes.getData().getDetails()+" " +crimes.getData().getPunishment()+" " + crimes.getData().getFine());
            crimes=crimes.getNext();
        }
        numbers = criminal.getCitizen().getNetworkUser().getNumbers().getHead();
        while(numbers!=null){
            System.out.println(numbers.getData().getNetwork()+" " + numbers.getData().getNumber()+" " +numbers.getData().getActivationDate()+" " + numbers.getData().getDeActivationDate());
            numbers=numbers.getNext();
        }
        System.out.println();

        //Task 3
        System.out.println("--- Task 3 ---");
        citizen = CBID.search(1).getData();
        citizen.setName("HellWorld");
        System.out.println(citizen.getName()+" "+citizen.getFatherName()+" "+citizen.getAddress()+" "+citizen.getNationality()+" "+citizen.getGender());
        System.out.println();

        //Task 4
        System.out.println("--- Task 4 ---");
        citizen.getNetworkUser().getNumbers().addNode(new Number("Moblink","03425501602"));
        numbers=  citizen.getNetworkUser().getNumbers().getHead();
        while(numbers!=null) {
            System.out.println(numbers.getData().getNetwork() + " " + numbers.getData().getActivationDate() + " " + numbers.getData().getDeActivationDate());
            numbers = numbers.getNext();
        }
        System.out.println();

        //Task 5
        System.out.println("--- Task 5 ---");
        NetworkUser user = CCND.search(2).getData();
        System.out.println(user.getCitizen().getName());
        System.out.println();

        //Task 6
        System.out.println("--- Task 6 ---");
        CCND.swapNumbers(1,"03335263131",2,"91803290203");

        System.out.println();

        //Task 7
        System.out.println("--- Task 7 ---");
        System.out.println(CCND.cellsOnSameNetwork("Moblink"));
        System.out.println();

        //Task 8
        System.out.println("--- Task 8 ---");
        citizen.setAlien(true);
        AD.printAliens();
        System.out.println();

        CBID.writeCitizen();
        CCID.writeCriminal();
        CCND.writeUsers();
        AD.writeAline();
    }

    public static void readData(){
        try {
            FileReader file = new FileReader("Citizens.txt");
            BufferedReader reader = new BufferedReader(file);
            String line;
            while((line=reader.readLine())!=null) {
                String[] parts = line.split(",");
                Citizen citizen = new Citizen(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3],parts[4],parts[5],Boolean.parseBoolean(parts[6]));
                CBID.getCitizens().insertAtEnd(citizen);
            }
            file = new FileReader("Criminals.txt");
            reader = new BufferedReader(file);
            while((line=reader.readLine())!=null) {
                String[] parts = line.split(",");
                int CNIC = Integer.parseInt(parts[0]);
                Citizen citizen = CBID.search(CNIC).getData();
                DoubleNode<Criminal> user1 = CCID.getCriminals().getHead();
                boolean alreadyHere=false;
                do{
                    if(user1 != null) {
                        if (user1.getData().getCitizen().equals(citizen)) {
                            alreadyHere = true;
                            break;
                        }
                        user1 = user1.getNext();
                    }
                }while(user1!=CCID.getCriminals().getHead());
                if(alreadyHere)
                    continue;
                Criminal criminal = new Criminal(citizen);
                citizen.setCriminal(criminal);
                FileReader file1 = new FileReader("Criminals.txt");
                BufferedReader reader1 = new BufferedReader(file1);
                String line1;
                while((line1=reader1.readLine())!=null){
                    String[] parts1 = line1.split(",");
                    int CNIC1 = Integer.parseInt(parts1[0]);
                    if(CNIC==CNIC1)
                        criminal.getCrimes().addNode(new Crime(parts1[1], parts1[2], parts1[3], Integer.parseInt(parts1[4])));
                }
            }
            file = new FileReader("Users.txt");
            reader = new BufferedReader(file);
            while((line=reader.readLine())!=null) {
                String[] parts = line.split(",");
                int CNIC = Integer.parseInt(parts[0]);
                Citizen citizen = CBID.search(CNIC).getData();
                DoubleNode<NetworkUser> user1 = CCND.getUsers().getHead();
                boolean alreadyHere=false;
                do{
                    if(user1 != null) {
                        if (user1.getData().getCitizen().equals(citizen)) {
                            alreadyHere = true;
                            break;
                        }
                        user1 = user1.getNext();
                    }
                }while(user1!=CCND.getUsers().getHead());
                if(alreadyHere)
                    continue;
                NetworkUser user = new NetworkUser(citizen);
                citizen.setNetworkUser(user);
                FileReader file1 = new FileReader("Users.txt");
                BufferedReader reader1 = new BufferedReader(file1);
                String line1;
                while((line1=reader1.readLine())!=null){
                    String[] parts1 = line1.split(",");
                    int CNIC1 = Integer.parseInt(parts1[0]);
                    if(CNIC==CNIC1)
                        user.getNumbers().addNode(new Number(parts1[1], parts1[2], parts1[3], parts1[4],Boolean.parseBoolean(parts1[5])));
                }
            }
            file = new FileReader("Aliens.txt");
            reader = new BufferedReader(file);
            while((line=reader.readLine())!=null) {
                String[] parts = line.split(",");
                Citizen citizen = new Citizen(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3],parts[4],parts[5],Boolean.parseBoolean(parts[6]));
                AD.getAliens().addNode(citizen);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
