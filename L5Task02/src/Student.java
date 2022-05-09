import java.util.Scanner;

public class Student {

    private int noCourse;
    private double gpa;
    private int credit;

    void setNoCourse(int noCourse){
        this.noCourse=noCourse;
    }

    int getNoCourse(){
        return noCourse;
    }

    void setGpa(double gpa){
        this.gpa = gpa;
    }

    double getGpa(){
        return gpa;
    }

    void setCredit(int credit){
        this.credit=credit;
    }

    int getCredit(){
        return credit;
    }

    Student(){
        setNoCourse(8);
    }

    Student(int noCourse){
        setNoCourse(noCourse);
    }

    void calGPA(){
        double[] courses = new double[getNoCourse()];
        Scanner scan = new Scanner(System.in);
        int totalcredits=0;
        for(int i=0 ; i < getNoCourse() ; i++){
            System.out.print("Enter grade point of " + (i+1) + " course : ");
            courses[i]  = scan.nextDouble();
            System.out.print("Enter credit hours of " + (i+1) + " course : ");
            setCredit(scan.nextInt());
            totalcredits+=getCredit();
            setGpa(getGpa()+(getCredit()*courses[i]));
            System.out.println();
        }
        setGpa(getGpa()/totalcredits);
    }

}
