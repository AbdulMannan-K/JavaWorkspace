import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        vision TV1 = new vision();
        System.out.println();

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Length of TV : ");
        int length = scan.nextInt();
        System.out.print("Enter Width of TV : ");
        int width = scan.nextInt();
        vision TV2 = new vision(length,width);
        System.out.println();

        System.out.print("Enter Length of TV in decimal : ");
        double flength = scan.nextDouble();
        System.out.print("Enter Width of TV in deciaml : ");
        double fwidth = scan.nextDouble();
        vision TV3 = new vision(flength,fwidth);
        System.out.println();

        System.out.print("Enter Length of TV : ");
        length = scan.nextInt();
        vision TV4 = new vision(length);
        System.out.println();

    }
}
