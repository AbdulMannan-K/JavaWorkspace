import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abdul Mannan
// i200905

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer, Integer> iterator = new Iterator<Integer, Integer>(list, 0);
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        ArrayList<Box<Integer>> integerBoxes = new ArrayList<>();
        ArrayList<Box<String>> stringBoxes = new ArrayList<>();
        ArrayList<Box<Double>> doubleBoxes = new ArrayList<>();

        integerBoxes.add(new Box<>(23));
        integerBoxes.add(new Box<>(12));
        integerBoxes.add(new Box<>(34));
        integerBoxes.add(new Box<>(9));
        integerBoxes.add(new Box<>(123)); // All Interger boxed here

        stringBoxes.add(new Box<>("Helkfls")); // All String Boxes here

        doubleBoxes.add(new Box<>(12.34));// All double boxed here

        Iterator<Box<Integer>, Integer> boxIterator = new Iterator<Box<Integer>, Integer>(integerBoxes, -1);

        while (boxIterator.hasNext()) {
            System.out.println(boxIterator.next().getLabel());
            boxIterator.setIndex(boxIterator.index + 1);
        }

        Iterator<Box<String>, Integer> stringBoxIterator = new Iterator<>(stringBoxes,-1);
        while (stringBoxIterator.hasNext()) {
            System.out.println(stringBoxIterator.next().getLabel());
            stringBoxIterator.setIndex(stringBoxIterator.index + 1);
        }

        // Same for double

    }


}
