public class Box <E> {

    E label;

    Box(E label){
        this.label = label;
    }

    public E getLabel() {
        return label;
    }
}
