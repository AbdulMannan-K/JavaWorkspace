import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        BST<Integer> tree = new BST<>();
//        tree.insert(5);
//        tree.insert(6);
//        tree.insert(7);
//        tree.insert(2);
//        tree.insert(3);
//        tree.insert(9);
//        tree.displayInOrder();
//        System.out.println();
//        tree.displayPostOrder();
//        System.out.println();
//        tree.displayPreOrder();
//
//        System.out.println();
//        DataBase db = new DataBase();
////        db.accounts.insert(new City(1234,"sd","sad",32));
////        db.accounts.insert(new City(923,"sd","sad",32));
////        db.accounts.insert(new City(1239834,"sd","sad",32));
////        db.accounts.
//        db.insert(new City(1234,"sd","sad",32));
//        db.insert(new City(234,"sd","sad",32));
//        db.insert(new City(23498,"sd","sad",32));
//        db.displayInOrder();

        DataBase db = new DataBase();
        db.insert(new City(32,"H","sd",1234));
        db.insert(new City(2,"H","sad",234));
        db.insert(new City(5,"H","sad",234));
        db.insert(new City(6,"H","sad",234));
        db.insert(new City(7,"H","sad",234));
        db.insert(new City(8,"H","sad",234));
        db.insert(new City(9,"H","sad",234));
        db.insert(new City(10,"H","jkgku",324));
        db.insert(new City(132,"H","ssd",123));
        db.insert(new City(3,"B","sdwqe",983));
        db.insert(new City(42,"A","sdqw",10392));
        db.displayInOrder();
        System.out.println();
        ArrayList<Node<City>> cities = db.retrieveByCountry("H");
        for(Node<City> city : cities){
            System.out.println(city.getData().getCityName());
        }
//        db.deleteNode(234);
//        cities = db.retrieveByCountry("H");
//        for(Node<City> city : cities){
//            System.out.println(city.getData().getCityName());
//        }
        System.out.println();
        db.displayInOrder();
        System.out.println();
        System.out.println(db.bb());
    }

}
