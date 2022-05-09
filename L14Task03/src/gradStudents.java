import java.util.Scanner;

public class gradStudents extends Student{

    @Override
    public void Exam() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Roll Number : ");
        String rollNo = scan.next();
        System.out.println("What is capital of Pakistan : ");
        String ans1 = scan.next();
        System.out.println("What is capital of Israel : ");
        String ans2 = scan.next();
        System.out.println("What is capital of Dubai : ");
        String ans3 = scan.next();
    }
}
