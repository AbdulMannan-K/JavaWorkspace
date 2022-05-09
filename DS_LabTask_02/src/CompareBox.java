import java.util.List;

public class CompareBox <T extends Comparable<T>> {

    List<T> boxes;

    T findHighest(T item){
        T highest=boxes.get(0);
        for(int i=0 ; i < boxes.size() ; i++){
            if(boxes.get(0).compareTo(highest) > 0)
                highest=boxes.get(i);
        }

        return highest;
    }

}
