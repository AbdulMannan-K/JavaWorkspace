import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Student[] students = new Student[3];
        students[0] = new Student("Abdul Mannan", "0312487328" , "G-13/4", "i200905@nu.edu.pk" , true);
        students[1] = new Student("Rao Awais" , "3184203858" , "camp" , "i202412@nu.edu.pk" , false);
        students[2] = new Student("Jamal" , "81934798182" , "kashmir" , "i128433@nu.edu.pk", true);

        Faculty[] faculties = new Faculty[3];
        faculties[0] = new Faculty("Abdul" , "3249824", "G32" , "i2320@nu.edu.pk" , 7238 , "3-7-2021" , 25 , "Manager");
        faculties[1] = new Faculty("mannan" , "093274", "324" , "i2320@edu.pk" , 8000 , "3-2-2021" , 11 , "sales person");
        faculties[2] = new Faculty("Abdsul" , "2308434", "G12" , "i2320@nu.pk" , 12000 , "3-1-2021" , 2 , "Manager");

        Staff[] staff = new Staff[3];
        staff[0] = new Staff("Abdul Mannan" , "3248932" , "G-12" , "i2308@nu.edu.pk" , 12033 , "4-8-2019", "Special");
        staff[1] = new Staff("Abdul kamal" , "0310512322" , "G013" , "abdulmannan@gmail.com" , 30000 , "4-8-2018", "Employee of the Year");
        staff[2] = new Staff("MoulaJutt" , "91084209" , "G-14" , "i2308@edu.edu.pk" , 50000 , "4-1-2019", "Kamal");

        while(true){
            boolean notHere=false;
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter : \n1- Student\n2- Faculty\n3- Staff\n0- End");
            int choice = Integer.parseInt(scan.nextLine());
            if(choice == 0)
                break;
            System.out.print("Enter name : ");
            String name = scan.nextLine();
            switch (choice) {
                case 1 -> {
                    for (int i = 0; i < 3; i++) {
                        notHere=false;
                        if (students[i].getName().equals(name)){
                            System.out.println(students[i].getName() + "  " + students[i].getAdress() + "  " + students[i].getEmail() + "  " + students[i].getPhoneNumber() + "  " + students[i].isRegistered());
                            break;
                        }
                        else
                            notHere=true;
                    }
                    if(notHere)
                        System.out.println("Not present");
                }
                case 2 -> {
                    for (int i = 0; i < 3; i++) {
                        notHere=false;
                        if (faculties[i].getName().equals(name)){
                            System.out.println(faculties[i].getName() + "  " + faculties[i].getAdress() + "  " + faculties[i].getEmail() + "  " + faculties[i].getPhoneNumber() + "  " + faculties[i].getRank() + "  " + faculties[i].getOfficeHours());
                            break;
                        }
                        else
                            notHere=true;
                    }
                    if(notHere)
                        System.out.println("Not present");
                }
                case 3 -> {
                    for (int i = 0; i < 3; i++) {
                        notHere=false;
                        if (staff[i].getName().equals(name)){
                            System.out.println(staff[i].getName() + "  " + staff[i].getAdress() + "  " + staff[i].getEmail() + "  " + staff[i].getPhoneNumber() + "  " + staff[i].getTitle());
                            break;
                        }
                        else
                            notHere=true;
                    }
                    if(notHere)
                        System.out.println("Not present");
                }
            }

        }


    }

}
