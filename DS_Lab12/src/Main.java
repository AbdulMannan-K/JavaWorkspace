import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PrimaryNumerBased tree = new PrimaryNumerBased();
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.displayPostOrder();
        tree.check(4);
        System.out.println();
        tree.displayPostOrder();
    }

}
