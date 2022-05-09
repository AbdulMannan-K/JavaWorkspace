import java.util.List;

public class Iterator <E,T>{

    List<E> collection;
    T index;

    Iterator(List<E> object,T index){
        this.collection= object;
        this.index=index;
    }

    public List<E> getCollection() {
        return collection;
    }

    public boolean hasNext(){
        return !index.equals(collection.size() - 1);
    }

    public E next(){
        return collection.get((Integer)index+1);
    }

    public void setIndex(T index) {
        this.index = index;
    }
}
