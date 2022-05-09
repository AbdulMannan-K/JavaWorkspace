import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    ArrayList<Student> student = new ArrayList<Student>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        main.student.add(new Student("P16-6068","Hamza Jamil",2.28,8));
        main.student.add(new Student("I17-0056","Ali Musa",3.34,7));
        main.student.add(new Student("I19-2001","Irtaza Hassan",3.7,3));
        main.student.add(new Student("I21-2003","Hamza Sher",3.6,1));
        main.student.add(new Student("I18- 0045","Saima Iftekhar",3.33,5));
        main.student.add(new Student("I18-0067","Babar Jamil",2.45,5));
        main.student.add(new Student("P16-6069","Alfanso Junior",3.31,8));
        main.student.add(new Student("I17-0456","Hamza Jamil",3.33,7));
        int option;

        do {
            System.out.println("\nEnter what you want to do : \n1- Print the students name and roll no that have CGPA >= 3.31\n2- Calculate the average CGPA.");
            System.out.println("3- Print all the student that have number of semesters >= 4\n4- Reverse the collection\n5- Shuffle the collection\n6- Remove the students by rollNo.");
            System.out.println("7- Check if the input name exist in arraylist\n0- Exit");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> main.print_3();
                case 2 -> System.out.println("Average is : " + main.calculate_avg());
                case 3 -> main.printAll();
                case 4 -> {
                    System.out.println("Before Reverse : ");
                    for(Student i : main.student)
                        System.out.print(i.getName()+ "  ");
                    System.out.println();
                    Collections.reverse(main.student);
                    System.out.println("\nAfter Reverse : ");
                    for(Student i : main.student)
                        System.out.print(i.getName()+ "  ");
                    System.out.println();
                }
                case 5 -> {
                    System.out.println("Before Shuffle : ");
                    for(Student i : main.student)
                        System.out.print(i.getName()+ "  ");
                    System.out.println();
                    Collections.shuffle(main.student);
                    System.out.println("After Shuffle : ");
                    for(Student i : main.student)
                        System.out.print(i.getName()+ "  ");
                    System.out.println();
                }
                case 6 -> {
                    System.out.println("\nBefore Removal : ");
                    for(Student i : main.student)
                        System.out.print(i.getRollNo()+ "  ");
                    System.out.println();
                    System.out.print("\nEnter RollNo of Student you want to remove : ");
                    main.remove(scanner.next());
                    System.out.println("\nAfter Removal : ");
                    for(Student i : main.student)
                        System.out.print(i.getRollNo()+ "  ");
                    System.out.println();
                }
                case 7 -> {
                    scanner.nextLine();
                    System.out.print("Ënter Name of Student : ");
                    String name = scanner.nextLine();
                    main.check(name);
                }
            }
        }while (option!=0);
    }

    double calculate_avg(){
        double avg,sum=0;
        for(Student i : student)
            sum+=i.getGpa();
        return avg=sum/student.size();
    }

    void printAll(){
        for(Student i : student)
            if(i.getSem_count()>=4)
                System.out.println("\nStudent Name is : " + i.getName());
    }

    void print_3(){
        for(Student i : student)
            if(i.getGpa()>=3.31)
                System.out.println("\nStudent Name is : " + i.getName() + "\nStudent roll No is : " + i.getRollNo() + "\n");
    }

    void remove(String rollNo){
        boolean isHere=true;
        for(int i=0 ; i < student.size(); i++) {
            isHere=true;
            if (student.get(i).getRollNo().equals(rollNo))
                student.remove(i);
            else
                isHere=false;
        }
        if(!isHere)
            System.out.println("\nRoll No not found in array\n");
    }

    void check(String Name){
        for(Student i : student){
            if(i.getName().equals(Name))
                System.out.println("\nYes this name is present!\nRollNo : " + i.getRollNo() + "\nGpa : "+ i.getGpa() + "\n");
        }
    }

}
