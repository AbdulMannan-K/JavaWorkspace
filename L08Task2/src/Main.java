import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int choice;
        Emplyee[] emplyee;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter which employee type : \n1- Salaried\n2- Commission");
            choice = scan.nextInt();
        }while (choice!=2 && choice!=1);
        
        switch (choice){
            case 1 -> {
                emplyee = new SalariedEmployee[10];
                emplyee[0] = new SalariedEmployee("Abdul", "Mannan" , "611-1232423" , 29);
                emplyee[1] = new SalariedEmployee();
                emplyee[2] = new SalariedEmployee(20);
                //  all 10 can be initialized
            }
            case 2 -> {
                emplyee = new CommisionEmployee[10];
                emplyee[0] = new CommisionEmployee("Abdul" , "Mannan" , "61001023-342" , 23 , 123.2);
                emplyee[1] = new CommisionEmployee();
                emplyee[2] = new CommisionEmployee(12,23);
                // all 10 can be initialized
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        
        System.out.println(emplyee[0].earnings());
        System.out.println(emplyee[1].earnings());
        System.out.println(emplyee[2].earnings());

    }

}
