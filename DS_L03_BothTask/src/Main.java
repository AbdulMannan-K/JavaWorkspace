import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CustomArrayList<Integer> arrayList = new CustomArrayList<>(3);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(23);
        for(Object integer : arrayList.getArray()){
            System.out.println(integer);
        }
        System.out.println("Enter which object to remove : ");
        Scanner scanner = new Scanner(System.in);
        arrayList.remove(scanner.nextInt());
        for(Object integer : arrayList.getArray()){
            System.out.println(integer);
        }
        System.out.println("New Size : " + arrayList.getArray().length);
    }

}
