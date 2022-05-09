import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Student student ;
        System.out.println("Enter \n1- PhdStudent \n2- Graduate Student : ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        switch(choice){
            case 1 -> student= new phdStudent();
            case 2 -> student = new gradStudents();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        student.Exam();
    }

}
