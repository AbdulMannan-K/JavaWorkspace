import java.util.ArrayList;

public class Node <T>{
    
    private T data;
    private ArrayList<Node<T>> childs;
    private Node<T> parent;
    
    public Node(T data){
        this.data=data;
        childs = new ArrayList<>();
    }

    public ArrayList<Node<T>> getChilds() {
        return childs;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setChilds(ArrayList<Node<T>> childs) {
        this.childs = childs;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}
