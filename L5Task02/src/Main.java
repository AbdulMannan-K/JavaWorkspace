import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of courses : ");
        int noCourse = scan.nextInt();
        Student gpa = new Student(noCourse);
        gpa.calGPA();
        System.out.println("You gpa is : " + gpa.getGpa());

    }

}
